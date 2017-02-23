package repository.datajpa;

import model.Effect;
import model.LightShow;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 14.11.2016.
 */
public interface ProxyEffectRepository extends JpaRepository<Effect, Long> {

    @Override
    Effect save(Effect effect);

    @Override
    Effect findOne(Long id);

    List<Effect> findByLightShow(LightShow lightShow);

    List<Effect> findByUser(User user);

    @Override
    void delete(Long id);
}
