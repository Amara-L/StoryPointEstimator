package jhack.spe.dao.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

public class SessionEntity {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Integer storyPointId;

    @Getter
    @Setter
    private Integer ownerId;

    @Getter
    @Setter
    private Boolean process;

    @Getter
    @Setter
    private Integer finalResult;

    @Getter
    @Setter
    private Date created;

    @Getter
    @Setter
    private Date closes;

    @Getter
    @Setter
    private List<TeamMemberEntity> teamMemberEntities;

}
