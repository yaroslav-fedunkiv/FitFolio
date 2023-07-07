package ay.fazy_tech.fitfolio.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "user_table")
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column
    private String fullName;
    @Column
    private LocalDate dob; //date of birth
    @Column
    private double weight;
    @Column
    private int height;
    @Enumerated(EnumType.STRING)
    @Column
    private Sex sex;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20) default 'CLIENT_ROLE'")
    private Role userRole;
    @Column
    private String email;

    @Column
    private String userName;

    @OneToOne(mappedBy = "user")
    private Client currentClient;

    @OneToOne(mappedBy = "user")
    private Coach coach;
    @OneToMany(mappedBy = "user")
    private List<Subscriber> subscriberList;
    @OneToMany(mappedBy = "user")
    private List<Follower> followerList;
    @Column
    private String password;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime created;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updated;
    @Column(columnDefinition = "boolean default true")
    private boolean isActive;

}
