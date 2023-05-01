package ay.fazy_tech.fitfolio;

import ay.fazy_tech.fitfolio.dtos.client.ClientCreateDto;
import ay.fazy_tech.fitfolio.dtos.client.ClientFullDto;
import ay.fazy_tech.fitfolio.dtos.user.UserCreateDto;
import ay.fazy_tech.fitfolio.dtos.user.UserFullDto;
import ay.fazy_tech.fitfolio.services.ClientService;
import ay.fazy_tech.fitfolio.services.SerieService;
import ay.fazy_tech.fitfolio.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FitFolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitFolioApplication.class, args);
    }
    @Bean()
    CommandLineRunner init(ClientService clientService, UserService userService) {
        return args -> {
            UserCreateDto userCreateDto = new UserCreateDto();
            userCreateDto.setFullName("Ann Zelener");
            userCreateDto.setUserName("zelenka");
            userCreateDto.setUserRole("CLIENT_ROLE");
            userCreateDto.setEmail("zelener@gmail.com");
            userCreateDto.setSex("FEMALE");
            userCreateDto.setDob("2000-01-01");
            userCreateDto.setHeight("170");
            userCreateDto.setPassword("Password12345");
            userCreateDto.setPasswordConfirmed("Password12345");
            userService.createUser(userCreateDto);

//            UserFullDto user = userService.getUserByEmail(userCreateDto.getEmail()).orElseThrow();
//
//            System.out.println(user);
//            ClientCreateDto clientCreateDto = new ClientCreateDto();
//
//            clientCreateDto.setUserId(user.getId());
//            clientService.createClient(clientCreateDto);
        };
    }

}
