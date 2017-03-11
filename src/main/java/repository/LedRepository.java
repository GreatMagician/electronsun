package repository;

import model.Effect;
import model.EventEffect;
import model.Led;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
public interface LedRepository {
    Led save(Led led);

    Led get(Long id);


    /**
     * Получить все светодиоды события
     * @param eventEffect
     * @return
     */
    List<Led> getLedToEventEffect(EventEffect eventEffect);

    void delete(Long id);
}
