package jhack.spe.services;

import jhack.spe.dao.entities.SessionEntity;

public interface SessionService {

    /**
     * Getting session by id.
     *
     * @param sessionId id session
     * @return session object
     */
    SessionEntity getSession(Integer sessionId);

    /**
     * Method create session.
     *
     * @param storyPointId id story point
     * @param userId id user creator
     * @return session object
     */
    SessionEntity createSession(Integer storyPointId, Integer userId);

    /**
     * Close session.
     *
     * @param sessionId session id
     * @return result closed session
     */
    boolean closeSession(Integer sessionId);

    /**
     * Join member to session.
     *
     * @param sessionId session id
     * @param userId user id
     * @return session object
     */
    SessionEntity joinMember(Integer sessionId, Integer userId);

    /**
     * Method send message on e-mail with session link
     *
     * @param sessionId session id
     * @param mail mail user
     * @return session object
     */
    SessionEntity inviteMember(Integer sessionId, String mail);

    /**
     * Save result estimate.
     *
     * @param teamMemberId id team member
     * @param result result estimate
     * @return session object
     */
    SessionEntity saveEstimate(Integer teamMemberId, Integer result);

}
