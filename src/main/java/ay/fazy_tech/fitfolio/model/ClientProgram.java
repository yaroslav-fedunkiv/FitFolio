package ay.fazy_tech.fitfolio.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "client_program")
@DynamicInsert
public class ClientProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_program_id")
    private Long id;
    @Column(name = "workout_program_id")
    private Long workoutProgramId;
    @Column(name = "client_id")
    private Long clientId;
}