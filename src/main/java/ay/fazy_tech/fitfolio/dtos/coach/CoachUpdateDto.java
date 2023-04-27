package ay.fazy_tech.fitfolio.dtos.coach;

import ay.fazy_tech.fitfolio.model.Client;
import ay.fazy_tech.fitfolio.model.WorkoutProgram;
import lombok.*;

import java.util.List;

/**
 * @author Anna Zelener
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CoachUpdateDto {
    private List<Client> clients;
    private List<WorkoutProgram> workoutPrograms;
}
