package util.modelUtil;

import model.Device;
import to.DeviceTo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Александр on 09.02.2017.
 */
public class DeviceUtil {

    public static DeviceTo createDeviceTo(Device device){
        if (device == null) return null;
        return new DeviceTo(device.getId(), device.getProduct(), device.getDescription(), device.getMaxLed(),
                device.isEnabled(), device.getUuid());
    }

    public static List<DeviceTo> convertDevices(List<Device> devices){
        if (devices == null) return  Collections.emptyList();
        return devices.stream()
                .map(DeviceUtil::createDeviceTo)
                .collect(Collectors.toList());
    }

}
