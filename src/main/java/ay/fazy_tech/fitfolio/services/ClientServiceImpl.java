package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.client.ClientCreateDto;
import ay.fazy_tech.fitfolio.dtos.client.ClientFullDto;
import ay.fazy_tech.fitfolio.model.Client;
import ay.fazy_tech.fitfolio.model.User;
import ay.fazy_tech.fitfolio.model.Workout;
import ay.fazy_tech.fitfolio.repositories.ClientRepository;
import ay.fazy_tech.fitfolio.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
public class ClientServiceImpl implements ClientService {

    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public Optional<ClientFullDto> createClient(ClientCreateDto clientCreateDto) {
        log.info("Start method createClient with user id {}", clientCreateDto.getUserId());
        User user = userRepository.findById(clientCreateDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Client client = mapper.map(clientCreateDto, Client.class);
        client.setUser(user);
        clientRepository.save(client);
        log.info("Client with the user ID {} is created successfully", clientCreateDto.getUserId());
        log.warn("Created client --> " + clientRepository.findById(clientCreateDto.getUserId()));
        return getClientById(String.valueOf(client.getId()));
    }


    @Override
    @Transactional
    public Optional<ClientFullDto> getClientById(String id) {
        log.info("Start method getClientById with id: {}", id);
        try {
            return Optional.of(mapper.map(clientRepository.findById(Long.parseLong(id)), ClientFullDto.class));
        } catch (IllegalArgumentException ex) {
            log.info("Client with id {} wasn't found! ", id);
            throw new NoSuchElementException();
        }
    }

    @Override
    @Transactional
    public ClientFullDto updateClient(ClientFullDto clientFullDto, String id) {
        ClientFullDto fullDto = getClientById(id).orElseThrow();
        log.info("Start method updateClient by id : {}", id);
        Optional<Client> client = clientRepository.findById(Long.valueOf((fullDto.getId())));

//        List<Workout> workoutsList = clientFullDto.getWorkouts() == null ? fullDto.getWorkouts() : clientFullDto.getWorkouts();

//        client.orElseThrow().setCoaches(coachesList);
//        client.orElseThrow().setWorkouts(workoutsList);

        Client updatedClient = clientRepository.save(client.orElseThrow());
        return mapper.map(updatedClient, ClientFullDto.class);
    }

    @Transactional
    @Override
    public List<ClientFullDto> getAllClients() {
        log.info("Start getAllClients method");
        return clientRepository.findAll().stream()
                .map(e -> mapper.map(e, ClientFullDto.class))
                .collect(Collectors.toList());
    }
}
