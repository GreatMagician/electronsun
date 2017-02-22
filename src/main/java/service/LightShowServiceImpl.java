package service;

import model.Device;
import model.LightShow;
import model.User;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.LightShowRepository;
import util.AuthorizedUser;
import util.UserUtil;
import util.exception.ExceptionUtil;
import util.exception.LightShowRemixException;
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
    @Autowired
    private  EffectService effectService;
    @Autowired
    private  UserService userService;

    @Override
    public LightShow save(LightShow lightShow) throws NotFoundException {
        log.info("save id=" + lightShow.getId());
        Assert.notNull(lightShow, "lightShow не должен быть пустым");
        return repository.save(lightShow);
    }

    @Override
    public LightShow get(Long id) throws NotFoundException {
        log.info("get id=" + id);
        LightShow lightShow = ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
        Hibernate.initialize(lightShow.getEffects());
        Hibernate.initialize(lightShow.getDevices());
        Hibernate.initialize(lightShow.getUser());
        Hibernate.initialize(lightShow.getLightShowRemixes());
        return lightShow;
    }

    @Override
    public List<LightShow> getLightShowToUser() {
        User user = AuthorizedUser.get().getUser();
        Assert.notNull(user, "user не должен быть пустым");
        log.info("getLightShowToUser user.id=" + user.getId());
        return repository.getLightShowToUser(user);
    }

    @Override
    public void delete(Long id) throws LightShowRemixException {
        LightShow deletelightShow = get(id);
        if (deletelightShow.getLightShowRemixes().size() > 0){
            throw new LightShowRemixException("невозможно удалить световое шоу, так как на него существует ремикс");
        }
        ExceptionUtil.checkAccessUser(deletelightShow.getUser());
        // удаление ссылки на ремикс
        if (deletelightShow.getLightShowRemixId() != null) {
            LightShow lightShow = get(deletelightShow.getLightShowRemixId());
            if (lightShow.getLightShowRemixes().contains(id)){
                lightShow.getLightShowRemixes().remove(id);
                save(lightShow);
            }
        }
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
