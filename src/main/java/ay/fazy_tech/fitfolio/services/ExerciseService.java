package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.exercise.ExerciseCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise.ExerciseFullDto;

import java.util.List;

public interface ExerciseService {
    void createExercise(ExerciseCreateDto exerciseCreateDto);
    List<ExerciseFullDto> getAll();
    ExerciseFullDto getById(String id);
    void updateExercise(ExerciseCreateDto updatedSerie, String id);
    void deleteExercise(String id);
}