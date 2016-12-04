package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by Александр on 04.12.2016.
 */
@Controller
public class RootController {


    @GetMapping("/")
    public String root() {
        return "index";
    }

//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public String users(Model model) {
//        model.addAttribute("users", userService.getAll());
//        return "users";
//    }

}
