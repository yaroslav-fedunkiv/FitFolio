package ay.fazy_tech.fitfolio.dtos.exercise;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExerciseCreateDto {
    private Long exerciseTemplateId;
    private Long workoutId;
}
