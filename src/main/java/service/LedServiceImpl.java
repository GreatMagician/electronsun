package service;

import model.Effect;
import model.EventEffect;
import model.Led;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.LedRepository;
import to.LedTo;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Александр on 27.11.2016.
 */
@Service("ledService")
public class LedServiceImpl implements LedService {
    @Autowired
    private LedRepository repository;
    @Autowired
    private EventEffectService eventEffectService;

    @Override
    public Led save(Led led) throws NotFoundException {
        Assert.notNull(led, "led не должен быть пустым");
        return repository.save(led);
    }

    @Override
    public Led get(Long id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Led> getLedToEventEffect(EventEffect eventEffect) {
        Assert.notNull(eventEffect, "effect не должен быть пустым");
        return repository.getLedToEventEffect(eventEffect);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public  List<Led> save(List<LedTo> ledToList) {
        Assert.notNull(ledToList, "ledToList не должен быть пустым");
        EventEffect eventEffect = eventEffectService.get(ledToList.get(0).getEventEffectId());
        ExceptionUtil.checkAccessUser(eventEffect.getEffect().getUser());
        List<Led> leds = new ArrayList<>();
        ledToList.forEach(ledTo -> {
            leds.add(new Led(ledTo.getId(), ledTo.getNumber(), eventEffect));
        });
        List<Led> deleteLeds = comparison(leds, getLedToEventEffect(eventEffect));
        deleteLeds.forEach(led -> delete(led.getId()));
        leds.forEach(this::save);
        return leds;
    }

    @Override
    public List<Led> getLedToEventEffect(Long eventEffectId) {
        EventEffect eventEffect = eventEffectService.get(eventEffectId);
        ExceptionUtil.checkAccessUser(eventEffect.getEffect().getUser());
        return getLedToEventEffect(eventEffect);
    }

    /**
     *  Создаёт список данных из secondList, которых нет в firstList
     * @param firstList список сравнения
     * @param secondList список из бд
     * @return Возвращает список для удаления
     */
    private List<Led> comparison (List<Led> firstList, List<Led> secondList){
        // key - id led из firstList
        List<Long> firstListId = new LinkedList<>();
        firstList.forEach(led -> firstListId.add(led.getId()));
        return secondList.stream()
                     .filter(led -> !firstListId.contains(led.getId()))
                     .collect(Collectors.toList());
    }
}
