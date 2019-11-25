package jhack.spe.services;

import jhack.spe.dao.entities.SessionEntity;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImp implements SessionService {

    /**
     * Getting session by id.
     *
     * @param sessionId id session
     * @return session object
     */
    @Override
    public SessionEntity getSession(Integer sessionId) {
        return null;
    }

    /**
     * Method create session.
     *
     * @param storyPointId id story point
     * @param userId       id user creator
     * @return session object
     */
    @Override
    public SessionEntity createSession(Integer storyPointId, Integer userId) {
        return null;
    }

    /**
     * Close session.
     *
     * @param sessionId session id
     * @return result closed session
     */
    @Override
    public boolean closeSession(Integer sessionId) {
        return false;
    }

    /**
     * Join member to session.
     *
     * @param sessionId session id
     * @param userId    user id
     * @return session object
     */
    @Override
    public SessionEntity joinMember(Integer sessionId, Integer userId) {
        return null;
    }

    /**
     * Method send message on e-mail with session link
     *
     * @param sessionId session id
     * @param mail      mail user
     * @return session object
     */
    @Override
    public SessionEntity inviteMember(Integer sessionId, String mail) {
        return null;
    }

    /**
     * Save result estimate.
     *
     * @param teamMemberId id team member
     * @param result       result estimate
     * @return session object
     */
    @Override
    public SessionEntity saveEstimate(Integer teamMemberId, Integer result) {
        return null;
    }

}
