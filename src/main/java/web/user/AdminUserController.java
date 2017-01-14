package web.user;

import model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Александр on 05.12.2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminUserController extends AbstractUserController {

    @RequestMapping("/users")
    public String login(ModelMap model) {
        return "admin/users";
    }

    @RequestMapping(value = "/loadusers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<User> loadUsers (){
        return super.getAll();
    }
}
