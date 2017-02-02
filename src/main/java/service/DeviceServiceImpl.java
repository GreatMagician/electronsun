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
    ProductService productService;
    @Autowired
    UserService userService;

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
    public List<Device> getUserDevices(User user) {
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
}
