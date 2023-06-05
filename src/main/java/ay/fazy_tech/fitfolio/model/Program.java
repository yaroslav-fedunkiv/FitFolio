package ay.fazy_tech.fitfolio.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@DynamicInsert
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programs_id")
    private Long id;
    @Column(name = "workout_program_id")
    private Long workoutProgramId;
    @Column(name = "workout_template_id")
    private Long workoutTemplateId;
}