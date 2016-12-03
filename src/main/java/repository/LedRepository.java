package repository;

import model.Effect;
import model.Led;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
public interface LedRepository {
    Led save(Led led);

    Led get(Long id);

    /**
     * Получить все светодиоды эффекта
     * @param effect
     * @return
     */
    List<Led> getLedToEffect(Effect effect);

    void delete(Long id);
}