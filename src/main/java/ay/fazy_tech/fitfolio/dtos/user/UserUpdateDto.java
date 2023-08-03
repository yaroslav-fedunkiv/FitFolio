package ay.fazy_tech.fitfolio.dtos.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserUpdateDto {
    private String newEmail;
    private String fullName;
}
