package service;

import model.Effect;
import model.EventEffect;
import org.springframework.security.access.annotation.Secured;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Alexander on 23.02.2017.
 */
@Secured("ROLE_USER")
public interface EventEffectService {

    EventEffect save(EventEffect eventEffect);

    EventEffect get(Long id) throws NotFoundException;

    /**
     * Получить все события эффекта
     * @param effect
     * @return
     */
    List<EventEffect> getEventEffectToEffect(Effect effect);

    void delete(Long id);
}
