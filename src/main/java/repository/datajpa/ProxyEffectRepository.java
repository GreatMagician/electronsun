package repository.datajpa;

import model.Effect;
import model.LightShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 14.11.2016.
 */
@Transactional
public interface ProxyEffectRepository extends JpaRepository<Effect, Long> {

    @Override
    Effect save(Effect effect);

    @Override
    Effect getOne(Long id);

    List<Effect> findByLightShow(LightShow lightShow);

    @Override
    void delete(Long id);
}
