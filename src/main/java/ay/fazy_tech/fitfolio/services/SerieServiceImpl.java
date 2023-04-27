package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dto.serie.CreateSerieDto;
import ay.fazy_tech.fitfolio.dto.serie.FullSerieDto;
import ay.fazy_tech.fitfolio.model.Serie;
import ay.fazy_tech.fitfolio.model.Unit;
import ay.fazy_tech.fitfolio.repositories.SerieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class SerieServiceImpl implements SerieService{
    private final SerieRepository serieRepository;
    private final ModelMapper mapper;

    @Override
    public FullSerieDto createSerie(CreateSerieDto createSerieDto) { //fixme
        Serie serie = serieRepository.save(mapper.map(createSerieDto, Serie.class));
        return mapper.map(serie, FullSerieDto.class);
    }

    @Override
    public void updateSerie(CreateSerieDto updatedSerie, String id) {
        Serie serie = serieRepository.findById(Long.parseLong(id)).orElseThrow();
        String previousReps = (updatedSerie.getPreviousReps() == null || updatedSerie.getPreviousReps().equals("")
                ? String.valueOf(serie.getPreviousReps()) : updatedSerie.getPreviousReps());
        String reps = (updatedSerie.getReps() == null || updatedSerie.getReps().equals("")
                ? String.valueOf(serie.getReps()) : updatedSerie.getReps());
        String weight = (updatedSerie.getWeight() == null || updatedSerie.getWeight().equals("")
                ? String.valueOf(serie.getWeight()) : updatedSerie.getWeight());
        String unit = (updatedSerie.getUnit() == null || updatedSerie.getUnit().equals("")
                ? serie.getUnit().toString() : updatedSerie.getUnit());

        serie.setPreviousReps(Integer.parseInt(previousReps));
        serie.setReps(Integer.parseInt(reps));
        serie.setWeight(Double.parseDouble(weight));
        serie.setUnit(Unit.valueOf(unit));

        serieRepository.save(serie);
    }

    @Override
    public List<FullSerieDto> getAll() {
        return null;
    }

    @Override
    public FullSerieDto getById(String id) {
        return null;
    }

    @Override
    public void deleteSerie(String id) {
        serieRepository.deleteById(Long.parseLong(id));
    }
}
