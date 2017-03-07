package service;

import model.Effect;
import model.EventEffect;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Alexander on 23.02.2017.
 */
@Secured("ROLE_USER")
public interface EventEffectService {

    @Transactional(propagation = Propagation.SUPPORTS)
    EventEffect save(EventEffect eventEffect);

    EventEffect get(Long id) throws NotFoundException;

    /**
     * Получить все события эффекта
     * @param effectId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    List<EventEffect> getEventEffectToEffect(Long effectId);

    @Transactional
    void delete(int eventNumber, Long effectId);

    @Transactional
    EventEffect createEventEffect(Long effectId);

    EventEffect save(EventEffect eventEffect, Long effectId);
}
