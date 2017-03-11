package repository.datajpa;

import model.Effect;
import model.EventEffect;
import model.Led;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.LedRepository;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
@Repository
public class DataJpaLedRepositoryImpl implements LedRepository{

    @Autowired
    private ProxyLedRepository proxy;

    @Override
    public Led save(Led led) {
        return proxy.save(led);
    }

    @Override
    public Led get(Long id) {
        return proxy.findOne(id);
    }

    @Override
    public List<Led> getLedToEventEffect(EventEffect eventEffect) {
        return proxy.findByEventEffect(eventEffect);
    }

    @Override
    public void delete(Long id) {
        proxy.delete(id);
    }
}
