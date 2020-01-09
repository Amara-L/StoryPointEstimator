package jhack.spe.services;

import jhack.spe.controllers.exception.SendFailedException;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text) throws SendFailedException;

}
