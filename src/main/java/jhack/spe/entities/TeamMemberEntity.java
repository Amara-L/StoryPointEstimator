package jhack.spe.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "team_member")
public class TeamMemberEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "team_member_seq")
    @SequenceGenerator(name = "team_member_seq",
            sequenceName = "team_member_seq", allocationSize = 1)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "session_id")
    @Getter
    @Setter
    private Integer sessionId;

    @Column(name = "user_id")
    @Getter
    @Setter
    private Integer userId;

    @Column(name = "join_date")
    @Getter
    @Setter
    private Date joiningDate;

    @Column(name = "active")
    @Getter
    @Setter
    private Boolean isActive;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teamMemberId", cascade = ALL)
    @Getter
    @Setter
    private List<EstimationEntity> estimationEntities;

    @Column(name = "created_at")
    @Getter
    @Setter
    private Date created;

    @Column(name = "updated_at")
    @Getter
    @Setter
    private Date updated;

}
