package repository;

import model.LightShow;
import model.User;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
public interface LightShowRepository {

    LightShow save(LightShow lightShow);

    LightShow get(Long id);

    /**
     * Получить все шоу юзера
     * @param user
     * @return
     */
    List<LightShow> getLightShowToUser(User user);

    void delete(Long id);
}
