package jhack.spe.services;

import jhack.spe.entities.StoryPointEntity;
import jhack.spe.repository.StoryPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Story point service.
 */
@Service
public class StoryPointServiceImp implements StoryPointService {

    @Autowired
    private StoryPointRepository storyPointRepository;

    /**
     * Getting all story points from backlog by id user.
     *
     * @param userId id user
     * @return all story points user
     */
    @Override
    public List<StoryPointEntity> getStoryPointsUser(Integer userId) {

        if (userId == null) return null;

        return storyPointRepository.findAllByUserId(userId);
    }

}
