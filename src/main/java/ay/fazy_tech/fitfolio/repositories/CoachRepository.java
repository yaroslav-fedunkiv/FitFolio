package ay.fazy_tech.fitfolio.repositories;

import ay.fazy_tech.fitfolio.model.Coach;
import ay.fazy_tech.fitfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CoachRepository extends JpaRepository<Coach, Long>  {

    @Query(value = "select c from coach c where c.user = ?1")
    User findCoachByUser(@Param(value = "user") String user);

}
