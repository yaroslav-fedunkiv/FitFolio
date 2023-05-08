package ay.fazy_tech.fitfolio.dtos.workout_template;

import lombok.*;

/**
 * @author Anna Zelener
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkoutTemplateCreateDto {

    private String title;
    private String description;

}
