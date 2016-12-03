package service;

import model.Product;
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
 * Created by Александр on 25.11.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-mvc.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void save() throws Exception {
        Product productNew = new Product(null, "testProduct", "test", 3000);
        Product product = productService.save(productNew);
        assertThat(product.getId(), is(notNullValue()));
    }

    @Test
    public void get() throws Exception {
        Product product = productService.get(13l);
        assertThat(product.getId(), is(notNullValue()));
    }

    @Test
    public void getAll() throws Exception {
        List<Product> products = productService.getAll();
        assertTrue(products.size() > 0);
        for (Product product: products)
            assertThat(product.getId(), is(notNullValue()));
    }

    @Test
    public void delete() throws Exception {
        productService.delete(15l);
    }

}