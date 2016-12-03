package service;

import model.Effect;
import model.Led;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.LedRepository;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 27.11.2016.
 */
@Service("ledService")
public class LedServiceImpl implements LedService {
    @Autowired
    private LedRepository repository;

    @Override
    public Led save(Led led) throws NotFoundException {
        Assert.notNull(led, "led не должен быть пустым");
        return repository.save(led);
    }

    @Override
    public Led get(Long id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Led> getLedToEffect(Effect effect) {
        Assert.notNull(effect, "effect не должен быть пустым");
        return repository.getLedToEffect(effect);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
