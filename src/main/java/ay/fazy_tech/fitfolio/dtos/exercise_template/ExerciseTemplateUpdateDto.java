package ay.fazy_tech.fitfolio.dtos.exercise_template;

import ay.fazy_tech.fitfolio.model.BodyPart;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Anna Zelener
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExerciseTemplateUpdateDto {

    private String title;
    private String description;
    private String image;
    private String bodyPart;
}
