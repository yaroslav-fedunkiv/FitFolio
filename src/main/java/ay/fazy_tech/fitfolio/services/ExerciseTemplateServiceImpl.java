package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateFullDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateUpdateDto;
import ay.fazy_tech.fitfolio.model.ExerciseTemplate;
import ay.fazy_tech.fitfolio.repositories.ExerciseTemplateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

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
        log.info("Start getAllUsers method");
        return exerciseTemplateRepository.findAll().stream()
                .map(e -> mapper.map(e, ExerciseTemplateFullDto.class))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public ExerciseTemplateUpdateDto updateExerciseTemplateUpdate(ExerciseTemplateUpdateDto exerciseTemplateUpdateDto, String id) {
        ExerciseTemplateFullDto fullDto = getExerciseTemplate(id).orElseThrow();
        log.info("Start method updateExerciseTemplate by id : {}", id);
        Optional<ExerciseTemplate> exerciseTemplate = exerciseTemplateRepository.findById(Long.valueOf(fullDto.getId()));

        String newTitle = exerciseTemplateUpdateDto.getTitle() == null ? fullDto.getTitle() : exerciseTemplateUpdateDto.getTitle();
        String newDescription = exerciseTemplateUpdateDto.getDescription() == null ? fullDto.getDescription() : exerciseTemplateUpdateDto.getDescription();
        String newImage = exerciseTemplateUpdateDto.getImage() == null ? fullDto.getImage() : exerciseTemplateUpdateDto.getImage();

        exerciseTemplate.orElseThrow().setTitle(newTitle);
        exerciseTemplate.orElseThrow().setDescription(newDescription);
        exerciseTemplate.orElseThrow().setImage(newImage);

        ExerciseTemplate updatedExerciseTemplate = exerciseTemplateRepository.save(exerciseTemplate.orElseThrow());
        return mapper.map(updatedExerciseTemplate, ExerciseTemplateUpdateDto.class);
    }

    @Override
    public ExerciseTemplateFullDto deactivateExerciseTemplate(String id) {
        log.info("Start method deactivateExerciseTemplate with the id {}", id);
        ExerciseTemplateFullDto exerciseTemplateFullDto = getExerciseTemplate(id).orElseThrow();
        Optional<ExerciseTemplate> exerciseTemplate = exerciseTemplateRepository.findById(Long.valueOf((exerciseTemplateFullDto.getId())));
        exerciseTemplate.orElseThrow().setIsActive(false);
        ExerciseTemplate deactivatedExerciseTemplate = exerciseTemplateRepository.save(exerciseTemplate.orElseThrow());
        log.info(" ExerciseTemplate {} is deactivated", id);
        return mapper.map(deactivatedExerciseTemplate, ExerciseTemplateFullDto.class);
    }

    @Transactional
    @Override
    public boolean isStatusActive(String id) {
        log.info("Start method isStatusActive with an id {} is active", id);
        return Boolean.parseBoolean(String.valueOf(getExerciseTemplate(id).orElseThrow().getIsActive().equals("true")));
    }
}
