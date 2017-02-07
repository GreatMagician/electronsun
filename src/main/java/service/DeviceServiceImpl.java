package service;

import model.Device;
import model.Product;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.DeviceRepository;
import util.AuthorizedUser;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 27.11.2016.
 */
@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DeviceRepository repository;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Override
    public Device save(Device device) throws NotFoundException {
        log.info("save " + device);
        Assert.notNull(device, "device не должен быть пустым");
        return repository.save(device);
    }

    @Override
    public Device get(Long id) throws NotFoundException {
        log.info("get " + id);
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Device> getAll() {
        log.info("getAll");
        return repository.getAll();
    }

    @Override
    public List<Device> getUserDevices() {
        User user = AuthorizedUser.get().getUser();
        log.info("getUserDevices " + user);
        Assert.notNull(user, "user не должен быть пустым");
        return repository.getUserDevices(user);
    }

    @Override
    public void delete(Long id) {
        log.info("delete " + id);
        repository.delete(id);
    }

    @Override
    public String generateUUID(Long id) {
        log.info("generateUUID " + id);
        Device device = get(id);
        device.createSerialID();
        save(device);
        log.debug("return generateUUID =" + device.getUuid().toString() + " id=" + id);
        return device.getUuid().toString();
    }

    @Override
    public Device addDevice(Long productId, String userNik) {
        log.info("addDevice [productId=" + productId + ",  userNik=" + userNik + "]");
        Product product = productService.get(productId);
        User user = userService.getNickName(userNik);
        Device device = new Device(null, product, user);
        return save(device);
    }

    @Override
    public Device addDevice(Long productId) {
        User user = AuthorizedUser.get().getUser();
        Product product = productService.get(productId);
        if (checkedDeviceRegistered(product))
            return null;
        Device device = new Device(null, product, user);
        return save(device);
    }

    @Override
    public Device update(Long id, String description) {
        Device device = get(id);
        device.setDescription(description);
        return save(device);
    }

    // проверка имеет ли юзер такой прибор не зарегистрированный
    private boolean checkedDeviceRegistered(Product product){
        for (Device device : getUserDevices()){
            if (device.getProduct().getName().equals(product.getName()) && device.getUuid() == null)
                return true;
        }
        return false;
    }

}
