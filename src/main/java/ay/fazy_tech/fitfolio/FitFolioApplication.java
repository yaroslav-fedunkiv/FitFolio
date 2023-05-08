package ay.fazy_tech.fitfolio;

import ay.fazy_tech.fitfolio.dtos.client.ClientCreateDto;
import ay.fazy_tech.fitfolio.dtos.client.ClientFullDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateFullDto;
import ay.fazy_tech.fitfolio.dtos.user.UserCreateDto;
import ay.fazy_tech.fitfolio.dtos.user.UserFullDto;
import ay.fazy_tech.fitfolio.dtos.workout_template.WorkoutTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.workout_template.WorkoutTemplateFullDto;
import ay.fazy_tech.fitfolio.model.BodyPart;
import ay.fazy_tech.fitfolio.model.Category;
import ay.fazy_tech.fitfolio.model.Exercise;
import ay.fazy_tech.fitfolio.model.ExerciseTemplate;
import ay.fazy_tech.fitfolio.repositories.ExerciseRepository;
import ay.fazy_tech.fitfolio.services.*;
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
    CommandLineRunner init(ClientService clientService, UserService userService,
                           ExerciseTemplateService exerciseTemplateService, WorkoutTemplateService workoutTemplateService) {
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

            UserFullDto user = userService.getUserByEmail(userCreateDto.getEmail()).orElseThrow();

            System.out.println(user);
            ClientCreateDto clientCreateDto = new ClientCreateDto();

            clientCreateDto.setUserId(user.getId());
            clientService.createClient(clientCreateDto);


            ExerciseTemplateCreateDto exerciseTemplate = new ExerciseTemplateCreateDto();

            exerciseTemplate.setTitle("Pull up");
            exerciseTemplate.setDescription("Do Pull up right");
            exerciseTemplate.setImage("some image");
            exerciseTemplate.setBodyPart("ARMS");
            exerciseTemplate.setCategory("REPS_ONLY");
            exerciseTemplateService.createExerciseTemplate(exerciseTemplate);

            ExerciseTemplateFullDto exerciseTemplateFullDto = exerciseTemplateService.getExerciseTemplate("1");

            System.out.println(exerciseTemplateFullDto);

            WorkoutTemplateCreateDto workoutTemplateCreateDto = new WorkoutTemplateCreateDto();

            workoutTemplateCreateDto.setTitle("First Workout");
            workoutTemplateCreateDto.setDescription("Best Workout ever!!!");

            //WorkoutTemplateFullDto workoutTemplateFullDto = workoutTemplateService.getWorkoutTemplate("1");
            //System.out.println(workoutTemplateFullDto);
        };
    }

}
