package web;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import util.AuthorizedUser;
import util.exception.NotFoundException;
import web.user.AbstractUserController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;

/**
 * Created by Александр on 04.12.2016.
 */
@Controller
public class RootController extends AbstractUserController{


    @RequestMapping(value = "/")
    public String root(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login (@RequestParam(value = "error", required = false) String error, ModelMap model) {
        if (error != null){
            model.addAttribute("error", "Не верный email или пароль");
        }
        return "login";
    }

    @RequestMapping("/logout")
    public ModelAndView logout (ModelMap model) {
        return new ModelAndView("index");
    }

    @RequestMapping("/login")
    public String login(ModelMap model) {
        return "login";
    }


    @RequestMapping("/index")
    public String index(ModelMap model) {
        return "index";
    }


    @RequestMapping("/feedback")
    public String feedback(ModelMap model) {
        return "feedback";
    }

    @RequestMapping("/player")
    public String player(ModelMap model) {
        return "player";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("register", true);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute User newUser, @RequestParam String save, ModelMap model) {
        if (save.equals("false")){
            return "index";
        }
        try {
            User user = super.getByMail(newUser.getEmail());
            if (user.getId() != null){
                model.addAttribute("error", "Email уже занят");
                model.addAttribute("newUser", newUser);
                model.addAttribute("register", true);
                return "register";
            }
        } catch (NotFoundException e) {
        }
        try {
            User user = super.getNickName(newUser.getName());
            if (user.getId() != null){
                model.addAttribute("error", "Ник уже занят. Попрубуйте ввести другой ник");
                model.addAttribute("newUser", newUser);
                model.addAttribute("register", true);
            }
        } catch (NotFoundException e) {
            newUser.setRoles(Collections.singletonList(Role.ROLE_USER));
            User user = super.create(newUser);
            if (user.getId() != null) {
                model.addAttribute("register", true);
                return "login";
            }
        }
        return "register";
    }

    @RequestMapping("/project")
    public String project (ModelMap model) {
        return "project";
    }

}
