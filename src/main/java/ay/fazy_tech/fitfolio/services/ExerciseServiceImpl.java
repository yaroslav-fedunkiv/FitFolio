package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.exercise.ExerciseCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise.ExerciseFullDto;
import ay.fazy_tech.fitfolio.model.Exercise;
import ay.fazy_tech.fitfolio.model.ExerciseTemplate;
import ay.fazy_tech.fitfolio.model.Workout;
import ay.fazy_tech.fitfolio.repositories.ExerciseRepository;
import ay.fazy_tech.fitfolio.repositories.ExerciseTemplateRepository;
import ay.fazy_tech.fitfolio.repositories.WorkoutRepository;
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
    private final ModelMapper mapper;
    private final ExerciseRepository exerciseRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseTemplateRepository exerciseTemplateRepository;

    @Override
    public void createExercise(ExerciseCreateDto exerciseCreateDto) {
        Exercise exercise = mapper.map(exerciseCreateDto, Exercise.class);
        log.debug("exercise instance ==> "+exercise);
        ExerciseTemplate exerciseTemplate = exerciseTemplateRepository
                .findById(exerciseCreateDto.getExerciseTemplateId()).orElseThrow();
        Workout workout = workoutRepository.findById(exerciseCreateDto.getWorkoutId()).orElseThrow();
        exercise.setExerciseTemplate(exerciseTemplate);
        exercise.setWorkout(workout);
        exerciseRepository.save(exercise);
    }

    @Override
    public List<ExerciseFullDto> getAll() {
        return exerciseRepository.findAll().stream()
                .map(el -> mapper.map(el, ExerciseFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ExerciseFullDto getById(String id) {
        return mapper.map(exerciseRepository.findById(Long.parseLong(id)), ExerciseFullDto.class);
    }

    @Override
    public void updateExercise(ExerciseCreateDto updatedSerie, String id) {

    }

    @Override
    public void deleteExercise(String id) {

    }
}
