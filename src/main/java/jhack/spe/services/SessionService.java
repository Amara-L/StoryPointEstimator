package jhack.spe.services;

import jhack.spe.controllers.exception.SendFailedException;
import jhack.spe.controllers.exception.StoryPointEstimatorException;
import jhack.spe.entities.EstimationEntity;
import jhack.spe.entities.SessionEntity;

public interface SessionService {

    /**
     * Getting session by id.
     *
     * @param sessionId id session
     * @return session object
     */
    SessionEntity getSession(Integer sessionId) throws StoryPointEstimatorException;

    /**
     * Method create session.
     *
     * @param storyPointId id story point
     * @param userId id user creator
     * @return session object
     */
    SessionEntity createSession(Integer storyPointId, Integer userId) throws StoryPointEstimatorException;

    /**
     * Close session.
     *
     * @param sessionId session id
     * @return result closed session
     */
    boolean closeSession(Integer sessionId) throws StoryPointEstimatorException;

    /**
     * Join member to session.
     *
     * @param sessionId session id
     * @param userId user id
     * @return session object
     */
    SessionEntity joinMember(Integer sessionId, Integer userId) throws StoryPointEstimatorException;

    /**
     * Method send message on e-mail with session link
     *
     * @param sessionId session id
     * @param mail mail user
     * @return session object
     */
    SessionEntity inviteMember(Integer invitingUserId, Integer sessionId, String mail) throws StoryPointEstimatorException, SendFailedException;

    /**
     * Save result estimate.
     *
     * @param userId id team member
     * @param result result estimate
     * @return estimation object
     */
    EstimationEntity saveEstimate(Integer sessionId, Integer userId, Integer result);

}
