package ay.fazy_tech.fitfolio.dtos.exercise_template;

import lombok.*;

/**
 * @author Anna Zelener
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExerciseTemplateCreateDto {
    private String title;
    private String description;
    private String image;
    private String bodyPart;
    private String category;

}
