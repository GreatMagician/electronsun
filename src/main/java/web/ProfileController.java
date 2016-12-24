package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Александр on 23.12.2016.
 */
@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @RequestMapping("/profile")
    public String register(ModelMap model) {
        return "profile";
    }

}
