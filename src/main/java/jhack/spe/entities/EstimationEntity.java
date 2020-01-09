package jhack.spe.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "estimation")
public class EstimationEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "estimation_seq")
    @SequenceGenerator(name = "estimation_seq",
            sequenceName = "estimation_seq", allocationSize = 1)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "team_member_id")
    @Getter
    @Setter
    private Integer teamMemberId;

    @Column(name = "result")
    @Getter
    @Setter
    private Integer result;

    @Column(name = "created_at")
    @Getter
    @Setter
    private Date created;

}
