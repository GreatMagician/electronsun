package service;

import model.Device;
import model.LightShow;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.LightShowRepository;
import util.AuthorizedUser;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 28.11.2016.
 */
@Service("lightShowService")
public class LightShowServiceImpl implements LightShowService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private LightShowRepository repository;
    @Autowired
    private DeviceService deviceService;

    @Override
    public LightShow save(LightShow lightShow) throws NotFoundException {
        log.info("save id=" + lightShow.getId());
        Assert.notNull(lightShow, "lightShow не должен быть пустым");
        return repository.save(lightShow);
    }

    @Override
    public LightShow get(Long id) throws NotFoundException {
        log.info("get id=" + id);
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<LightShow> getLightShowToUser(User user) {
        Assert.notNull(user, "user не должен быть пустым");
        log.info("getLightShowToUser user.id=" + user.getId());
        return repository.getLightShowToUser(user);
    }

    @Override
    public void delete(Long id) {
        log.info("delete id=" + id);
        repository.delete(id);
    }

    @Override
    public LightShow createLightShow(String nameShow, Long deviceId) {
        Device device = deviceService.get(deviceId);
        User user = AuthorizedUser.get().getUser();
        List<Device> devices = new ArrayList<>();
        devices.add(device);
        LightShow newLightShow = new LightShow(null, nameShow, devices, user);
        return save(newLightShow);
    }
}
