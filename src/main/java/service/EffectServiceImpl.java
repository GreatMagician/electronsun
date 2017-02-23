package service;

import model.Effect;
import model.LightShow;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.EffectRepository;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 28.11.2016.
 */
@Service("effectService")
public class EffectServiceImpl implements EffectService {

    @Autowired
    private EffectRepository repository;

    @Override
    public Effect save(Effect effect) throws NotFoundException {
        Assert.notNull(effect, "effect не должен быть пустым");
        return repository.save(effect);
    }

    @Override
    public Effect get(Long id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Effect> getEffectToLightShow(LightShow lightShow) {
        Assert.notNull(lightShow, "lightShow не должен быть пустым");
        return repository.getEffectToLightShow(lightShow);
    }

    @Override
    public List<Effect> getEffectToUser(User user) {
        Assert.notNull(user, "user не должен быть пустым");
        return repository.getEffectToUser(user);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
