package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.workout.WorkoutCreateDto;
import ay.fazy_tech.fitfolio.dtos.workout.WorkoutFullDto;

import java.util.List;

public interface WorkoutService {
    void createWorkout(WorkoutCreateDto workoutCreateDto);
    List<WorkoutFullDto> getAll();
    WorkoutFullDto getById(String id);
    void updateWorkout(WorkoutCreateDto updatedSerie, String id);
    void deleteWorkout(String id);
}