package ay.fazy_tech.fitfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@DynamicInsert
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String image;
    @Column
    private BodyPart bodyPart;
    @Column
    private Category category;

    @OneToMany(mappedBy = "exercise")
    private List<Serie> series;

    @ManyToOne
    @JoinColumn(name="workout_id", nullable=false)
    private Workout workout;

    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime created;
    @Column(columnDefinition = "timestamp default now()")
    private LocalDateTime updated;
    @Column(columnDefinition = "boolean default true")
    private boolean isActive;
}
