package jhack.spe.controllers;

import jhack.spe.controllers.exception.SendFailedException;
import jhack.spe.controllers.exception.StoryPointEstimatorException;
import jhack.spe.entities.SessionEntity;
import jhack.spe.entities.StoryPointEntity;
import jhack.spe.services.SessionService;
import jhack.spe.services.StoryPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Session controller.
 */
@Controller
@RequestMapping("/session")
public class SessionControllerImp implements SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private StoryPointService storyPointService;

    /**
     * Open the session join page.
     *
     * @return name jsp-file
     */
    @Override
    @RequestMapping( value = {"/join"}, method = RequestMethod.GET)
    public String getJoinToSession(HttpSession session) {

        if (session.getAttribute("userId") != null) {

            return "joinEstimation";

        } else {
            return "login";
        }

    }

    /**
     * Join the session (go to the session page).
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    @Override
    @RequestMapping( value = {"/join"}, method = RequestMethod.POST)
    public String postJoinToSession(HttpSession session, Model model, String sessionId) {

        if (session.getAttribute("userId") != null) {

            return "redirect:/spe/session/" + sessionId;

        } else {
            return "login";
        }

    }

    /**
     * Open the session page.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    @Override
    @RequestMapping( value = {"/{sessionId}"}, method = RequestMethod.GET)
    public String openSession(HttpSession session, Model model, @PathVariable("sessionId") String sessionId) throws StoryPointEstimatorException {

        if (session.getAttribute("userId") != null) {

            SessionEntity sessionEntity = sessionService.getSession(Integer.parseInt(sessionId));

            if (sessionEntity != null) {

                if (!sessionEntity.getIsProcess()) {
                    model.addAttribute("errorMessage", "Session closed");
                    return "error";
                }

                Integer userId = Integer.parseInt(session.getAttribute("userId").toString());

                if ((sessionEntity.getOwnerId().equals(userId))
                        || (sessionEntity.getTeamMemberEntities().stream().anyMatch(t -> t.getUserId().equals(userId)))) {

                    if (!sessionEntity.getTeamMemberEntities().stream().filter(
                            t -> t.getUserId().equals(userId)).findFirst().get().getEstimationEntities().isEmpty()) {
                        model.addAttribute("errorMessage", "You have already voted");
                        return "error";
                    }

                    model.addAttribute("sessionId", sessionId);

                    return "estimation";

                } else {
                    model.addAttribute("errorMessage", "You do not have access");
                    return "error";
                }

            } else {
                model.addAttribute("errorMessage", "Session not found");
                return "error";
            }

        } else {
            return "login";
        }

    }

    /**
     * Send estimate to the server.
     *
     * @param sessionId      id session
     * @param estimate result estimate
     * @return name jsp-file
     */
    @RequestMapping( value = {"/{sessionId}"}, method = RequestMethod.POST)
    @Override
    public String sendEstimate(HttpSession session, Model model, @PathVariable String sessionId, Integer estimate) throws StoryPointEstimatorException {

        if (session.getAttribute("userId") != null) {

            SessionEntity sessionEntity = sessionService.getSession(Integer.parseInt(sessionId));

            if (sessionEntity != null) {

            if (!sessionEntity.getIsProcess()) {
                model.addAttribute("errorMessage", "Session closed");
                return "error";
            }

            Integer userId = Integer.parseInt(session.getAttribute("userId").toString());

            if ((sessionEntity.getOwnerId().equals(userId))
                    || (sessionEntity.getTeamMemberEntities().stream().anyMatch(t -> t.getUserId().equals(userId)))) {

                if (!sessionEntity.getTeamMemberEntities().stream().filter(
                        t -> t.getUserId().equals(userId)).findFirst().get().getEstimationEntities().isEmpty()) {
                    model.addAttribute("errorMessage", "You have already voted");
                    return "error";
                }

                sessionService.saveEstimate(Integer.parseInt(sessionId), userId, estimate);

                model.addAttribute("message", "Your vote has been added!");
                return "finalPage";

            } else {
                model.addAttribute("errorMessage", "You do not have access");
                return "error";
            }

            } else {
                model.addAttribute("errorMessage", "Session not found");
                return "error";
            }

        } else {
            return "login";
        }

    }

    /**
     * Open the control session page.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    @RequestMapping( value = {"/{sessionId}/control"}, method = RequestMethod.GET)
    @Override
    public String openControlSessionPage(HttpSession session, Model model, @PathVariable String sessionId) throws StoryPointEstimatorException {

        if (session.getAttribute("userId") != null) {

            SessionEntity sessionEntity
                    = sessionService.getSession(Integer.parseInt(sessionId));

            if (sessionEntity != null) {

            if (!sessionEntity.getIsProcess()) {
                model.addAttribute("errorMessage", "Session closed");
                return "error";
            }

            if (sessionEntity.getOwnerId().equals(Integer.parseInt(session.getAttribute("userId").toString()))) {

                model.addAttribute("sessionId", sessionId);
                return "controlSession";

            } else {

                model.addAttribute("errorMessage", "You do not have access");
                return "error";

            }

            } else {
                model.addAttribute("errorMessage", "Session not found");
                return "error";
            }

        } else {
            return "login";
        }

    }

    /**
     * Add member.
     *
     * @param sessionId id session
     * @param mail      mail new member
     * @return name jsp-file
     */
    @RequestMapping( value = {"/{sessionId}/control/addmember"}, method = RequestMethod.POST)
    @Override
    public String addMember(HttpSession session, Model model, @PathVariable String sessionId, String mail) throws StoryPointEstimatorException, SendFailedException {

        if (session.getAttribute("userId") != null) {

            SessionEntity sessionEntity
                    = sessionService.getSession(Integer.parseInt(sessionId));

            if (sessionEntity != null) {

            if (!sessionEntity.getIsProcess()) {
                model.addAttribute("errorMessage", "Session closed");
                return "error";
            }

            if (sessionEntity.getOwnerId().equals(Integer.parseInt(session.getAttribute("userId").toString()))) {

                sessionService.inviteMember(Integer.parseInt(session.getAttribute("userId").toString()), Integer.parseInt(sessionId), mail);

                return "redirect:/spe/session/" + sessionEntity.getId() + "/control";


            } else {

                model.addAttribute("errorMessage", "You do not have access");
                return "error";

            }

            } else {
                model.addAttribute("errorMessage", "Session not found");
                return "error";
            }

        } else {
            return "login";
        }

    }

    /**
     * Close session.
     *
     * @param sessionId id session
     * @return name jsp-file
     */
    @RequestMapping( value = {"/{sessionId}/control"}, method = RequestMethod.POST)
    @Override
    public String closeSession(HttpSession session, Model model, @PathVariable String sessionId) throws StoryPointEstimatorException {

        if (session.getAttribute("userId") != null) {

            SessionEntity sessionEntity
                    = sessionService.getSession(Integer.parseInt(sessionId));

            if (sessionEntity != null) {

            if (!sessionEntity.getIsProcess()) {
                model.addAttribute("errorMessage", "Session closed");
                return "error";
            }

            if (sessionEntity.getOwnerId().equals(Integer.parseInt(session.getAttribute("userId").toString()))) {

                sessionService.closeSession(sessionEntity.getId());
                sessionEntity
                        = sessionService.getSession(Integer.parseInt(sessionId));

                model.addAttribute("message", "The session was closed. Final result: " + sessionEntity.getFinalResult());
                return "finalPage";

            } else {

                model.addAttribute("errorMessage", "You do not have access");
                return "error";

            }

            } else {
                model.addAttribute("errorMessage", "Session not found");
                return "error";
            }

        } else {
            return "login";
        }

    }

    /**
     * Open the create session page.
     *
     * @return name jsp-file
     */
    @RequestMapping( value = {"/create"}, method = RequestMethod.GET)
    @Override
    public String getCreateSession(HttpSession session, Model model) {

        if (session.getAttribute("userId") != null) {

            List<StoryPointEntity> storyPointList =
                    storyPointService.getStoryPointsUser(
                    Integer.parseInt(session.getAttribute("userId").toString()));

            StringBuilder stringBuilder = new StringBuilder("");

                    for (StoryPointEntity storyPoint : storyPointList) {

                        stringBuilder
                                .append("<input type=\"radio\" id=\"")
                                .append(storyPoint.getId())
                                .append("\" name=\"storyPointId\" value=\"")
                                .append(storyPoint.getId())
                                .append("\"> <label for=\"")
                                .append(storyPoint.getId())
                                .append("\">")
                                .append(storyPoint.getName())
                                .append("</label>")
                                .append("</br>");

                    }

                    model.addAttribute("radioStoryPoints", stringBuilder.toString());

                    return "createStoryEstimator";

        } else {
            return "login";
        }

    }

    /**
     * Create session (go to the session page).
     *
     * @param storyPointId id story point
     * @return name jsp-file
     */
    @RequestMapping( value = {"/create"}, method = RequestMethod.POST)
    @Override
    public String postCreateSession(HttpSession session, Model model, String storyPointId) throws StoryPointEstimatorException {

        if (session.getAttribute("userId") != null) {

            SessionEntity sessionEntity
                    = sessionService.createSession(
                            Integer.parseInt(storyPointId),
                    Integer.parseInt(session.getAttribute("userId").toString()));

            return "redirect:/spe/session/" + sessionEntity.getId() + "/control";

        } else {
            return "login";
        }

    }

}
