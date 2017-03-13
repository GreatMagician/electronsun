package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Effect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import to.EffectTo;
import to.LedTo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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

    public static Effect parseEffect(String json_text){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(json_text);
            Long id = root.get("id").asLong();
            String name = root.get("name").asText();
            int countEventEffect = root.get("countEventEffect").asInt();
            List<JsonNode> jsonNodeList = root.findValues("timeStart");
            List<Integer> timeStart = new LinkedList<>();
            if (jsonNodeList != null && jsonNodeList.get(0).size() > 0){
                jsonNodeList.get(0).forEach(jsonNode -> timeStart.add(jsonNode.asInt()));
            }
            String colorText = root.get("colorText").asText();
            String colorBackground = root.get("colorBackground").asText();
            int track = root.get("colorBackground").asInt();
            return new Effect(id, name, countEventEffect, timeStart, colorText, colorBackground, track,
                    null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
