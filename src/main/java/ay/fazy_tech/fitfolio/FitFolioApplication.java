package ay.fazy_tech.fitfolio;

import ay.fazy_tech.fitfolio.dtos.client.ClientCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise.ExerciseCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateCreateDto;
import ay.fazy_tech.fitfolio.dtos.exercise_template.ExerciseTemplateFullDto;
import ay.fazy_tech.fitfolio.dtos.serie.SerieCreateDto;
import ay.fazy_tech.fitfolio.dtos.user.UserCreateDto;
import ay.fazy_tech.fitfolio.dtos.user.UserFullDto;
import ay.fazy_tech.fitfolio.dtos.workout.WorkoutCreateDto;
import ay.fazy_tech.fitfolio.dtos.workout_program.WorkoutProgramCreateDto;
import ay.fazy_tech.fitfolio.dtos.workout_template.WorkoutTemplateCreateDto;
import ay.fazy_tech.fitfolio.services.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@Log4j2
public class FitFolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitFolioApplication.class, args);
    }

    @Bean()
    CommandLineRunner init(ClientService clientService, UserService userService,
                           ExerciseTemplateService exerciseTemplateService, WorkoutTemplateService workoutTemplateService,
                           WorkoutService workoutService, ExerciseService exerciseService, SerieService serieService,
                           WorkoutProgramService workoutProgramService) {
        return args -> {
            UserCreateDto userCreateDto = new UserCreateDto();
            userCreateDto.setFullName("Ann Zelener");
            userCreateDto.setUserName("zelenka");
            userCreateDto.setUserRole("CLIENT_ROLE");
            userCreateDto.setEmail("zelener@gmail.com");
            userCreateDto.setPassword("Password12345");
            userCreateDto.setPasswordConfirmed("Password12345");
            userService.createUser(userCreateDto);
            log.info(userCreateDto);
            UserCreateDto userCreateDto2 = new UserCreateDto();
            userCreateDto2.setFullName("Yaroslav Fedunkiv");
            userCreateDto2.setUserName("yarek");
            userCreateDto2.setUserRole("CLIENT_ROLE");
            userCreateDto2.setEmail("yarek@gmail.com");
            userCreateDto2.setPassword("Password12345");
            userCreateDto2.setPasswordConfirmed("Password12345");
            userService.createUser(userCreateDto2);

            UserFullDto user = userService.getUserByEmail(userCreateDto.getEmail()).orElseThrow();
            UserFullDto user2 = userService.getUserByEmail(userCreateDto2.getEmail()).orElseThrow();

            ClientCreateDto annClient = new ClientCreateDto();
            annClient.setUserId(user.getId());
            annClient.setSex("FEMALE");
            annClient.setDob("2000-01-01");
            annClient.setWeight("55");
            annClient.setHeight("170");
            clientService.createClient(annClient);

            ClientCreateDto slavikClient = new ClientCreateDto();
            slavikClient.setUserId(user2.getId());
            slavikClient.setSex("MALE");
            slavikClient.setDob("2000-01-01");
            slavikClient.setWeight("65");
            slavikClient.setHeight("185");
            clientService.createClient(slavikClient);

            userService.subscribe(1L, 2L);
            log.info("finish subscribe process");

            ExerciseTemplateCreateDto exerciseTemplate = new ExerciseTemplateCreateDto();

            exerciseTemplate.setTitle("Pull up");
            exerciseTemplate.setDescription("Do Pull up right");
            exerciseTemplate.setImage("some image");
            exerciseTemplate.setBodyPart("ARMS");
            exerciseTemplate.setCategory("REPS_ONLY");
            exerciseTemplateService.createExerciseTemplate(exerciseTemplate);

            Optional<ExerciseTemplateFullDto> exerciseTemplateFullDto = exerciseTemplateService.getExerciseTemplate("1");

            log.info(exerciseTemplateFullDto);

            WorkoutTemplateCreateDto workoutTemplateCreateDto = new WorkoutTemplateCreateDto();

            workoutTemplateCreateDto.setDescription("Best Workout ever!!!");
            workoutTemplateService.createWorkoutTemplate(workoutTemplateCreateDto);
            workoutTemplateCreateDto.setTitle("First Workout");

            WorkoutCreateDto workoutDto = new WorkoutCreateDto(1L, 1L, "564");
            workoutService.createWorkout(workoutDto);

            ExerciseCreateDto exerciseDto = new ExerciseCreateDto(1L, 1L);
            exerciseService.createExercise(exerciseDto);

            SerieCreateDto serieDto = new SerieCreateDto("0", "20", "0", "REPS", 1L);
            serieService.createSerie(serieDto);

            WorkoutProgramCreateDto workoutProgramCreateDto = new WorkoutProgramCreateDto("New Workout Program");
            workoutProgramService.createWorkoutProgram(workoutProgramCreateDto);
            workoutProgramService.createProgram(1L, 1L);
            workoutProgramService.addProgramToClient(1L, 1L);
        };
    }

}
