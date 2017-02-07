package web.lightshow;

import model.LightShow;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.LightShowService;
import util.AuthorizedUser;

import java.util.List;
import java.util.Objects;

/**
 * Created by Александр on 02.02.2017.
 */
@Controller
@RequestMapping(value = "/lightshow")
public class LightShowController {
    @Autowired
    private LightShowService lightShowService;

    @RequestMapping("/show")
    public String show(ModelMap model) {
        return "lightshow/show";
    }

    @RequestMapping(value = "/createlightshow", method = RequestMethod.POST)
    public String createlightshow (@RequestParam String name, @RequestParam int deviceId, ModelMap model){
        if (Objects.equals(name, "") || deviceId == 0)
            return "lightshow/show";
        User user = AuthorizedUser.get().getUser();
        return "lightshow/show";
    }


}
