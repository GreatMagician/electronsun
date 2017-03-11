package web.eventEffect;

import model.EventEffect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.EventEffectService;
import to.EffectTo;

import java.util.List;

/**
 * Created by Alexander on 01.03.2017.
 */
@Controller
@RequestMapping(value = "/eventeffect")
@SessionAttributes( names = {"lightshowto", "effectto"})
public class EventEffectController {

    @Autowired
    private EventEffectService eventEffectService;

    @RequestMapping(value = "/addeventeffect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    EventEffect addEventEffect (@RequestParam Long effectId, ModelMap model){
        return eventEffectService.createEventEffect(effectId);
    }

    @RequestMapping(value = "/deleteeventeffect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Boolean deleteEventEffect (@RequestParam int eventNumber, @RequestParam Long effectId, ModelMap model){
        eventEffectService.delete(eventNumber, effectId);
        return true;
    }

    @RequestMapping(value = "/loadeventeffects", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<EventEffect> loadEventEffects (@RequestParam Long effectId, ModelMap model){
        return eventEffectService.getEventEffectToEffect(effectId);
    }

    @RequestMapping(value = "/saveeventeffect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    EventEffect saveEventEffect (@RequestParam Long id, @RequestParam int numberOfEffect,
                                 @RequestParam int countLed, @RequestParam String color, @RequestParam int appearance,
                                 @RequestParam int glow, @RequestParam int brightness, @RequestParam boolean newColor,
                                 @RequestParam String newColorLed, @RequestParam int transition,
                                 @RequestParam int  attenuation, @RequestParam int pause, @RequestParam Long effectId){
        EventEffect eventEffect = new EventEffect(id, numberOfEffect, countLed, color, appearance, glow,
                brightness, newColor, newColorLed, transition, attenuation, pause, null);
        return eventEffectService.save(eventEffect, effectId);
    }

}
