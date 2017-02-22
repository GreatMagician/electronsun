package service;

import model.Device;
import model.LightShow;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Александр on 29.11.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-mvc.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@Rollback(false)
public class LightShowServiceTest {
    @Autowired
    private LightShowService lightShowService;
    @Autowired
    private UserService userService;

    @Test
//    @Transactional
//    @Rollback(false) // отмена отката
    public void save() throws Exception {
        User user = userService.get(10l);
        LightShow lightShow = new LightShow(null, "testSave",null, user);
        LightShow created = lightShowService.save(lightShow);
        assertThat(created.getId(), is(notNullValue()));
    }

    @Test
    public void get() throws Exception {
        LightShow created = lightShowService.get(23l);
        assertThat(created.getId(), is(notNullValue()));
    }

    @Test
    public void getLightShowToUser() throws Exception {
        User user = userService.get(10L);
        List<LightShow> lightShowToUser = lightShowService.getLightShowToUser();
        assertThat(lightShowToUser.size() > 0, is(true));
        lightShowToUser.forEach(value -> assertThat(value.getId(), is(notNullValue())));
    }

//    @Test
//    public void delete() throws Exception {
//        lightShowService.delete(23L);
//    }

}