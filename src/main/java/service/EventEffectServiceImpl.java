package service;

import model.Effect;
import model.EventEffect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.EventEffectRepository;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Alexander on 23.02.2017.
 */
@Service
public class EventEffectServiceImpl implements EventEffectService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private EventEffectRepository repository;

    @Override
    public EventEffect save(EventEffect eventEffect){
        Assert.notNull(eventEffect, "eventEffect не должен быть пустым");
        log.info("save - " + eventEffect);
        return repository.save(eventEffect);
    }

    @Override
    public EventEffect get(Long id) throws NotFoundException {
        log.info("get - " + id);
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<EventEffect> getEventEffectToEffect(Effect effect) {
        Assert.notNull(effect, "effect не должен быть пустым");
        log.info("getEventEffectToEffect - " + effect);
        return repository.getEventEffectToEffect(effect);
    }

    @Override
    public void delete(Long id) {
        log.info("delete - " + id);
        repository.delete(id);
    }
}
