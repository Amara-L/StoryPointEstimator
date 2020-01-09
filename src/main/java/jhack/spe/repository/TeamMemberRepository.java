package jhack.spe.repository;

import jhack.spe.entities.TeamMemberEntity;

import java.util.List;

public interface TeamMemberRepository {

    List<TeamMemberEntity> findAllBySessionId(Integer sessionId);

    TeamMemberEntity save(TeamMemberEntity teamMemberEntity);

    TeamMemberEntity findById(Integer id);

    TeamMemberEntity findByUserIdAndSessionId(Integer userId, Integer sessionId);

}
