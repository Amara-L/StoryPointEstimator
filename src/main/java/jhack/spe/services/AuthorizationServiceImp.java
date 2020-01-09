package jhack.spe.services;

import jhack.spe.entities.UserEntity;
import jhack.spe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImp implements AuthorizationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    /**
     * Method authorization user.
     *
     * @param login    - login user
     * @param password - password user
     * @return object user
     */
    @Override
    public UserEntity loginUser(String login, String password) {

        UserEntity user = userRepository.getUserByLogin(login);

            if ((user != null) && (user.getPassword().equals(password))) {
                return user;
            } else {
            return null;
        }

    }

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
