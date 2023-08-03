package ay.fazy_tech.fitfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@DynamicInsert
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;
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
            joinColumns = @JoinColumn(name = "Client_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private Set<Client> followers = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "followers")
    private Set<Client> following = new HashSet<>();
    @OneToMany(mappedBy = "clientEntity")
    private List<Workout> workouts;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "clientEntity")
    private List<WorkoutProgram> workoutProgram;

    @ManyToMany
    @JoinTable(name = "clients_exercise_templates",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_template_id"))
    private List<ExerciseTemplate> exerciseTemplates;

}
