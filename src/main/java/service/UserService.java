package service;

import model.User;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 19.11.2016.
 */
public interface UserService {
    User save(User user);

    User get(Long id) throws NotFoundException;

    User getNickName(String name) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user);

    void enable(Long id, boolean enable);


}
