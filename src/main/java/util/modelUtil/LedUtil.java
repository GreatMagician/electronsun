package util.modelUtil;

import model.Led;
import to.LedTo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 08.03.2017.
 */
public class LedUtil {

    public static List<LedTo> createLedToFromLed(List<Led> leds){
        List<LedTo> result = new ArrayList<>();
        leds.forEach(led -> result.add(new LedTo(led.getId(), led.getNumber(), led.getEffect().getId())));
        return result;
    }
}
