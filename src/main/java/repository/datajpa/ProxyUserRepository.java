package repository.datajpa;

import model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 14.11.2016.
 */
public interface ProxyUserRepository extends JpaRepository<User, Long> {

    @Override
    User save(User user);

    @Override
    User findOne(Long id);

    @Override
    List<User> findAll(Sort sort);

    User findByEmail(String email);

    User findByName (String name);

}
