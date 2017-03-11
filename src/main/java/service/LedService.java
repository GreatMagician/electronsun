package service;

import model.Effect;
import model.EventEffect;
import model.Led;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import to.LedTo;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 27.11.2016.
 */
@Secured("ROLE_USER")
public interface LedService {
    @Transactional(propagation = Propagation.SUPPORTS)
    Led save(Led led) throws NotFoundException;

    Led get(Long id) throws NotFoundException;

    /**
     * Получить все светодиоды эффекта
     * @param eventEffect
     * @return
     */
    List<Led> getLedToEventEffect(EventEffect eventEffect);

    @Transactional(propagation = Propagation.SUPPORTS)
    void delete(Long id);

    @Transactional
    List<Led> save(List<LedTo> ledToList);

    List<Led> getLedToEventEffect(Long eventEffectId);
}
