package ay.fazy_tech.fitfolio.dtos.client;

import ay.fazy_tech.fitfolio.model.Coach;
import ay.fazy_tech.fitfolio.model.Workout;
import lombok.*;

import java.util.List;

/**
 * @author Anna Zelener
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ClientFullDto {
    private String id;
    private List<Workout> workouts;
    private String user;
    private List<Coach> coaches;
    //    private List<WorkoutProgram> workoutProgram; //todo
}
