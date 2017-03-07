package service;

import model.Effect;
import model.EventEffect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.EventEffectRepository;
import util.UserUtil;
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
    @Autowired
    private EffectService effectService;

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
    public List<EventEffect> getEventEffectToEffect(Long effectId) {
        log.info("getEventEffectToEffect - " + effectId);
        return repository.getEventEffectToEffect(effectService.get(effectId));
    }

    @Override
    public void delete(int eventNumber, Long effectId) {
        log.info("delete eventNumber" + eventNumber);
        Effect effect = effectService.get(effectId);
        ExceptionUtil.checkAccessUser(effect.getUser());
        effect.removeCountEventEffect();
        List<EventEffect> eventEffectList = repository.getEventEffectToEffect(effect);
        effectService.save(effect);
        eventEffectList.forEach(eventEffect -> {
            if (eventEffect.getNumberOfEffect() == eventNumber){
                repository.delete(eventEffect.getId());
                eventEffect.setNumberOfEffect(0);
            }else if (eventEffect.getNumberOfEffect() > eventNumber) {
                eventEffect.setNumberOfEffect(eventEffect.getNumberOfEffect() - 1);
            }
        });
        eventEffectList.forEach(eventEffect -> {
            if (eventEffect.getNumberOfEffect() != 0){
                save(eventEffect);
            }
        });
    }


    @Override
    public EventEffect createEventEffect(Long effectId) {
        Effect effect = effectService.get(effectId);
        ExceptionUtil.checkAccessUser(effect.getUser());
        EventEffect newEventEffect = new EventEffect(null, effect.addCountEventEffect(), "#fffbfd", 1000, effect);
        effectService.save(effect);
        return save(newEventEffect);
    }

    @Override
    public EventEffect save(EventEffect eventEffect, Long effectId) {
        Effect effect = effectService.get(effectId);
        ExceptionUtil.checkAccessUser(effect.getUser());
        eventEffect.setEffect(effect);
        return save(eventEffect);
    }


}
