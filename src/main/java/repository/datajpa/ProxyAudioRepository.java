package repository.datajpa;

import model.Audio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 14.11.2016.
 */
public interface ProxyAudioRepository extends JpaRepository<Audio, Long> {
    @Override
    Audio save (Audio audio);

    @Override
    Audio findOne(Long id);

    @Override
    List<Audio> findAll();

    Audio findByName(String name);
   
    @Override
    void delete(Long id);

}
