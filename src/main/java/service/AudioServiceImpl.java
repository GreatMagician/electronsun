package service;

import model.Audio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.AudioRepository;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 27.11.2016.
 */
@Service("audioService")
public class AudioServiceImpl implements AudioService {

    @Autowired
    private AudioRepository repository;

    @Override
    public Audio save(Audio audio) throws NotFoundException {
        Assert.notNull(audio, "Audio не должно быть пустым");
        return repository.save(audio);
    }

    @Override
    public Audio get(Long id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Audio> getAll() {
        return repository.getAll();
    }

    @Override
    public Audio getName(String name) throws NotFoundException {
        Assert.notNull(name, "Имя не должно быть пустым");
        return ExceptionUtil.checkNotFound(repository.getName(name),  "именем " + name);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
