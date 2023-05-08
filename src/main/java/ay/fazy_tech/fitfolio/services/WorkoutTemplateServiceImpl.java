package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.workout_template.WorkoutTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.workout_template.WorkoutTemplateFullDto;
import ay.fazy_tech.fitfolio.model.WorkoutTemplate;
import ay.fazy_tech.fitfolio.repositories.ExerciseTemplateRepository;
import ay.fazy_tech.fitfolio.repositories.WorkoutTemplateRepository;
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
public class WorkoutTemplateServiceImpl implements WorkoutTemplateService {

    private final ModelMapper modelMapper;
    private final WorkoutTemplateRepository workoutTemplateRepository;
    @Override
    public void createWorkoutTemplate(WorkoutTemplateCreateDto workoutTemplateCreateDto) {
        workoutTemplateRepository.save(modelMapper.map(workoutTemplateCreateDto, WorkoutTemplate.class));
    }

    @Override
    public WorkoutTemplateFullDto getWorkoutTemplate(String id) {
        WorkoutTemplate workoutTemplate = workoutTemplateRepository.findById(Long.parseLong(id)).orElseThrow();
        return modelMapper.map(workoutTemplate,WorkoutTemplateFullDto.class);
    }

    @Override
    public List<WorkoutTemplateFullDto> getAllWorkoutTemplate() {
        return null;
    }

    @Override
    public void updateWorkoutTemplate(WorkoutTemplateCreateDto workoutTemplateCreateDto) {

    }

    @Override
    public void deleteWorkoutTemplate(String id) {

    }
}
