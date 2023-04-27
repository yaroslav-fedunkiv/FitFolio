package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.client.ClientCreateDto;
import ay.fazy_tech.fitfolio.dtos.client.ClientFullDto;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Anna Zelener
 */
public interface ClientService {
    @Transactional
    Optional<ClientFullDto> createClient(ClientCreateDto clientCreateDto);

    @Transactional
    Optional<ClientFullDto> getClientById(String id);
    @Modifying
    @Transactional
    ClientFullDto updateClient(ClientFullDto clientFullDto, String id);

    @Transactional
    List<ClientFullDto> getAllClients();

}
