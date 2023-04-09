package ay.fazy_tech.fitfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user_table")
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(nullable = false)
    private String fullName;
    @Column
    private LocalDate dob; //date of birth
    @Column
    private double weight;
    @Column
    private int height;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sex sex;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20) default 'CLIENT_ROLE'")
    private Role userRole;
    @Column(nullable = false)
    private String email;

    @OneToOne(mappedBy = "user")
    private Client currentClient;

    @OneToOne(mappedBy = "user")
    private Coach coach;
    @Column(nullable = false)
    @Pattern(regexp = "(^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=\"])(?=\\S+$).{8,}$)|(^(?=.*\\d)(?=.*[а-я])(?=.*[А-Я])(?=.*[@#$%^&+=\"])(?=\\S+$).{8,}$)",
            message = "{user.wrong.password}")
    private String password;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime created;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updated;
    @Column(columnDefinition = "boolean default true")
    private boolean isActive;
}
