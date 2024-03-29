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
public class ExerciseTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_template_id")
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String image;
    @Column
    @Enumerated(EnumType.STRING)
    private BodyPart bodyPart;
    @Column
    @Enumerated(EnumType.STRING)
    private Category category;
    @OneToMany(mappedBy = "exerciseTemplate")
    private List<Exercise> exercise;
    @ManyToMany(mappedBy = "exerciseTemplates")
    private List<Client> clients;
    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;
}
