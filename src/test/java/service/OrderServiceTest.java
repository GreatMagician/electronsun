package service;

import model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    @Transactional
    @Rollback(false) // отмена отката
    public void save() throws Exception {
        User user = userService.get(10l);
        Product product = productService.get(13l);
        Map<Product, Integer> products = new HashMap<Product, Integer>();
        products.put(product, 2);
        Order order = new Order(null, products, user, StatusOrder.PENDING);
        Order created = orderService.save(order);
        assertThat(created.getId(), is(notNullValue()));
    }

    @Test
    public void get() throws Exception {
        Order created = orderService.get(16l);
        assertThat(created.getId(), is(notNullValue()));
    }


    @Test
    public void getUser() throws Exception {
        List<Order> orders = orderService.getUser(userService.get(11l));
        for (Order order: orders)
            assertThat(order.getId(), is(notNullValue()));
    }

    @Test
    public void getAll() throws Exception {
        List<Order> orders = orderService.getAll();
        assertTrue(orders.size()>0);
        for (Order order: orders)
            assertThat(order.getId(), is(notNullValue()));
    }

    @Test
    public void getStatusAll() throws Exception {
        List<Order> orders = orderService.getStatusAll(StatusOrder.PENDING_PAYMENT);
        for (Order order: orders)
            assertTrue(order.getStatusOrder() == StatusOrder.PENDING_PAYMENT);
    }
    @Test
    public void delete() throws Exception {
        orderService.delete(17l);
    }

}