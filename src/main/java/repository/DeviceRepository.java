package repository;

import model.Device;
import model.User;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
public interface DeviceRepository {

    Device save(Device device);

    Device get(Long id);

    List<Device> getAll();

    /**
     * Получить все приборы юзера
     * @param user
     * @return
     */
    List<Device> getUserDevices(User user);

    void delete(Long id);

}
