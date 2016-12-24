package web;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Александр on 04.12.2016.
 */
@Controller
public class RootController {


    @RequestMapping("/")
    public String root(ModelMap model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping("/index")
    public String index(ModelMap model) {
        return "index";
    }

    @RequestMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("register", true);
        return "register";
    }

    @RequestMapping("/feedback")
    public String feedback(ModelMap model) {
        return "feedback";
    }


}
