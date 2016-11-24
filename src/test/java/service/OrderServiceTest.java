package service;

import model.Device;
import model.Order;
import model.StatusOrder;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import static org.junit.Assert.*;

/**
 * Created by Александр on 22.11.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-mvc.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    protected UserService userService;

//    @Test
//    public void save() throws Exception {
//        User user = userService.getNickName("UserTest");
//        Order order = new Order(null, 100, user, new Device(), false, StatusOrder.PENDING);
//        Order created = orderService.save(order);
//        assertThat(created.getId(), is(notNullValue()));
//    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getUser() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void getStatusAll() throws Exception {

    }

}