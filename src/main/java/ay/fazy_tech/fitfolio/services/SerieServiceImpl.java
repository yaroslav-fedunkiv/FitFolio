package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.serie.SerieCreateDto;
import ay.fazy_tech.fitfolio.dtos.serie.SerieFullDto;
import ay.fazy_tech.fitfolio.model.Exercise;
import ay.fazy_tech.fitfolio.model.Serie;
import ay.fazy_tech.fitfolio.model.Unit;
import ay.fazy_tech.fitfolio.repositories.ExerciseRepository;
import ay.fazy_tech.fitfolio.repositories.SerieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class SerieServiceImpl implements SerieService{
    private final SerieRepository serieRepository;
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper mapper;

    @Override
    public SerieFullDto createSerie(SerieCreateDto serieCreateDto) { //fixme
        Serie serie = mapper.map(serieCreateDto, Serie.class);
        Exercise exercise = exerciseRepository.findById(serieCreateDto.getExerciseId()).orElseThrow();
        serie.setExercise(exercise);
        serieRepository.save(serie);
        return mapper.map(serie, SerieFullDto.class);
    }

    @Override
    public void updateSerie(SerieCreateDto updatedSerie, String id) {
        Serie serie = serieRepository.findById(Long.parseLong(id)).orElseThrow();
        String previousReps = (updatedSerie.getPreviousResult() == null || updatedSerie.getPreviousResult().equals("")
                ? String.valueOf(serie.getPreviousResult()) : updatedSerie.getPreviousResult());
        String reps = (updatedSerie.getResult() == null || updatedSerie.getResult().equals("")
                ? String.valueOf(serie.getResult()) : updatedSerie.getResult());
        String weight = (updatedSerie.getWeight() == null || updatedSerie.getWeight().equals("")
                ? String.valueOf(serie.getWeight()) : updatedSerie.getWeight());
        String unit = (updatedSerie.getUnit() == null || updatedSerie.getUnit().equals("")
                ? serie.getUnit().toString() : updatedSerie.getUnit());

        serie.setPreviousResult(Double.parseDouble(previousReps));
        serie.setResult(Double.parseDouble(reps));
        serie.setWeight(Double.parseDouble(weight));
        serie.setUnit(Unit.valueOf(unit));

        serieRepository.save(serie);
    }

    @Override
    public List<SerieFullDto> getAll() {
        return serieRepository.findAll().stream()
                .map(el -> mapper.map(el, SerieFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SerieFullDto getById(String id) {
        return mapper.map(serieRepository.findById(Long.parseLong(id)), SerieFullDto.class);
    }

    @Override
    public void deleteSerie(String id) {
        serieRepository.deleteById(Long.parseLong(id));
    }
}
