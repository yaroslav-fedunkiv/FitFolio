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

    @ManyToOne
    @JoinColumn(name="coach_id", nullable=false)
    private Coach coach;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @ManyToMany
    @JoinTable(name = "programs",
            joinColumns = @JoinColumn(name = "workout_program_id"),
            inverseJoinColumns = @JoinColumn(name = "workout_template_id"))
    private List<WorkoutTemplate> workouts;
}