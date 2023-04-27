package ay.fazy_tech.fitfolio.dtos.coach;

import ay.fazy_tech.fitfolio.model.Client;
import ay.fazy_tech.fitfolio.model.WorkoutProgram;
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

public class CoachFullDto {
    private String id;
    private String user;
    private List<Client> clients;
    private List<WorkoutProgram> workoutPrograms;
}
