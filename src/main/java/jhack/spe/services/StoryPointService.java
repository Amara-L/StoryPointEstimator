package jhack.spe.services;

import jhack.spe.entities.StoryPointEntity;

import java.util.List;

/**
 * Interface story point service.
 */
public interface StoryPointService {

    /**
     * Getting all story points from backlog by id user.
     * @param userId id user
     * @return all story points user
     */
    List<StoryPointEntity> getStoryPointsUser(Integer userId);

}
