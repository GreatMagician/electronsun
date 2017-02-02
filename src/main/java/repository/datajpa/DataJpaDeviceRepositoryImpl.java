package repository.datajpa;

import model.Device;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.DeviceRepository;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
@Repository
public class DataJpaDeviceRepositoryImpl implements DeviceRepository{
    @Autowired
    private ProxyDeviceRepository proxy;

    @Override
    public Device save(Device device) {
        return proxy.save(device);
    }

    @Override
    public Device get(Long id) {
        return proxy.findOne(id);
    }

    @Override
    public List<Device> getAll() {
        return proxy.findAll();
    }

    @Override
    public List<Device> getUserDevices(User user) {
        return proxy.findByUser(user);
    }

    @Override
    public void delete(Long id) {
        proxy.delete(id);
    }
}
