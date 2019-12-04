package jhack.spe.controllers;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * Interface authorization controller.
 */
public interface AuthorizationController {

    /**
     * Open the authorization page.
     *
     * @return name jsp-file
     */
    String getLoginForm(HttpSession session, Model model);

    /**
     * Send authorization data to the server.
     *
     * @param model object model
     * @param login user login
     * @param password user password
     * @return name jsp-file
     */
    String postLoginForm(HttpSession session, Model model, String login, String password);

    /**
     * Open the restore password page.
     *
     * @return name jsp-file
     */
    String getRestorePasswordForm(HttpSession session);

    /**
     * Send new password on mail.
     *
     * @param model object model
     * @param mail user e-mail
     * @return name jsp-file
     */
    String postRestorePasswordForm(HttpSession session, Model model, String mail);

    /**
     * Log out of account.
     *
     * @return name jsp-file
     */
    String getExit(HttpSession session);

}
