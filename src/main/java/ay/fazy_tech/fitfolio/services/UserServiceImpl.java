package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.user.UserCreateDto;
import ay.fazy_tech.fitfolio.dtos.user.UserFullDto;
import ay.fazy_tech.fitfolio.dtos.user.UserUpdateDto;
import ay.fazy_tech.fitfolio.exceptions.NoSuchUserFoundException;
import ay.fazy_tech.fitfolio.model.Client;
import ay.fazy_tech.fitfolio.model.User;
import ay.fazy_tech.fitfolio.repositories.ClientRepository;
import ay.fazy_tech.fitfolio.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class UserServiceImpl implements UserService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    @Override
    public boolean subscribe(Long followerId, Long userId) {
        Client follower = clientRepository.findById(followerId).orElseThrow();
        Client user = clientRepository.findById(userId).orElseThrow();

        follower.getFollowing().add(user);
        user.getFollowers().add(follower);

        clientRepository.save(follower);
        clientRepository.save(user);
        return true;
    }

    @Override
    @Transactional
    public Optional<UserFullDto> createUser(UserCreateDto userCreateDto) {
        log.info("Start method createUser with the email {}", userCreateDto.getEmail());
        User user = mapper.map(userCreateDto, User.class);
        log.debug("User object ==> " + user);

        userRepository.save(user);
        log.info("User with the email {} is created successfully", userCreateDto.getEmail());
        return Optional.empty();
    }

    @Transactional
    @Override
    public UserFullDto deactivateUser(String id) {
        log.info("Start method deactivateUser with the id {}", id);
        UserFullDto userDto = getUserById(id).orElseThrow();
        Optional<User> user = userRepository.findById(Long.valueOf((userDto.getId())));
        user.orElseThrow().setIsActive(false);
        User deactivatedUser = userRepository.save(user.orElseThrow());
        log.info("User {} is deactivated", id);
        return mapper.map(deactivatedUser, UserFullDto.class);
    }

    @Transactional
    @Override
    public Optional<UserFullDto> getUserById(String id) {
        log.info("Start method getUserById with the id: {}", id);
        try {
            return Optional.of(mapper.map(userRepository.findById(Long.valueOf(id)), UserFullDto.class));
        } catch (IllegalArgumentException ex) {
            log.info("User with the id {} wasn't found! ", id);
            throw new NoSuchUserFoundException();
        }
    }
    @Transactional
    @Override
    public Optional<UserFullDto> getUserByEmail(String email) {
        log.info("Start method getUserByEmail with the email: {}", email);
        try {
            return Optional.of(mapper.map(userRepository.findUserByEmail(email), UserFullDto.class));
        } catch (IllegalArgumentException ex) {
            log.info("User with the email {} wasn't found! ", email);
            throw new NoSuchUserFoundException();
        }
    }
    @Transactional
    @Override
    public UserUpdateDto updateUser(UserUpdateDto userUpdateDto, String id) {
        UserFullDto fullDto = getUserById(id).orElseThrow();
        log.info("Start method updateUser by id : {}", id);
        Optional<User> user = userRepository.findById(Long.valueOf((fullDto.getId())));

        String newFullName = userUpdateDto.getFullName() == null ? fullDto.getFullName() : userUpdateDto.getFullName();
        String newEmail = userUpdateDto.getNewEmail() == null ? fullDto.getEmail() : userUpdateDto.getNewEmail();
//        String newWeight = userUpdateDto.getWeight() == null ? fullDto.getWeight() : userUpdateDto.getWeight();

        user.orElseThrow().setEmail(newEmail);
        user.orElseThrow().setFullName(newFullName);
//        user.orElseThrow().setWeight(Double.parseDouble(newWeight));

        User updatedUser = userRepository.save(user.orElseThrow());
        return mapper.map(updatedUser, UserUpdateDto.class);
    }

    @Transactional
    @Override
    public List<UserFullDto> getAllUsers() {
        log.info("Start getAllUsers method");
        return userRepository.findAll().stream()
                .map(e -> mapper.map(e, UserFullDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public boolean isStatusActive(String id) {
        log.info("Start method isStatusActive with an id {} is active", id);
        return Boolean.parseBoolean(String.valueOf(getUserById(id).orElseThrow().getIsActive().equals("true")));
    }

}
