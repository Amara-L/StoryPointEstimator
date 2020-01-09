package jhack.spe.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "story_point")
public class StoryPointEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "story_point_seq")
    @SequenceGenerator(name = "story_point_seq",
            sequenceName = "story_point_seq", allocationSize = 1)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "user_id")
    @Getter
    @Setter
    private Integer userId;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @Column(name = "created_at")
    @Getter
    @Setter
    private Date created;

}
