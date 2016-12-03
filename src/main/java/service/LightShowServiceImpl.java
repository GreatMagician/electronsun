package service;

import model.LightShow;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.LightShowRepository;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 28.11.2016.
 */
@Service("lightShowService")
public class LightShowServiceImpl implements LightShowService {
    @Autowired
    private LightShowRepository repository;

    @Override
    public LightShow save(LightShow lightShow) throws NotFoundException {
        Assert.notNull(lightShow, "lightShow не должен быть пустым");
        return repository.save(lightShow);
    }

    @Override
    public LightShow get(Long id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<LightShow> getLightShowToUser(User user) {
        Assert.notNull(user, "user не должен быть пустым");
        return repository.getLightShowToUser(user);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
