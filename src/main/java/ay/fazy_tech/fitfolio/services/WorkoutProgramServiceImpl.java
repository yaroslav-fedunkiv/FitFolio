package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.workout.WorkoutFullDto;
import ay.fazy_tech.fitfolio.dtos.workout_program.WorkoutProgramCreateDto;
import ay.fazy_tech.fitfolio.dtos.workout_program.WorkoutProgramFullDto;
import ay.fazy_tech.fitfolio.repositories.WorkoutProgramRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j2
public class WorkoutProgramServiceImpl implements WorkoutProgramService{
    private final WorkoutProgramRepository workoutProgramRepository;
    private final ModelMapper mapper;
    @Override
    public void createWorkoutProgram(WorkoutProgramCreateDto workoutProgramCreateDto) {

    }

    @Override
    public List<WorkoutProgramFullDto> getAll() {
        return null;
    }

    @Override
    public WorkoutFullDto getById(String id) {
        return null;
    }

    @Override
    public void updateWorkoutProgram(WorkoutProgramCreateDto updatedSerie, String id) {

    }

    @Override
    public void deleteWorkoutProgram(String id) {

    }
}
