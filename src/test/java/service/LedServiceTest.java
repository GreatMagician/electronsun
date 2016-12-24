package service;

import model.Effect;
import model.Led;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Александр on 27.11.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-mvc.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class LedServiceTest {
    @Autowired
    private LedService ledService;
    @Autowired
    private EffectService effectService;

    @Test
    public void save() throws Exception {
        Effect effect = effectService.get(24L);
        Led led = new Led(null, 255, 0, 0, 5, effect);
        Led created = ledService.save(led);
        assertThat(created.getId(), is(notNullValue()));
    }

    @Test
    public void get() throws Exception {
        Led led = ledService.get(26l);
        assertThat(led.getId(), is(notNullValue()));
    }

    @Test
    public void getLedToEffect() throws Exception {
        Effect effect = effectService.get(24L);
        List<Led> leds = ledService.getLedToEffect(effect);
        assertThat(leds.size()>0, is(true));
        leds.forEach(led -> assertThat(led.getId(), is(notNullValue())));
    }

//    @Test
//    public void delete() throws Exception {
//        ledService.delete(27L);
//    }
}