package jhack.spe.controllers;

/**
 * Interface session controller.
 */
public interface SessionController {

    /**
     * Open the session join page.
     *
     * @return name jsp-file
     */
    String getJoinToSession();

    /**
     * Join the session (go to the session page).
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    String postJoinToSession(String sessionId);

    /**
     * Open the session page.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    String openSession(String sessionId);

    /**
     * Send estimate to the server.
     *
     * @param sessionId id session
     * @param resultEstimate result estimate
     * @return name jsp-file
     */
    String sendEstimate(String sessionId, Integer resultEstimate);

    /**
     * Open the control session page.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    String openControlSessionPage(String sessionId);

    /**
     * Add member.
     *
     * @param sessionId id session
     * @param mail mail new member
     * @return name jsp-file
     */
    String addMember(String sessionId, String mail);

    /**
     * Close session.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    String closeSession(String sessionId);

    /**
     * Open the create session page.
     *
     * @return name jsp-file
     */
    String getCreateSession();

    /**
     * Create session (go to the session page).
     *
     * @param storyPointId id story point
     * @return name jsp-file
     */
    String postCreateSession(String storyPointId);

}
