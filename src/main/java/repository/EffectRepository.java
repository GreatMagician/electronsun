package repository;

import model.Effect;
import model.LightShow;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
public interface EffectRepository {

    Effect save(Effect effect);

    Effect get(Long id);

    /**
     * Получить все эффекты шоу
     * @param lightShow
     * @return
     */
    List<Effect> getEffectToLightShow(LightShow lightShow);

    void delete(Long id);

}
