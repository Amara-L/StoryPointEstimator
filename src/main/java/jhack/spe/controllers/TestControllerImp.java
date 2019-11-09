package jhack.spe.controllers;

import jhack.spe.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description class.
 *
 * @author FirstName S. LastName
 * @version 1.0.0 created 09.11.2019
 */
@Controller // <--- annotation indicating controller
@RequestMapping("/test") // <--- resource url this controller
public class TestControllerImp implements TestController {

    /**
     * Description variable.
     */
    @Autowired // <--- loads the bean. In this case, the object TestServiceImp.
    private TestService testService; // <--- initialize the interface (not implementation)

    /**
     * Description method.
     * @return description response.
     */
    @Override
    @RequestMapping( value = {"/run"}, method = RequestMethod.GET)
    public String getMainPage() {
        return "start"; // <--- return name page jsp in the directory webapp/WEB_INF/front/jsp
    }

    /**
     * Description method.
     * @return description response.
     */
    @Override
    @RequestMapping( value = {"/user"}, method = RequestMethod.GET)
    public String getUserPage() {
        return "user";
    }

    /**
     * Description method.
     * @return description response.
     */
    @Override
    @RequestMapping( value = {"/user"}, method = RequestMethod.POST)
    public String postUserPage(Model model, @RequestParam(name = "id") Integer userId) {

        String name = testService.getNameUserById(userId);

        model.addAttribute("name", name);

        return "user";
    }

}
