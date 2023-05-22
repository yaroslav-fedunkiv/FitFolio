package ay.fazy_tech.fitfolio.dtos.exercise;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExerciseFullDto {
    private String id;
    private String exerciseTemplateId;
    private String workoutId;
    private String create;
    private String update;
    private String isActive;
}
