package repository.datajpa;

import model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 14.11.2016.
 */
@Transactional
public interface ProxyUserRepository extends JpaRepository<User, Integer> {
    @Override
    User save(User user);

    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(int id);

    @Override
    User findOne(Integer id);

    @Override
    List<User> findAll(Sort sort);

    @Query("SELECT u FROM User u WHERE u.email=?1")
    User getByEmail(String email);


}
