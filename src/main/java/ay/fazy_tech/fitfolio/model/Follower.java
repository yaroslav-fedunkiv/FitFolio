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
@Table(name = "follower_table")
@DynamicInsert
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follower_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}



