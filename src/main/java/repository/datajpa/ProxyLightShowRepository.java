package repository.datajpa;

import model.LightShow;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 14.11.2016.
 */
@Transactional
public interface ProxyLightShowRepository extends JpaRepository<LightShow, Long> {

    @Override
    LightShow save(LightShow lightShow);

    @Override
    LightShow findOne(Long id);

    List<LightShow> findByUser(User user);

    @Override
    void delete(Long id);
}
