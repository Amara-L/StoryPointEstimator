package jhack.spe.controllers;

import org.springframework.stereotype.Controller;

/**
 * Session controller.
 */
@Controller
public class SessionControllerImp implements SessionController {

    /**
     * Open the session join page.
     *
     * @return name jsp-file
     */
    @Override
    public String getJoinToSession() {
        return null;
    }

    /**
     * Join the session (go to the session page).
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    @Override
    public String postJoinToSession(String sessionId) {
        return null;
    }

    /**
     * Open the session page.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    @Override
    public String openSession(String sessionId) {
        return null;
    }

    /**
     * Send estimate to the server.
     *
     * @param sessionId      id session
     * @param resultEstimate result estimate
     * @return name jsp-file
     */
    @Override
    public String sendEstimate(String sessionId, Integer resultEstimate) {
        return null;
    }

    /**
     * Open the control session page.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    @Override
    public String openControlSessionPage(String sessionId) {
        return null;
    }

    /**
     * Add member.
     *
     * @param sessionId id session
     * @param mail      mail new member
     * @return name jsp-file
     */
    @Override
    public String addMember(String sessionId, String mail) {
        return null;
    }

    /**
     * Close session.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    @Override
    public String closeSession(String sessionId) {
        return null;
    }

    /**
     * Open the create session page.
     *
     * @return name jsp-file
     */
    @Override
    public String getCreateSession() {
        return null;
    }

    /**
     * Create session (go to the session page).
     *
     * @param storyPointId id story point
     * @return name jsp-file
     */
    @Override
    public String postCreateSession(String storyPointId) {
        return null;
    }

}
