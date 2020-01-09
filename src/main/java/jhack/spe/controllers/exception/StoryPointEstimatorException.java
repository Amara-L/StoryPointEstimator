package jhack.spe.controllers.exception;

public class StoryPointEstimatorException extends Exception {

    private String message;

    public StoryPointEstimatorException() {
        super();
    }

    public StoryPointEstimatorException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
