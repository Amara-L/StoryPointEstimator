package jhack.spe.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "session")
public class SessionEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "session_seq")
    @SequenceGenerator(name = "session_seq",
            sequenceName = "session_seq", allocationSize = 1)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "story_point_id")
    @Getter
    @Setter
    private Integer storyPointId;

    @Column(name = "creator_id")
    @Getter
    @Setter
    private Integer ownerId;

    @Column(name = "process")
    @Getter
    @Setter
    private Boolean isProcess;

    @Column(name = "final_result")
    @Getter
    @Setter
    private Integer finalResult;

    @Column(name = "created_at")
    @Getter
    @Setter
    private Date created;

    @Column(name = "closed_at")
    @Getter
    @Setter
    private Date closes;

    @Column(name = "updated_at")
    @Getter
    @Setter
    private Date updated;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sessionId")
    @Getter
    @Setter
    private List<TeamMemberEntity> teamMemberEntities;

}
