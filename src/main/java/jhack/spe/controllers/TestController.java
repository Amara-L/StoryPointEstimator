package jhack.spe.controllers;

import org.springframework.ui.Model;

/**
 * Description interface.
 *
 * @author FirstName S. LastName
 * @version 1.0.0 created 09.11.2019
 */
public interface TestController {

    /**
     * Description method.
     * @return description response.
     */
    String getMainPage();

    /**
     * Description method.
     * @return description response.
     */
    String getUserPage();

    /**
     * Description method.
     * @return description response.
     */
    String postUserPage(Model model, Integer userId);

}
