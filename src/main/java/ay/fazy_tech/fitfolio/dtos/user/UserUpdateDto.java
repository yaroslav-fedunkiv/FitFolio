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
    private String weight;
    private String coachId; //todo

}
