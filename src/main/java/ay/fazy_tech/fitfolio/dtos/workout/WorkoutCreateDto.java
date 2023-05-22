package ay.fazy_tech.fitfolio.dtos.workout;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class WorkoutCreateDto {
   private String workoutTemplateId;
   private String clientId;
   private String duration;
}
