package service;

import model.Device;
import model.User;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 27.11.2016.
 */
public interface DeviceService {
    Device save(Device device) throws NotFoundException;

    Device get(Long id) throws NotFoundException;

    List<Device> getAll();

    /**
     * Получить все приборы юзера
     * @param user
     * @return
     */
    List<Device> getUserDevices(User user);

    void delete(Long id);

}
