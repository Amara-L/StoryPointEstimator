package jhack.spe.services;

import jhack.spe.controllers.dto.StoryPoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Story point service.
 */
@Service
public class StoryPointServiceImp implements StoryPointService {

    //TODO Stub
    /**
     * Getting all story points from backlog by id user.
     *
     * @param userId id user
     * @return all story points user
     */
    @Override
    public List<StoryPoint> getStoryPointsUser(Integer userId) {

        List<StoryPoint> storyPoints = new ArrayList<>();
        StoryPoint storyPoint1 = new StoryPoint(0, "Story1", "Story point №1", 0);
        StoryPoint storyPoint2 = new StoryPoint(1, "Story2", "Story point №2", 0);
        StoryPoint storyPoint3 = new StoryPoint(2, "Story3", "Story point №3", 0);
        storyPoints.add(storyPoint1);
        storyPoints.add(storyPoint2);
        storyPoints.add(storyPoint3);

        return storyPoints;
    }

}
