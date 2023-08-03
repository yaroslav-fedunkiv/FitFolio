package ay.fazy_tech.fitfolio.dtos.client;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Anna Zelener
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientCreateDto {
    @NotNull
    private Long userId;
    @NotNull
    private String sex;
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dob;
    @NotNull
    private String height;
    @NotNull
    private String weight;
}
