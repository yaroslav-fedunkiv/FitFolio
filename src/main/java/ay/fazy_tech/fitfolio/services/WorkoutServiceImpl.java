package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.workout.WorkoutCreateDto;
import ay.fazy_tech.fitfolio.dtos.workout.WorkoutFullDto;
import ay.fazy_tech.fitfolio.model.Workout;
import ay.fazy_tech.fitfolio.repositories.ClientRepository;
import ay.fazy_tech.fitfolio.repositories.WorkoutRepository;
import ay.fazy_tech.fitfolio.repositories.WorkoutTemplateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class WorkoutServiceImpl implements WorkoutService{
    private final ModelMapper mapper;
    private final WorkoutRepository workoutRepository;
    private final WorkoutTemplateRepository workoutTemplateRepository;
    private final ClientRepository clientRepository;

    @Override
    public void createWorkout(WorkoutCreateDto workoutCreateDto) {
        Workout workout = new Workout();
        workout.setWorkoutTemplate(workoutTemplateRepository
                .findById(workoutCreateDto.getWorkoutTemplateId()).orElseThrow());
        workout.setClientEntity(clientRepository
                .findById(workoutCreateDto.getClientId()).orElseThrow());
        workout.setDuration(Integer.parseInt(workoutCreateDto.getDuration()));
        workoutRepository.save(workout);
    }

    @Override
    public List<WorkoutFullDto> getAll() {
        return workoutRepository.findAll().stream()
                .map(el -> mapper.map(el, WorkoutFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public WorkoutFullDto getById(String id) {
        return mapper.map(workoutRepository.findById(Long.parseLong(id)), WorkoutFullDto.class);
    }

    @Override
    public void updateWorkout(WorkoutCreateDto updatedSerie, String id) {

    }

    @Override
    public void deleteWorkout(String id) {

    }
}
