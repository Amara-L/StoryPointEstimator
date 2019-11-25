package jhack.spe.services;

import jhack.spe.controllers.dto.User;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImp implements  AuthorizationService {

    //TODO Stub
    /**
     * Method authorization user.
     *
     * @param login    - login user
     * @param password - password user
     * @return object user
     */
    @Override
    public User loginUser(String login, String password) {

        User user = new User(0, "UserName");

        return user;

    }

    //TODO Stub
    /**
     * Method send message with new password on e-mail user.
     *
     * @param mail - e-mail user
     * @return result send message
     */
    @Override
    public boolean sendNewPassword(String mail) {
        return true;
    }

}
