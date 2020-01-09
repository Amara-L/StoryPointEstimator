package jhack.spe.repository;

import jhack.spe.entities.EstimationEntity;

import java.util.List;

public interface EstimationRepository {

    List<EstimationEntity> findAllByTeamMemberId(Integer teamMemberId);

    EstimationEntity save(EstimationEntity estimationEntity);

    EstimationEntity findById(Integer id);

}
