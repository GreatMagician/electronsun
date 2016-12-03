package repository.datajpa;

import model.Audio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import repository.AudioRepository;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
@Repository
public class DataJpaAudioRepositoryImpl implements AudioRepository {

    @Autowired
    private ProxyAudioRepository proxy;

    @Override
    public Audio save(Audio audio) {
        return proxy.save(audio);
    }

    @Override
    public Audio get(Long id) {
        return proxy.findOne(id);
    }

    @Override
    public List<Audio> getAll() {
        return proxy.findAll();
    }

    @Override
    public Audio getName(String name) {
        return proxy.findByName(name);
    }

    @Override
    public void delete(Long id) {
        proxy.delete(id);
    }
}
