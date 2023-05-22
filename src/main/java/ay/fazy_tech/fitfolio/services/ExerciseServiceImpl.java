package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.exercise.ExerciseCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise.ExerciseFullDto;
import ay.fazy_tech.fitfolio.model.Exercise;
import ay.fazy_tech.fitfolio.repositories.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class ExerciseServiceImpl implements ExerciseService{
    private final ModelMapper modelMapper;
    private final ExerciseRepository exerciseRepository;

    @Override
    public void createExercise(ExerciseCreateDto exerciseCreateDto) {
        exerciseRepository.save(modelMapper.map(exerciseCreateDto, Exercise.class));
    }

    @Override
    public List<ExerciseFullDto> getAll() {
        return exerciseRepository.findAll().stream()
                .map(el -> modelMapper.map(el, ExerciseFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ExerciseFullDto getById(String id) {
        return modelMapper.map(exerciseRepository.findById(Long.parseLong(id)), ExerciseFullDto.class);
    }

    @Override
    public void updateExercise(ExerciseCreateDto updatedSerie, String id) {

    }

    @Override
    public void deleteExercise(String id) {

    }
}
