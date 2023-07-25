package ay.fazy_tech.fitfolio.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "user_table")
@DynamicInsert
public class User {
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_followers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private Set<User> followers = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "followers")
    private Set<User> following = new HashSet<>();



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20) default 'CLIENT_ROLE'")
    private Role userRole;
    @Column
    private String email;
    @Column
    private String userName;
    @OneToOne(mappedBy = "user")
    private Client currentClient;
    @Column
    private String password;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime created;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updated;
    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;

}
