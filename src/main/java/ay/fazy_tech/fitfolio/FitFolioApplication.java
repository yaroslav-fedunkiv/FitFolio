package ay.fazy_tech.fitfolio;

import ay.fazy_tech.fitfolio.dtos.client.ClientCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise.ExerciseCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateFullDto;
import ay.fazy_tech.fitfolio.dtos.serie.SerieCreateDto;
import ay.fazy_tech.fitfolio.dtos.user.UserCreateDto;
import ay.fazy_tech.fitfolio.dtos.user.UserFullDto;
import ay.fazy_tech.fitfolio.dtos.workout.WorkoutCreateDto;
import ay.fazy_tech.fitfolio.dtos.workout_template.WorkoutTemplateCreateDto;
import ay.fazy_tech.fitfolio.services.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log4j2
public class FitFolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitFolioApplication.class, args);
    }

    @Bean()
    CommandLineRunner init(ClientService clientService, UserService userService,
                           ExerciseTemplateService exerciseTemplateService, WorkoutTemplateService workoutTemplateService,
                           WorkoutService workoutService, ExerciseService exerciseService, SerieService serieService) {
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

            log.info(user);
            ClientCreateDto clientCreateDto = new ClientCreateDto();
            log.info("userID ===>> " + user.getId());
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

            log.info(exerciseTemplateFullDto);

            WorkoutTemplateCreateDto workoutTemplateCreateDto = new WorkoutTemplateCreateDto();

            workoutTemplateCreateDto.setTitle("First Workout");
            workoutTemplateCreateDto.setDescription("Best Workout ever!!!");
            workoutTemplateService.createWorkoutTemplate(workoutTemplateCreateDto);

            WorkoutCreateDto workoutDto = new WorkoutCreateDto(1L, 1L, "564");
            workoutService.createWorkout(workoutDto);

            ExerciseCreateDto exerciseDto = new ExerciseCreateDto(1L, 1L);
            exerciseService.createExercise(exerciseDto);

            SerieCreateDto serieDto = new SerieCreateDto("0", "20", "0", "REPS", 1L);
            serieService.createSerie(serieDto);


        };
    }

}
