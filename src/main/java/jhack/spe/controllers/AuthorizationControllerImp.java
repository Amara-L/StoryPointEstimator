package jhack.spe.controllers;

import jhack.spe.entities.UserEntity;
import jhack.spe.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Authorization controller.
 */
@Controller
@RequestMapping("/authorization")
public class AuthorizationControllerImp implements AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    /**
     * Open the authorization page.
     *
     * @return name jsp-file
     */
    @Override
    @RequestMapping( value = {"/login"}, method = RequestMethod.GET)
    public String getLoginForm(HttpSession session, Model model) {

        if (session.getAttribute("userId") != null) {

            model.addAttribute("userName", session.getAttribute("userName"));

            return "main";

        } else {
            return "login";
        }
    }

    /**
     * Send authorization data to the server.
     *
     * @param model    object model
     * @param login    user login
     * @param password user password
     * @return name jsp-file
     */
    @Override
    @RequestMapping( value = {"/login"}, method = RequestMethod.POST)
    public String postLoginForm(HttpSession session, Model model, String login, String password) {

        UserEntity user = authorizationService.loginUser(login, password);

       if (user == null) {
           model.addAttribute("errorMessage", "Login or password not valid");
           return "error";
       }

        session.setAttribute("userId", user.getId());
        session.setAttribute("userName", user.getName());

        model.addAttribute("userName", user.getName());

        return "main";

    }

    /**
     * Open the restore password page.
     *
     * @return name jsp-file
     */
    @Override
    @RequestMapping( value = {"/restorepass"}, method = RequestMethod.GET)
    public String getRestorePasswordForm(HttpSession session) {
        return "restorePassword";
    }

    /**
     * Send new password on mail.
     *
     * @param model object model
     * @param mail  user e-mail
     * @return name jsp-file
     */
    @Override
    @RequestMapping( value = {"/restorepass"}, method = RequestMethod.POST)
    public String postRestorePasswordForm(HttpSession session, Model model, String mail) {

        authorizationService.sendNewPassword(mail);

        return "login";

    }

    /**
     * Log out of account.
     *
     * @param session
     * @return name jsp-file
     */
    @RequestMapping( value = {"/exit"}, method = RequestMethod.GET)
    @Override
    public String getExit(HttpSession session) {

        session.removeAttribute("userId");
        session.removeAttribute("userName");

        return "login";

    }

}
