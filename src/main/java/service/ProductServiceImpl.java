package service;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.ProductRepository;
import util.exception.ExceptionUtil;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 25.11.2016.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public Product save(Product product) throws NotFoundException {
        Assert.notNull(product, "Продукт не должен быть пустым");
        return repository.save(product);
    }

    @Override
    public Product get(Long id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
