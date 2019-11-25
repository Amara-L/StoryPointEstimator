package jhack.spe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * Authorization controller.
 */
@Controller
public class AuthorizationControllerImp implements AuthorizationController {

    /**
     * Open the authorization page.
     *
     * @return name jsp-file
     */
    @Override
    public String getLoginForm() {
        return null;
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
    public String postLoginForm(Model model, String login, String password) {
        return null;
    }

    /**
     * Open the restore password page.
     *
     * @return name jsp-file
     */
    @Override
    public String getRestorePasswordForm() {
        return null;
    }

    /**
     * Send new password on mail.
     *
     * @param model object model
     * @param mail  user e-mail
     * @return name jsp-file
     */
    @Override
    public String postRestorePasswordForm(Model model, String mail) {
        return null;
    }

}
