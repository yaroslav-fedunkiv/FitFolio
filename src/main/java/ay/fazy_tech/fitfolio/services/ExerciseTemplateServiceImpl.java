package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateFullDto;
import ay.fazy_tech.fitfolio.model.ExerciseTemplate;
import ay.fazy_tech.fitfolio.repositories.ExerciseTemplateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anna Zelener
 */

@RequiredArgsConstructor
@Service
@Log4j2
public class ExerciseTemplateServiceImpl implements ExerciseTemplateService {

    private final ModelMapper modelMapper;
    private final ExerciseTemplateRepository exerciseTemplateRepository;

    @Override
    public void createExerciseTemplate(ExerciseTemplateCreateDto exerciseTemplateCreateDto) {
        exerciseTemplateRepository.save(modelMapper.map(exerciseTemplateCreateDto, ExerciseTemplate.class));
    }

    @Override
    public ExerciseTemplateFullDto getExerciseTemplate(String id) {
        ExerciseTemplate exerciseTemplate = exerciseTemplateRepository.findById(Long.parseLong(id)).orElseThrow();
        return modelMapper.map(exerciseTemplate, ExerciseTemplateFullDto.class);
    }

    @Override
    public List<ExerciseTemplateFullDto> getAllExerciseTemplate() {
        return null;
    }

    @Override
    public void updateExerciseTemplate(ExerciseTemplateCreateDto exerciseTemplateCreateDto) {

    }

    @Override
    public void deleteExerciseTemplate(String id) {

    }
}
