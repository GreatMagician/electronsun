package util.modelUtil;

import model.Device;
import model.LightShow;
import model.User;
import to.DeviceTo;
import to.LightShowTo;
import to.UserTo;
import util.UserUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Александр on 09.02.2017.
 */
public class LightShowUtil {

    public static LightShowTo createLightShowTo(LightShow lightShow){
        if (lightShow == null) return null;
        return new LightShowTo(lightShow.getId(), lightShow.getName(),lightShow.getCountEffect(), DeviceUtil.convertDevices(lightShow.getDevices()),
                lightShow.getLightShowRemixId(), lightShow.getLightShowRemixes(), lightShow.getTime(), lightShow.getAudio(),
                lightShow.isPublicShow());
    }

    public static List<LightShowTo> convertLightShows(List<LightShow> lightShows){
        if (lightShows == null) return  Collections.emptyList();
        return lightShows.stream()
                .map(LightShowUtil::createLightShowTo)
                .collect(Collectors.toList());
    }

    public static  LightShowTo createLightShowToLazy(LightShow lightShow){
        if (lightShow == null) return null;
        return new LightShowTo(lightShow.getId(), lightShow.getName(), lightShow.getCountEffect(), null,
                lightShow.getLightShowRemixId(), null, lightShow.getTime(), lightShow.getAudio(),
                lightShow.isPublicShow());
    }

    public static List<LightShowTo> convertLightShowsToLazy(List<LightShow> lightShows){
        if (lightShows == null) return  Collections.emptyList();
        return lightShows.stream()
                .map(LightShowUtil::createLightShowToLazy)
                .collect(Collectors.toList());
    }
}
