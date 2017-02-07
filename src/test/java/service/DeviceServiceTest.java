package service;

import model.Device;
import model.Product;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
public class DeviceServiceTest {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    protected UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    @Transactional
    @Rollback(false) // отмена отката
    public void save() throws Exception {
        User user = userService.get(10l);
        Product product = productService.get(13l);
        Device device = new Device(null, product, user);
        Device created = deviceService.save(device);
        assertThat(created.getId(), is(notNullValue()));
    }

    @Test
    public void get() throws Exception {
        Device device = deviceService.get(20l);
        assertThat(device.getId(), is(notNullValue()));

    }

    @Test
    public void getAll() throws Exception {
        List<Device> devices = deviceService.getAll();
        assertThat(devices.size() > 0, is(true));
        devices.forEach(value -> assertThat(value.getId(), is(notNullValue())));
    }

    @Test
    public void getUserDevices() throws Exception {
        User user = userService.get(10l);
        List<Device> devices = deviceService.getUserDevices();
        assertThat(devices.size() > 0, is(true));
        devices.forEach(value -> assertThat(value.getId(), is(notNullValue())));
    }

    @Test
    public void delete() throws Exception {
        deviceService.delete(21l);
    }

}