package ay.fazy_tech.fitfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@DynamicInsert
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="workout_template_id", nullable=false)
    private WorkoutTemplate workoutTemplate;

    @OneToMany(mappedBy="workout")
    private List<Exercise> exercises;
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client clientEntity;

//    @ManyToMany(mappedBy = "workouts")
//    private List<WorkoutProgram> workoutPrograms;
    @Column
    private int duration; // time of doing workout
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime created;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updated;
    @Column(columnDefinition = "boolean default true")
    private boolean isActive;
}