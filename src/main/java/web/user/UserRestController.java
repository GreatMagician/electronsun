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


    @PutMapping
    public void update(@Valid @RequestBody User user) {
        super.update(user);
    }





}
