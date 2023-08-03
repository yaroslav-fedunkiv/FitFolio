package ay.fazy_tech.fitfolio.dtos.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserFullDto {
    private Long id;
    private String fullName;
    private String userRole;
    private String email;
    private String currentClientId;
    private String password;
    private String created;
    private String updated;
    private String isActive;
    private String userName;
}
