package ay.fazy_tech.fitfolio.controllers;

import ay.fazy_tech.fitfolio.dtos.user.UserCreateDto;
import ay.fazy_tech.fitfolio.dtos.user.UserFullDto;
import ay.fazy_tech.fitfolio.dtos.user.UserUpdateDto;
import ay.fazy_tech.fitfolio.exceptions.NoSuchUserFoundException;
import ay.fazy_tech.fitfolio.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author Anna Zelener
 */

@Log4j2
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @Operation(summary = "Create a new user")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "A new user is created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid data is provided. User is not created.", content = @Content)})
    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Object User is to be created") @RequestBody @Valid UserCreateDto userCreateDto) {
        log.info("Request to create a new User :{}", userCreateDto);
        userService.createUser(userCreateDto);
        return new ResponseEntity<>(": User with an email --> " + userCreateDto.getEmail() + " -- was created!", HttpStatus.OK);
    }

    @Operation(summary = "Get user by its email")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "The user is found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserFullDto.class))}),
            @ApiResponse(responseCode = "400", description = "An invalid email is provided", content = @Content),
            @ApiResponse(responseCode = "404", description = "User is not found", content = @Content)})
    @GetMapping("/get/{email}")
    public ResponseEntity<Object> getUserByEmail(@Parameter(description = "User's email to be searched") @PathVariable String email) {
        log.info("Request to getUserByEmail --> {}", email);
        try {
            if (userService.getUserByEmail(email).isEmpty()) {
                log.warn("No user is found with a given email : {} !", email);
                return new ResponseEntity<>(email + " --> An invalid email provided!", HttpStatus.BAD_REQUEST);
            } else {
                Optional<UserFullDto> user = userService.getUserByEmail(email);
                log.info("Request to get User by email :{}", email);
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        } catch (NoSuchUserFoundException e) {
            log.error("User with such an email {} doesn't exist", email);
            return new ResponseEntity<>(email + " -- User with such an email {} doesn't exist!", HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Get all users")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found all users in a database successfully"),
            @ApiResponse(responseCode = "404", description = "No users are found. No users data!")})
    @GetMapping("/all")
    public ResponseEntity<Object> findAllUsers() {
        log.info("Request to find all UserFullDto: ");
        List<UserFullDto> userList = userService.getAllUsers();
        if (!userList.isEmpty()) {
            log.info("All users are found successfully");
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            log.error("No users are found. No users data!");
            return new ResponseEntity<>("No users data is found!", HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Update user by its email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User is updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid email is provided"),
            @ApiResponse(responseCode = "404", description = "User is not found")})
    @PatchMapping(value = "/update/{email}")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserUpdateDto userUpdateDto, @PathVariable("email") String email) {
        try {
            userService.updateUser(userUpdateDto, email);
            log.info("Request to update User with an email : {}", email);
            return new ResponseEntity<>("User " + userUpdateDto.getFullName() + "with a given email --> " + email + " -- was successfully updated", HttpStatus.OK);
        } catch (NoSuchUserFoundException e) {
            log.error("User with such an email was not found!");
            return new ResponseEntity<>(email + "User with an email --> {} was not found!", HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete user by changing the status to INACTIVE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User's status is changed to INACTIVE successfully"),
            @ApiResponse(responseCode = "404", description = "User is not found!"),
            @ApiResponse(responseCode = "409", description = "User is already INACTIVE")})
    @DeleteMapping(value = "/deactivate/{email}")
    public ResponseEntity<Object> deactivateUser(@PathVariable("email") String email) {
        try {
            if (!userService.isStatusActive(email)) {
                log.warn("User {} is already deactivated!", email);
                return new ResponseEntity<>("User with an email --> " + email + " is already deactivated!", HttpStatus.CONFLICT);
            } else {
                userService.deactivateUser(email);
                log.info("Deactivate user with an email {}", email);
                return new ResponseEntity<>("User with an email -->  " + email + " was deactivated!", HttpStatus.OK);
            }
        } catch (NoSuchUserFoundException e) {
            log.error("User with an email {} doesn't exist !!! ", email);
            return new ResponseEntity<>("User with such an email --> " + email + " doesn't exist!", HttpStatus.NOT_FOUND);
        }
    }
}
