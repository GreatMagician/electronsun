package service;

import com.fasterxml.jackson.databind.SerializationFeature;
import model.Effect;
import model.EventEffect;
import model.LightShow;
import model.User;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.EffectRepository;
import util.AuthorizedUser;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Александр on 28.11.2016.
 */
@Service("effectService")
public class EffectServiceImpl implements EffectService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private EffectRepository repository;
    @Autowired
    private LightShowService lightShowService;

    @Override
    public Effect save(Effect effect) throws NotFoundException {
        Assert.notNull(effect, "effect не должен быть пустым");
        log.info("save - " + effect);
        return repository.save(effect);
    }

    @Override
    public Effect get(Long id) throws NotFoundException {
        log.info("get - " + id);
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Effect> getEffectToLightShow(Long lightShowId) {
        LightShow lightShow = lightShowService.get(lightShowId);
        ExceptionUtil.checkAccessUser(lightShow.getUser());
        return repository.getEffectToLightShow(lightShow);
    }

    @Override
    public List<Effect> getEffectToUser() {
        User user = AuthorizedUser.get().getUser();
        Assert.notNull(user, "user не должен быть пустым");
        return repository.getEffectToUser(user);
    }

    @Override
    public void delete(Long id) {
        log.info("delete - " + id);
        repository.delete(id);
    }

    @Override
    public Effect createEffect(String nameEffect, Long lightShowId) {
        LightShow lightShow = lightShowService.get(lightShowId);
        ExceptionUtil.checkAccessUser(lightShow.getUser());
        User user = AuthorizedUser.get().getUser();
        lightShow.addCountEffect();
        Effect newEffect = new Effect(null, nameEffect,  lightShow, user);
        lightShowService.save(lightShow);
        return save(newEffect);
    }
}
