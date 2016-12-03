package repository.datajpa;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.ProductRepository;

import java.util.List;

/**
 * Created by Александр on 25.11.2016.
 */
@Repository
public class DataJpaProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProxyProductRepository proxy;

    @Override
    public Product save(Product product) {
        return proxy.save(product);
    }

    @Override
    public Product get(Long id) {
        return proxy.getOne(id);
    }

    @Override
    public List<Product> getAll() {
        return proxy.findAll();
    }

    @Override
    public void delete(Long id) {
        proxy.delete(id);
    }
}
