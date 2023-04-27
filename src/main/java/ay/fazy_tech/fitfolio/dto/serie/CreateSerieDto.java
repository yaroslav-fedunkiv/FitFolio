package ay.fazy_tech.fitfolio.dto.serie;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CreateSerieDto {
    private String previousReps;
    private String reps;
    private String weight;
    private String unit;
//    private String exercise_id;
}
