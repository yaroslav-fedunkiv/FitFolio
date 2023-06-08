package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.workout.WorkoutFullDto;
import ay.fazy_tech.fitfolio.dtos.workout_program.WorkoutProgramCreateDto;
import ay.fazy_tech.fitfolio.dtos.workout_program.WorkoutProgramFullDto;
import ay.fazy_tech.fitfolio.model.ClientProgram;
import ay.fazy_tech.fitfolio.model.Program;
import ay.fazy_tech.fitfolio.model.WorkoutProgram;
import ay.fazy_tech.fitfolio.repositories.ClientProgramRepository;
import ay.fazy_tech.fitfolio.repositories.ProgramRepository;
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
    private final ProgramRepository programRepository;
    private final ClientProgramRepository clientProgramRepository;
    private final ModelMapper mapper;
    @Override
    public void createWorkoutProgram(WorkoutProgramCreateDto workoutProgramCreateDto) {
        workoutProgramRepository.save(mapper.map(workoutProgramCreateDto, WorkoutProgram.class));
    }

    @Override
    public void createProgram(Long workoutProgramId, Long workoutTemplateId) {
        Program program = new Program();
        program.setWorkoutProgramId(workoutProgramId);
        program.setWorkoutTemplateId(workoutTemplateId);
        programRepository.save(program);
    }

    @Override
    public void addProgramToClient(Long workoutProgramId, Long clientId) {
        ClientProgram clientProgram = new ClientProgram();
        clientProgram.setClientId(clientId);
        clientProgram.setWorkoutProgramId(workoutProgramId);
        clientProgramRepository.save(clientProgram);
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
