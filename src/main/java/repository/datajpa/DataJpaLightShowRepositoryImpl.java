package repository.datajpa;

import model.LightShow;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.LightShowRepository;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
@Repository
public class DataJpaLightShowRepositoryImpl implements LightShowRepository{
    @Autowired
    private ProxyLightShowRepository proxy;

    @Override
    public LightShow save(LightShow lightShow) {
        return proxy.save(lightShow);
    }

    @Override
    public LightShow get(Long id) {
        return proxy.findOne(id);
    }

    @Override
    public List<LightShow> getLightShowToUser(User user) {
        return proxy.findByUser(user);
    }

    @Override
    public void delete(Long id) {
        proxy.delete(id);
    }
}
