package ay.fazy_tech.fitfolio.dtos.workout;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class WorkoutCreateDto {
   private Long workoutTemplateId;
   private Long clientId;
   private String duration;
}
