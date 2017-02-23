package repository.datajpa;

import model.Effect;
import model.EventEffect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Alexander on 23.02.2017.
 */
public interface ProxyEventEffectRepository extends JpaRepository<EventEffect, Long> {

    @Override
    EventEffect save(EventEffect eventEffect);

    @Override
    EventEffect findOne(Long id);

    List<EventEffect> findByEffect(Effect effect);

    @Override
    void delete(Long id);
}
