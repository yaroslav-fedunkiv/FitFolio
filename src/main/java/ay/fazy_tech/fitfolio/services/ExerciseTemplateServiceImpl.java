package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateFullDto;
import ay.fazy_tech.fitfolio.dtos.user.UserFullDto;
import ay.fazy_tech.fitfolio.model.ExerciseTemplate;
import ay.fazy_tech.fitfolio.repositories.ExerciseTemplateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Anna Zelener
 */

@RequiredArgsConstructor
@Service
@Log4j2
public class ExerciseTemplateServiceImpl implements ExerciseTemplateService {

    private final ModelMapper mapper;
    private final ExerciseTemplateRepository exerciseTemplateRepository;

    @Override
    public void createExerciseTemplate(ExerciseTemplateCreateDto exerciseTemplateCreateDto) {
        exerciseTemplateRepository.save(mapper.map(exerciseTemplateCreateDto, ExerciseTemplate.class));
    }

    @Override
    public Optional<ExerciseTemplateFullDto> getExerciseTemplate(String id) {
        log.info("Start method getExerciseTemplate with the id: {}", id);
        try {
            return Optional.of(mapper.map(exerciseTemplateRepository.findById(Long.valueOf(id)), ExerciseTemplateFullDto.class));
        } catch (IllegalArgumentException ex) {
            log.info("Exercise Template with the id {} wasn't found! ", id);
            throw new NoSuchElementException();
        }
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
