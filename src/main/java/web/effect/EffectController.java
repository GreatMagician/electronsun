package web.effect;

import model.Effect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.EffectService;
import to.EffectTo;
import to.LightShowTo;
import util.JsonUtil;
import util.modelUtil.EffectUtil;

import java.util.List;

/**
 * Created by Alexander on 23.02.2017.
 */
@Controller
@RequestMapping(value = "/effect")
@SessionAttributes( names = {"lightshowto", "effectto"})
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

    @RequestMapping(value = "/geteffect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    EffectTo getEffect (@RequestParam Long id, ModelMap model){
        EffectTo effectTo = EffectUtil.createEffectTo(effectService.get(id));
        model.addAttribute("effectto", effectTo);
        return effectTo;
    }

    @RequestMapping(value = "/deleteeffect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    boolean deleteEffect (@RequestParam Long id, ModelMap model){
        effectService.delete(id);
        model.addAttribute("effectto", "");
        return true;
    }

    @RequestMapping(value = "/saveeffect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    EffectTo saveEffect (@RequestParam String json_text, @RequestParam Long lightShowId, ModelMap model){
        Effect effect = JsonUtil.parseEffect(json_text);
        Effect saveEffect = effectService.save(effect, lightShowId);
        EffectTo effectTo = EffectUtil.createEffectTo(saveEffect);
        model.addAttribute("effectto", effectTo);
        return effectTo;
    }

}
