package service;

import model.LightShow;
import model.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import util.exception.LightShowRemixException;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 28.11.2016.
 */
@Secured("ROLE_USER")
public interface LightShowService {

    @Transactional(propagation = Propagation.SUPPORTS)
    LightShow save(LightShow lightShow) throws NotFoundException;

    @Transactional
    LightShow get(Long id) throws NotFoundException;

    /**
     * Получить все шоу юзера
     */
    List<LightShow> getLightShowToUser();

    @Transactional
    void delete(Long id) throws LightShowRemixException;

    LightShow createLightShow(String nameShow, Long deviceId);

}
