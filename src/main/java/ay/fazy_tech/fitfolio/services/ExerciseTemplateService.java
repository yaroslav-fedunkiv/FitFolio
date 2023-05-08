package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateFullDto;

import java.util.List;

/**
 * @author Anna Zelener
 */
public interface ExerciseTemplateService {

    void createExerciseTemplate (ExerciseTemplateCreateDto exerciseTemplateCreateDto);
    ExerciseTemplateFullDto getExerciseTemplate (String id);
    List<ExerciseTemplateFullDto> getAllExerciseTemplate ();

    void updateExerciseTemplate (ExerciseTemplateCreateDto exerciseTemplateCreateDto);
    void deleteExerciseTemplate (String id);
}
