package service;

import model.LightShow;
import model.User;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 28.11.2016.
 */
public interface LightShowService {

    LightShow save(LightShow lightShow) throws NotFoundException;

    LightShow get(Long id) throws NotFoundException;

    /**
     * Получить все шоу юзера
     * @param user
     * @return
     */
    List<LightShow> getLightShowToUser(User user);

    void delete(Long id);

}
