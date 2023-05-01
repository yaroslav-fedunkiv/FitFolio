package ay.fazy_tech.fitfolio.dtos.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserFullDto {

    private String id;
    private String fullName;
    private String dob;
    private String weight;
    private String height;
    private String sex;
    private String userRole;
    private String email;
    private String currentClientId;
    private String password;
    private String created;
    private String updated;
    private String isActive;
    private String userName;
    private String coachId;
}
