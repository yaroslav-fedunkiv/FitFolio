package ay.fazy_tech.fitfolio.services;

import ay.fazy_tech.fitfolio.dtos.user.UserCreateDto;
import ay.fazy_tech.fitfolio.dtos.user.UserFullDto;
import ay.fazy_tech.fitfolio.dtos.user.UserUpdateDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    @Transactional
    Optional<UserFullDto> createUser(UserCreateDto userCreateDto);

    @Modifying
    @Transactional
    UserFullDto deactivateUser(String phoneNumber);

    @Transactional
    Optional<UserFullDto> getUserByEmail(String email);
    @Modifying
    @Transactional
    UserUpdateDto updateUser(UserUpdateDto userUpdateDto, String email);

    @Transactional
    List<UserFullDto> getAllUsers();

    boolean isStatusActive(String email);
}
