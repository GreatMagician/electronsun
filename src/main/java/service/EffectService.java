package service;

import model.Effect;
import model.LightShow;
import model.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 28.11.2016.
 */
@Secured("ROLE_USER")
public interface EffectService {
    Effect save(Effect effect) throws NotFoundException;

    @Transactional
    Effect get(Long id) throws NotFoundException;

    /**
     * Получить все эффекты шоу
     * @param lightShowId
     * @return
     */
    List<Effect> getEffectToLightShow(Long lightShowId);
    /**
     *  Получить все эффекты юзера
     * @return
     */
    List<Effect> getEffectToUser();

    void delete(Long id);

    @Transactional
    Effect createEffect(String nameEffect, Long LightShowId);
}
