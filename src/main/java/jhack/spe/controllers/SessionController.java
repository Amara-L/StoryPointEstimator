package jhack.spe.controllers;

import jhack.spe.controllers.exception.SendFailedException;
import jhack.spe.controllers.exception.StoryPointEstimatorException;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * Interface session controller.
 */
public interface SessionController {

    /**
     * Open the session join page.
     *
     * @return name jsp-file
     */
    String getJoinToSession(HttpSession session);

    /**
     * Join the session (go to the session page).
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    String postJoinToSession(HttpSession session, Model model, String sessionId);

    /**
     * Open the session page.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    String openSession(HttpSession session, Model model, String sessionId) throws StoryPointEstimatorException;

    /**
     * Send estimate to the server.
     *
     * @param sessionId id session
     * @param estimate result estimate
     * @return name jsp-file
     */
    String sendEstimate(HttpSession session, Model model, String sessionId, Integer estimate) throws StoryPointEstimatorException;

    /**
     * Open the control session page.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    String openControlSessionPage(HttpSession session, Model model, String sessionId) throws StoryPointEstimatorException;

    /**
     * Add member.
     *
     * @param sessionId id session
     * @param mail mail new member
     * @return name jsp-file
     */
    String addMember(HttpSession session, Model model, String sessionId, String mail) throws StoryPointEstimatorException, SendFailedException;

    /**
     * Close session.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    String closeSession(HttpSession session, Model model, String sessionId) throws StoryPointEstimatorException;

    /**
     * Open the create session page.
     *
     * @return name jsp-file
     */
    String getCreateSession(HttpSession session, Model model);

    /**
     * Create session (go to the session page).
     *
     * @param storyPointId id story point
     * @return name jsp-file
     */
    String postCreateSession(HttpSession session, Model model, String storyPointId) throws StoryPointEstimatorException;

}
