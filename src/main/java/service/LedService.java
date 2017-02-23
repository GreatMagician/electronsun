package service;

import model.Effect;
import model.EventEffect;
import model.Led;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 27.11.2016.
 */
public interface LedService {
    Led save(Led led) throws NotFoundException;

    Led get(Long id) throws NotFoundException;

    /**
     * Получить все светодиоды эффекта
     * @param eventEffect
     * @return
     */
    List<Led> getLedToEventEffect(EventEffect eventEffect);

    void delete(Long id);

}
