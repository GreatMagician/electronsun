package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import to.LedTo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 07.03.2017.
 */
public class JsonUtil {

    public static List<LedTo> jsonInLedTo (String json_text){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(json_text);
            List<LedTo> ledToList = new ArrayList<>();
            root.forEach(value ->{
                if (value.size() > 0) {
                    Long id = value.get("id").asLong();
                    int numder = value.get("number").asInt();
                    Long eventEffectId = value.get("eventEffectId").asLong();
                    LedTo ledTo = new LedTo(id == 0 ? null : id, numder, eventEffectId);
                    ledToList.add(ledTo);
                }
            });
            return ledToList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
