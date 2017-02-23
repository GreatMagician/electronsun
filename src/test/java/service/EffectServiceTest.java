package service;

import model.Effect;
import model.LightShow;
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
 * Created by Александр on 01.12.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-mvc.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class EffectServiceTest {
    @Autowired
    private LightShowService lightShowService;

    @Autowired
    private EffectService effectService;

//    @Test
//    public void save() throws Exception {
//        LightShow lightShow = lightShowService.get(22l);
//        Effect effect = new Effect(null,"testSave", 10, lightShow);
//        Effect created = effectService.save(effect);
//        assertThat(created.getId(), is(notNullValue()));
//    }

    @Test
    public void get() throws Exception {
        Effect created = effectService.get(24l);
        assertThat(created.getId(), is(notNullValue()));
    }

    @Test
    public void getEffectToLightShow() throws Exception {
        LightShow lightShow = lightShowService.get(22l);
        List<Effect> effects = effectService.getEffectToLightShow(lightShow);
        assertThat(effects.size()>0, is(true));
        effects.forEach(effect -> assertThat(effect.getId(), is(notNullValue())));
    }

    @Test
    public void delete() throws Exception {
        effectService.delete(25l);
    }

}