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
    Optional<UserFullDto> createUser(UserCreateDto userCreateDto);
    UserFullDto deactivateUser(String id);
    Optional<UserFullDto> getUserById(String id);
    Optional<UserFullDto> getUserByEmail(String email);
    UserUpdateDto updateUser(UserUpdateDto userUpdateDto, String id);
    List<UserFullDto> getAllUsers();
    boolean isStatusActive(String id);
    boolean subscribe(Long followerId, Long userId);
}
