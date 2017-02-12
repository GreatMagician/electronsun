package util.modelUtil;

import model.Device;
import model.LightShow;
import model.User;
import to.DeviceTo;
import to.LightShowTo;
import to.UserTo;
import util.UserUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Александр on 09.02.2017.
 */
public class LightShowUtil {

    public static LightShowTo createLightShowTo(LightShow lightShow){
        if (lightShow == null) return null;
        return new LightShowTo(lightShow.getName(), lightShow.getEffects(), DeviceUtil.convertDevices(lightShow.getDevices()),
                UserUtil.createUserTo(lightShow.getRemixUser()), lightShow.getTime(), lightShow.getAudio());
    }


}
