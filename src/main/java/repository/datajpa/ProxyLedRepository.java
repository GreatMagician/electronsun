package repository.datajpa;

import model.Effect;
import model.Led;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 14.11.2016.
 */
@Transactional
public interface ProxyLedRepository extends JpaRepository<Led, Long> {

    @Override
    Led save(Led led);

    @Override
    Led getOne(Long id);

    List<Led> findByEffect(Effect effect);

    @Override
    void delete(Long id);
}
