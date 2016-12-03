package service;

import model.Device;
import model.User;
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
    @Autowired
    private DeviceRepository repository;

    @Override
    public Device save(Device device) throws NotFoundException {
        Assert.notNull(device, "device не должен быть пустым");
        return repository.save(device);
    }

    @Override
    public Device get(Long id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Device> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Device> getUserDevices(User user) {
        Assert.notNull(user, "user не должен быть пустым");
        return repository.getUserDevices(user);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
