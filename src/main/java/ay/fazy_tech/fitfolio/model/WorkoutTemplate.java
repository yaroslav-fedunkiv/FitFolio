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
public class WorkoutTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_template_id")
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @OneToMany(mappedBy = "workoutTemplate")
    private List<Workout> workout;
    @ManyToMany(mappedBy = "workouts")
    private List<WorkoutProgram> workoutPrograms;
}
