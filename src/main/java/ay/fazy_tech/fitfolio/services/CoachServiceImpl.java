package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.coach.CoachCreateDto;
import ay.fazy_tech.fitfolio.dtos.coach.CoachFullDto;
import ay.fazy_tech.fitfolio.dtos.coach.CoachUpdateDto;
import ay.fazy_tech.fitfolio.model.Client;
import ay.fazy_tech.fitfolio.model.Coach;
import ay.fazy_tech.fitfolio.model.WorkoutProgram;
import ay.fazy_tech.fitfolio.repositories.CoachRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class CoachServiceImpl implements CoachService {

    private final ModelMapper mapper;

    private final CoachRepository coachRepository;

    @Override
    @Transactional
    public Optional<CoachFullDto> createCoach(CoachCreateDto coachCreateDto) {
        log.info("Start method createCoach ");
        coachRepository.save(mapper.map(coachCreateDto, Coach.class));
        log.info("Coach with the user{} is created successfully", coachCreateDto.getUserId());
        return getCoachByUser(coachCreateDto.getUserId());
    }

    @Override
    @Transactional
    public Optional<CoachFullDto> getCoachByUser(String userId) {
        log.info("Start method getCoachByUser with the user id: {}", userId);
        try {
           return Optional.of(mapper.map(coachRepository.findById(Long.parseLong(userId)), CoachFullDto.class));
        } catch (IllegalArgumentException ex) {
            log.info("Coach with the user id {} wasn't found! ", userId);
            throw new NoSuchElementException();
        }
    }

    @Override
    @Transactional
    public CoachUpdateDto updateCoach(CoachUpdateDto coachUpdateDto, String user) {
        CoachFullDto fullDto = getCoachByUser(user).orElseThrow();
        log.info("Start method updateCoach by user : {}", user);
        Optional<Coach> coach = coachRepository.findById(Long.valueOf((fullDto.getId())));

        List<Client> clientList = coachUpdateDto.getClients() == null ? fullDto.getClients() : coachUpdateDto.getClients();
        List<WorkoutProgram> workoutProgramList = coachUpdateDto.getWorkoutPrograms() == null ? fullDto.getWorkoutPrograms() : coachUpdateDto.getWorkoutPrograms();

//        coach.orElseThrow().setClients(clientList);
//        coach.orElseThrow().setWorkoutPrograms(workoutProgramList);

        Coach updatedCoach = coachRepository.save(coach.orElseThrow());
        return mapper.map(updatedCoach, CoachUpdateDto.class);
    }

    @Override
    @Transactional
    public List<CoachFullDto> getAllCoaches() {
        log.info("Start getAllClients method");
        return coachRepository.findAll().stream()
                .map(e -> mapper.map(e, CoachFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<CoachFullDto> getAllByPages(String page) {
        Pageable pagesWithThreeElements = PageRequest.of(Integer.parseInt(page), 3);
        log.info("Start method getAllByPages");
        return coachRepository.findAll(pagesWithThreeElements)
                .stream()
                .map(e -> mapper.map(e, CoachFullDto.class))
                .collect(Collectors.toList());
    }
}
