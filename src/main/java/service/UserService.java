package service;

import model.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 19.11.2016.
 */
public interface UserService {
    @Secured("ROLE_USER")
    User save(User user);

    @Secured("ROLE_USER")
    @Transactional(propagation = Propagation.SUPPORTS)
    User get(Long id) throws NotFoundException;

    User getNickName(String name) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    @Secured("ROLE_ADMIN")
    List<User> getAll();

    void update(User user);

    @Secured("ROLE_ADMIN")
    void enable(Long id, boolean enable);

    @Secured("ROLE_USER")
    void delete(Long id);
}
