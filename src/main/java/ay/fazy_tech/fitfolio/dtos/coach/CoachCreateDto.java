package ay.fazy_tech.fitfolio.dtos.coach;

import ay.fazy_tech.fitfolio.model.Client;
import ay.fazy_tech.fitfolio.model.WorkoutProgram;
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
public class CoachCreateDto {
    @NotNull
    private String user;
    @NotNull
    private List<Client> clients;
    @NotNull
    private List<WorkoutProgram> workoutPrograms;
}
