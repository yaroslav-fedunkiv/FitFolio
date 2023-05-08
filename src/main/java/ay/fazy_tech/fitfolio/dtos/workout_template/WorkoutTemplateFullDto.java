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
public class WorkoutTemplateFullDto {

    private String id;
    private String title;
    private String description;
}
