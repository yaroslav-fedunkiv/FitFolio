package ay.fazy_tech.fitfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@DynamicInsert
public class WorkoutProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_program_id")
    private Long id;

    @Column
    private String title;

//    @ManyToOne
//    @JoinColumn(name="coach_id", nullable=false)
//    private Coach coach;

    @ManyToMany
    @JoinTable(name = "client_program",
            joinColumns = @JoinColumn(name = "workout_program_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clientEntity;

    @ManyToMany
    @JoinTable(name = "program",
            joinColumns = @JoinColumn(name = "workout_program_id"),
            inverseJoinColumns = @JoinColumn(name = "workout_template_id"))
    private List<WorkoutTemplate> workouts;
}