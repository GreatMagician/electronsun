package repository.datajpa;

import model.Effect;
import model.EventEffect;
import model.Led;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 14.11.2016.
 */
public interface ProxyLedRepository extends JpaRepository<Led, Long> {

    @Override
    Led save(Led led);


    @Override
    Led findOne(Long id);

    List<Led> findByEventEffect(EventEffect eventEffect);

    @Override
    void delete(Long id);
}
