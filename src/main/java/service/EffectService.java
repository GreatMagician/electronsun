package service;

import model.Effect;
import model.LightShow;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 28.11.2016.
 */
public interface EffectService {
    Effect save(Effect effect) throws NotFoundException;

    Effect get(Long id) throws NotFoundException;

    /**
     * Получить все эффекты шоу
     * @param lightShow
     * @return
     */
    List<Effect> getEffectToLightShow(LightShow lightShow);

    void delete(Long id);

}
