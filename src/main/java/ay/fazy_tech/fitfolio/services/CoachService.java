package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.coach.CoachCreateDto;
import ay.fazy_tech.fitfolio.dtos.coach.CoachFullDto;
import ay.fazy_tech.fitfolio.dtos.coach.CoachUpdateDto;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Anna Zelener
 */
public interface CoachService {
    @Transactional
    Optional<CoachFullDto> createCoach(CoachCreateDto coachCreateDto);

    @Transactional
    Optional<CoachFullDto> getCoachByUser(String user);
    @Modifying
    @Transactional
    CoachUpdateDto updateCoach(CoachUpdateDto coachUpdateDto, String user);

    @Transactional
    List<CoachFullDto> getAllCoaches();

    @Transactional
    List<CoachFullDto> getAllByPages(String page);
}
