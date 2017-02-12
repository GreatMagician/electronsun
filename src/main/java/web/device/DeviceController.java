package web.device;

import model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DeviceService;
import to.DeviceTo;
import util.AuthorizedUser;
import util.modelUtil.DeviceUtil;

import java.util.List;

/**
 * Created by Александр on 05.02.2017.
 */
@Controller
@RequestMapping(value = "/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/loaduserdevices", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<DeviceTo> loadUserDevices (){
        return DeviceUtil.convertDevices(deviceService.getUserDevices());
    }

    @RequestMapping(value = "/adddevice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody  DeviceTo addDevice (@RequestParam Long productId){
        return DeviceUtil.createDeviceTo(deviceService.addDevice(productId));
    }

    @RequestMapping(value = "/deletedevice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody void deleteDevices (@RequestParam Long id){
        deviceService.delete(id);
    }

    @RequestMapping(value = "/updatedevice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody DeviceTo saveProduct(@RequestParam Long id, @RequestParam("description") String description ) {
        return DeviceUtil.createDeviceTo(deviceService.update(id, description));
    }

}
