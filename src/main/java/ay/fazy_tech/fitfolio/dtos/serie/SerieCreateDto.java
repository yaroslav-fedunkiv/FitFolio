package ay.fazy_tech.fitfolio.dtos.serie;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SerieCreateDto {
    private String previousResult;
    private String result;
    private String weight;
    private String unit;
    private Long exerciseId;
}
