package ay.fazy_tech.fitfolio.dtos.workout;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class WorkoutFullDto {
   private String id;
   private String workoutTemplateId;
   private String clientId;
   private String duration;
   private String created;
   private String updated;
   private String isActive;
}
