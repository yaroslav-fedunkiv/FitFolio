package ay.fazy_tech.fitfolio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@DynamicInsert
public class Client {
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
    @Column(columnDefinition = "varchar(10) default 'CLIENT_ROLE'")
    private Role role;
//    @ManyToMany
    private List<WorkoutProgram> workoutProgram;

    @Column(nullable = false)
    private String email;
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
