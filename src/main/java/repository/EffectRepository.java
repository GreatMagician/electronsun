package repository;

import model.Effect;
import model.LightShow;
import model.User;

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

    /**
     *  Получить все эффекты юзера
     * @param user
     * @return
     */
    List<Effect> getEffectToUser(User user);

    void delete(Long id);

}
