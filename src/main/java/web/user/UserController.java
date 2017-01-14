package web.user;

import model.Role;
import model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import util.AuthorizedUser;
import util.exception.NotFoundException;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * Created by Александр on 05.12.2016.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController extends AbstractUserController{

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


    @PutMapping
    public void update(@Valid @RequestBody User user) {
        super.update(user);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(){
        User newUser = AuthorizedUser.get().getUser();
        return new ModelAndView("register", "newUser", newUser);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public ModelAndView profile(@Valid @ModelAttribute User newUser, @RequestParam String save,
                                BindingResult result,SessionStatus status){
        if (save.equals("false")){
            return new ModelAndView("index");
        }
        ModelAndView model = new ModelAndView("register", "newUser", AuthorizedUser.get().getUser());
        if (!result.hasErrors()) {
            try {
                newUser.setId(AuthorizedUser.id());
                super.update(newUser);
                AuthorizedUser.get().update(newUser);
                status.setComplete();
                model.setViewName("index");
            } catch (DataIntegrityViolationException ex) {
                model.addObject("error", "Пользователь с такой почтой/ником уже существует.");
            }
        }
        return model;
    }


}
