package repository.datajpa;

import model.Effect;
import model.LightShow;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.EffectRepository;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
@Repository
public class DataJpaEffectRepositoryImpl implements EffectRepository{

    @Autowired
    private ProxyEffectRepository proxy;

    @Override
    public Effect save(Effect effect) {
        return proxy.save(effect);
    }

    @Override
    public Effect get(Long id) {
        return proxy.getOne(id);
    }

    @Override
    public List<Effect> getEffectToLightShow(LightShow lightShow) {
        return proxy.findByLightShow(lightShow);
    }

    @Override
    public List<Effect> getEffectToUser(User user) {
        return proxy.findByUser(user);
    }

    @Override
    public void delete(Long id) {
        proxy.delete(id);
    }
}
