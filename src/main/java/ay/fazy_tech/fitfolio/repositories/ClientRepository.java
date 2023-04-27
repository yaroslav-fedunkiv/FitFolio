package ay.fazy_tech.fitfolio.repositories;

import ay.fazy_tech.fitfolio.model.Client;
import ay.fazy_tech.fitfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long>  {

//    @Query(value = "select c from client c where c.id = ?1")
//    User findClientByEmail(@Param(value = "id") String id);

}
