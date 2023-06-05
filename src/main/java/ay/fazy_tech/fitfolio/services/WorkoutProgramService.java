package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.workout.WorkoutFullDto;
import ay.fazy_tech.fitfolio.dtos.workout_program.WorkoutProgramCreateDto;
import ay.fazy_tech.fitfolio.dtos.workout_program.WorkoutProgramFullDto;

import java.util.List;

public interface WorkoutProgramService {
    void createWorkoutProgram(WorkoutProgramCreateDto workoutProgramCreateDto);
    void createProgram(Long workoutProgramId, Long workoutTemplateId);
    List<WorkoutProgramFullDto> getAll();
    WorkoutFullDto getById(String id);
    void updateWorkoutProgram(WorkoutProgramCreateDto updatedSerie, String id);
    void deleteWorkoutProgram(String id);
}