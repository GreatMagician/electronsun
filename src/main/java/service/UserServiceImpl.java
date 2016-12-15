package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.OrderRepository;
import repository.UserRepository;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 19.11.2016.
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository repository;

    @Override
    public User save(User user) {
        Assert.notNull(user, "Пользователь не должен быть null");
        return repository.save(user);
    }


    @Override
    public User get(Long id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public User getNickName(String name) throws NotFoundException {
        Assert.notNull(name, "Ник не должен быть null");
        return ExceptionUtil.checkNotFound(repository.getNickName(name), name);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Assert.notNull(email, "email не должен быть null");
        return ExceptionUtil.checkNotFound(repository.getByEmail(email), email);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(User user) {
        Assert.notNull(user, "Пользователь не должен быть пустым");
        repository.save(user);
    }


    @Override
    public void enable(Long id, boolean enable) {
        User user = get(id);
        user.setEnabled(enable);
        repository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = get(id);
        user.setDeleted(true);
        repository.save(user);
    }
}
