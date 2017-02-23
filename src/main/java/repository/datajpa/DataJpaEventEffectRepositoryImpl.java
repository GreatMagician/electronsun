package repository.datajpa;

import model.Effect;
import model.EventEffect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.EventEffectRepository;

import java.util.List;

/**
 * Created by Alexander on 23.02.2017.
 */
@Repository
public class DataJpaEventEffectRepositoryImpl implements EventEffectRepository {

    @Autowired
    private ProxyEventEffectRepository proxy;

    @Override
    public EventEffect save(EventEffect eventEffect) {
        return proxy.save(eventEffect);
    }

    @Override
    public EventEffect get(Long id) {
        return proxy.findOne(id);
    }

    @Override
    public List<EventEffect> getEventEffectToEffect(Effect effect) {
        return proxy.findByEffect(effect);
    }

    @Override
    public void delete(Long id) {
        proxy.delete(id);
    }
}
