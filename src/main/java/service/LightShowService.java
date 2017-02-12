package service;

import model.LightShow;
import model.User;
import org.springframework.security.access.annotation.Secured;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 28.11.2016.
 */
@Secured("ROLE_USER")
public interface LightShowService {

    LightShow save(LightShow lightShow) throws NotFoundException;

    LightShow get(Long id) throws NotFoundException;

    /**
     * Получить все шоу юзера
     */
    List<LightShow> getLightShowToUser(User user);

    void delete(Long id);

    LightShow createLightShow(String nameShow, Long deviceId);
}
