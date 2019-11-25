package jhack.spe.controllers;

import org.springframework.ui.Model;

/**
 * Interface authorization controller.
 */
public interface AuthorizationController {

    /**
     * Open the authorization page.
     *
     * @return name jsp-file
     */
    String getLoginForm();

    /**
     * Send authorization data to the server.
     *
     * @param model object model
     * @param login user login
     * @param password user password
     * @return name jsp-file
     */
    String postLoginForm(Model model, String login, String password);

    /**
     * Open the restore password page.
     *
     * @return name jsp-file
     */
    String getRestorePasswordForm();

    /**
     * Send new password on mail.
     *
     * @param model object model
     * @param mail user e-mail
     * @return name jsp-file
     */
    String postRestorePasswordForm(Model model, String mail);

}
