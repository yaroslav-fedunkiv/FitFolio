package ay.fazy_tech.fitfolio.dtos.serie;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SerieCreateDto {
    private String previousReps;
    private String reps;
    private String weight;
    private String unit;
    private String exerciseId;
}
