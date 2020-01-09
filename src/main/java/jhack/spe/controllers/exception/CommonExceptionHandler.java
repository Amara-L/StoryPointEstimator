package jhack.spe.controllers.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Контроллер, содержащий обработчики возможных исключений, генерируемых сервисом.
 */
@RestControllerAdvice
public class CommonExceptionHandler {

    private ObjectMapper objectMapper;

    public CommonExceptionHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(StoryPointEstimatorException.class)
    public ModelAndView handleCustomerServiceException(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object o,
            StoryPointEstimatorException ex) {
        return new ModelAndView("error", "errorMessage", ex.getMessage());
    }

    @ExceptionHandler(SendFailedException.class)
    public ModelAndView handleSendFailedExceptionn(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object o,
            StoryPointEstimatorException ex) {
        return new ModelAndView("error", "errorMessage", "Error send email");
    }

}
