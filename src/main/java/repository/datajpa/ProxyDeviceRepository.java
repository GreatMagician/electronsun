package repository.datajpa;

import model.Device;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 14.11.2016.
 */
@Transactional
public interface ProxyDeviceRepository extends JpaRepository<Device, Long> {

    @Override
    Device save(Device device);

    @Override
    Device findOne(Long id);

    @Override
    List<Device> findAll();

    @Override
    void delete(Long id);

    List<Device> findByUser(User user);

}
