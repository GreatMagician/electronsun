package repository;

import model.Effect;
import model.EventEffect;

import java.util.List;

/**
 * Created by Alexander on 23.02.2017.
 */
public interface EventEffectRepository {

    EventEffect save(EventEffect eventEffect);

    EventEffect get(Long id);

    /**
     * Получить все события эффекта
     * @param effect
     * @return
     */
    List<EventEffect> getEventEffectToEffect(Effect effect);

    void delete(Long id);
}
