package ay.fazy_tech.fitfolio.dtos.client;

import ay.fazy_tech.fitfolio.model.Workout;
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
public class ClientFullDto {
    private String id;
    private String userId;
    private String dob;
    private String height;
    private String weight;
    private String sex;
}
