package jhack.spe.services;

import jhack.spe.controllers.dto.StoryPoint;

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
    List<StoryPoint> getStoryPointsUser(Integer userId);

}
