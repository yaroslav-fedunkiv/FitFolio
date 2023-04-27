package ay.fazy_tech.fitfolio.repositories;

import ay.fazy_tech.fitfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>  {
    User findUserByEmail(String email);

}
