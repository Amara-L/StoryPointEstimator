package jhack.spe.repository;

import jhack.spe.entities.StoryPointEntity;

import java.util.List;

public interface StoryPointRepository {

    List<StoryPointEntity> findAllByUserId(Integer userId);

    StoryPointEntity save(StoryPointEntity storyPointEntity);

    StoryPointEntity findById(Integer id);

}
