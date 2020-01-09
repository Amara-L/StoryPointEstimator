package jhack.spe.services;

import jhack.spe.entities.UserEntity;

public interface AuthorizationService {

    /**
     * Method authorization user.
     *
     * @param login - login user
     * @param password - password user
     * @return object user
     */
    UserEntity loginUser(String login, String password);

    /**
     * Method send message with new password on e-mail user.
     * @param mail - e-mail user
     * @return result send message
     */
    boolean sendNewPassword(String mail);

}
