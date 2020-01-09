package jhack.spe.repository;

import jhack.spe.entities.SessionEntity;

import java.util.List;

public interface SessionRepository {

    List<SessionEntity> findAllByOwnerId(Integer ownerId);

    SessionEntity save(SessionEntity sessionEntity);

    SessionEntity findById(Integer id);

}
