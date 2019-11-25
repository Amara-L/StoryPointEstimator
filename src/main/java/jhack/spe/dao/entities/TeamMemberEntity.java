package jhack.spe.dao.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

public class TeamMemberEntity {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private SessionEntity sessionEntity;

    @Getter
    @Setter
    private Integer userId;

    @Getter
    @Setter
    private Date joiningDate;

    @Getter
    @Setter
    private Boolean active;

    @Getter
    @Setter
    private List<EstimationEntity> estimationEntities;

}
