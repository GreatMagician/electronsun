package service;

import model.Effect;
import model.LightShow;
import model.User;
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
    /**
     *  Получить все эффекты юзера
     * @param user
     * @return
     */
    List<Effect> getEffectToUser(User user);

    void delete(Long id);

}
