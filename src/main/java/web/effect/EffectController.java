package web.effect;

import model.Effect;
import model.LightShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.EffectService;
import to.LightShowTo;

import java.util.List;

/**
 * Created by Alexander on 23.02.2017.
 */
@Controller
@RequestMapping(value = "/effect")
@SessionAttributes("lightshowto")
public class EffectController {

    @Autowired
    private EffectService effectService;

    @RequestMapping(value = "/loadlightshoweffect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Effect> loadLightShowEffect (ModelMap model){
        LightShowTo lightShowTo = (LightShowTo) model.get("lightshowto");
        if (lightShowTo != null){
            return effectService.getEffectToLightShow(lightShowTo.getId());
        }
        return null;
    }

    @RequestMapping(value = "/loadusereffect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Effect> loadUserEffect (ModelMap model){
        return effectService.getEffectToUser();
    }

    @RequestMapping(value = "/createeffect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Effect createEffect (@RequestParam String nameEffect, ModelMap model){
        LightShowTo lightShowTo = (LightShowTo) model.get("lightshowto");
        return effectService.createEffect(nameEffect, lightShowTo.getId());
    }

    @Transactional
    @RequestMapping(value = "/geteffect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Effect getEffect (@RequestParam Long id, ModelMap model){
        return effectService.get(id);
    }

}
