package ay.fazy_tech.fitfolio.dtos.client;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author Anna Zelener
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientCreateDto {
//    @NotNull
//    private List<Workout> workouts;
    @NotNull
    private String userId;
//    @NotNull
//    private List<Coach> coaches;
    //    private List<WorkoutProgram> workoutProgram; //todo
}
