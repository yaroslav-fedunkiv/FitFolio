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
    private Double result;
    @Column
    private Double previousResult;
    @Column
    private double weight;
    @Enumerated(EnumType.STRING)
    @Column
    private Unit unit;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime created;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updated;
    @Column(columnDefinition = "boolean default true")
    private boolean isActive;
}
