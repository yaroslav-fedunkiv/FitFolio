package ay.fazy_tech.fitfolio.repositories;

import ay.fazy_tech.fitfolio.model.WorkoutTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anna Zelener
 */
public interface WorkoutTemplateRepository extends JpaRepository<WorkoutTemplate, Long> {
}
