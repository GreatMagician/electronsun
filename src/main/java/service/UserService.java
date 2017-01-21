package service;

import model.User;
import org.springframework.security.access.annotation.Secured;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 19.11.2016.
 */
public interface UserService {
    @Secured("ROLE_USER")
    User save(User user);

    @Secured("ROLE_USER")
    User get(Long id) throws NotFoundException;

    User getNickName(String name) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    @Secured("ROLE_ADMIN")
    List<User> getAll();

    void update(User user);

    void enable(Long id, boolean enable);

    void delete(Long id);
}
