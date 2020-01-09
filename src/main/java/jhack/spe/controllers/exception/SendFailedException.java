package jhack.spe.controllers.exception;

public class SendFailedException extends Exception {

    private String message;

    public SendFailedException() {
        super();
    }

    public SendFailedException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
