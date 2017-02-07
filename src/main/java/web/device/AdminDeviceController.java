package web.device;

import model.Device;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DeviceService;

import java.util.List;

/**
 * Created by Александр on 29.01.2017.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminDeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/devices")
    public String devices(ModelMap model) {
        return "admin/devices";
    }

    @RequestMapping(value = "/loaddevices", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Device> loadDevices (){
        return deviceService.getAll();
    }

    @RequestMapping(value = "/uuidgenerate", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public @ResponseBody String uuidGenerate(@RequestParam Long id) {
        return deviceService.generateUUID(id);
    }


    @RequestMapping(value = "/adddevice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Device addDevice (@RequestParam Long productId, @RequestParam String usernik){
        return deviceService.addDevice(productId, usernik);
    }


}
