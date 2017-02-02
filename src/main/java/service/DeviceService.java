package service;

import model.Device;
import model.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 27.11.2016.
 */
@Secured("ROLE_USER")
public interface DeviceService {
    Device save(Device device) throws NotFoundException;

    Device get(Long id) throws NotFoundException;

    @Secured("ROLE_ADMIN")
    List<Device> getAll();

    /**
     * Получить все приборы юзера
     * @param user
     * @return
     */
    List<Device> getUserDevices(User user);

    void delete(Long id);

    @Transactional
    @Secured("ROLE_ADMIN")
    String generateUUID(Long id);

    @Transactional
    @Secured("ROLE_ADMIN")
    Device addDevice(Long productId, String userNik);
}
