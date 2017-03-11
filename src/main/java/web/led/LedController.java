package web.led;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jdk.nashorn.internal.parser.JSONParser;
import model.EventEffect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.LedService;
import to.LedTo;
import util.JsonUtil;
import util.modelUtil.LedUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Alexander on 07.03.2017.
 */
@Controller
@RequestMapping(value = "/leds")
public class LedController {
    @Autowired
    private LedService ledService;

    @RequestMapping(value = "/saveleds", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<LedTo> saveLeds (@RequestParam String json_text, ModelMap model){
        List<LedTo> ledToList = JsonUtil.jsonInLedTo(json_text);
        ledService.save(ledToList);
        return LedUtil.createLedToFromLed(ledService.save(ledToList));
    }

    @RequestMapping(value = "/loadleds", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<LedTo> loadLeds (@RequestParam Long eventEffectId, ModelMap model){
        return LedUtil.createLedToFromLed(ledService.getLedToEventEffect(eventEffectId));
    }

}
