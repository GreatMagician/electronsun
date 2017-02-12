package web.lightshow;

import model.LightShow;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.LightShowService;
import to.LightShowTo;
import util.AuthorizedUser;
import util.modelUtil.LightShowUtil;

import java.util.List;
import java.util.Objects;

/**
 * Created by Александр on 02.02.2017.
 */
@Controller
@RequestMapping(value = "/lightshow")
@SessionAttributes("lightshowto")
public class LightShowController {
    @Autowired
    private LightShowService lightShowService;

    @RequestMapping("/show")
    public String show(ModelMap model) {
        return "lightshow/show";
    }

    @RequestMapping(value = "/createlightshowto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    LightShowTo createLightShowTo (@RequestParam String nameShow, @RequestParam Long deviceId, ModelMap model){
        LightShow lightShow = lightShowService.createLightShow(nameShow, deviceId);
        LightShowTo lightShowTo = LightShowUtil.createLightShowTo(lightShow);
        model.addAttribute("lightshowto", lightShowTo);
        return lightShowTo;
    }

    @RequestMapping(value = "/getLightShowToSession", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    LightShowTo getLightShowToSession (ModelMap model){
        return (LightShowTo) model.get("lightshowto");
    }

}
