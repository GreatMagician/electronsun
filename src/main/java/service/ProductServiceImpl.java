package service;

import model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import repository.ProductRepository;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.List;
import java.util.Objects;

/**
 * Created by Александр on 25.11.2016.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductRepository repository;

    @Override
    public Product save(Product product) throws NotFoundException {
        Assert.notNull(product, "Продукт не должен быть пустым");
        log.info("save " + product);
        return repository.save(product);
    }

    @Override
    public Product get(Long id) throws NotFoundException {
        log.info("get " + id);
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Product> getAll() {
        log.info("getAll");
        return repository.getAll();
    }

    @Override
    public void delete(Long id) {
        log.info("delete" + id);
        repository.delete(id);
    }

    @Override
    public Product update(Long id, String column, String value) {
        Product product = get(id);
        if (Objects.equals(column, "name")) {
            product.setName(value);
        } else if (Objects.equals(column, "description")) {
            product.setDescription(value);
        } else if (Objects.equals(column, "price")) {
            product.setPrice(Double.parseDouble(value));
        } else if (Objects.equals(column, "discount")) {
            product.setDiscount(Integer.parseInt(value));
        } else if (Objects.equals(column, "maxLed")) {
            product.setMaxLed(Integer.parseInt(value));
        }
        return save(product);
    }
}
