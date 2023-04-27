package ay.fazy_tech.fitfolio.repositories;

import ay.fazy_tech.fitfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>  {

    @Modifying(clearAutomatically = true)
    @Query(value = "update User u set isActive = 'false' where u.email = :email")
    void updateStatus(@Param(value = "email") String email);

    @Query(value = "select u from user_table u where u.email = ?1")
    User findUserByEmail(@Param(value = "email") String email);

}
