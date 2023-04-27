package ay.fazy_tech.fitfolio.dtos.client;

import ay.fazy_tech.fitfolio.model.Coach;
import ay.fazy_tech.fitfolio.model.Workout;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Anna Zelener
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientCreateDto {
    @NotNull
    private List<Workout> workouts;
    @NotNull
    private String user;
    @NotNull
    private List<Coach> coaches;
    //    private List<WorkoutProgram> workoutProgram; //todo
}
