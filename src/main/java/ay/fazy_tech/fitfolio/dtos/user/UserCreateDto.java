package ay.fazy_tech.fitfolio.dtos.user;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCreateDto {
    @NotNull
    @Size(min = 10, max = 40)
    private String fullName;
    private String userRole;
    @NotNull
    private String userName;  //nickname
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 6, max = 20)
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})")
    private String password;
    private String passwordConfirmed;
}
