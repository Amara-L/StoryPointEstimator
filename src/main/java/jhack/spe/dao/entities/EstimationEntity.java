package jhack.spe.dao.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class EstimationEntity {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private TeamMemberEntity teamMemberEntity;

    @Getter
    @Setter
    private Integer result;

    @Getter
    @Setter
    private Date created;

}
