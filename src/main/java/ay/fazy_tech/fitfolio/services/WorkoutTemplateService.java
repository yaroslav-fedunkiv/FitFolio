package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateFullDto;
import ay.fazy_tech.fitfolio.dtos.workout_template.WorkoutTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.workout_template.WorkoutTemplateFullDto;

import java.util.List;

/**
 * @author Anna Zelener
 */
public interface WorkoutTemplateService {

    void createWorkoutTemplate (WorkoutTemplateCreateDto workoutTemplateCreateDto);
    WorkoutTemplateFullDto getWorkoutTemplate (String id);
    List<WorkoutTemplateFullDto> getAllWorkoutTemplate ();

    void updateWorkoutTemplate (WorkoutTemplateCreateDto workoutTemplateCreateDto);
    void deleteWorkoutTemplate (String id);
}
