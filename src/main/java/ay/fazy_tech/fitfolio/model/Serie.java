package ay.fazy_tech.fitfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@DynamicInsert
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serie_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="exercise_id", nullable=false)
    private Exercise exercise;

    @Column
    private int reps;
    @Column
    private int previousReps;
    @Column
    private double weight;
    @Column
    private Unit unit;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime updated;

}
