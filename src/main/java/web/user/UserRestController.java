package web.user;

import model.User;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Александр on 05.12.2016.
 */
@RestController
@RequestMapping(value = "/users")
public class UserRestController extends AbstractUserController{

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        super.delete(id);
    }


    @GetMapping
    public User create(@Valid @RequestBody User user) {
        return super.create(user);
    }

//    @GetMapping
//    public User getNickName(@Valid String name) {
//        return super.getNickName(name);
//    }

    @PutMapping
    public void update(@Valid @RequestBody User user) {
        super.update(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView getByMail(@Valid String email, @Valid String password) {
        User user = super.getByMail(email);
        if (user != null)
        {
            if (user.getPassword().equals(password)){
                return new ModelAndView("index","user", user);
            }
        }
        return new ModelAndView("users/login", "user", new User());
    }

    @RequestMapping("/logout")
    public ModelAndView logout (ModelMap model) {
        model.addAttribute("user", new User());
        return new ModelAndView("index", "user", new User());
    }

    @RequestMapping("/login")
    public String login(ModelMap model) {
        model.addAttribute("login", true);
        return "login";
    }


}
