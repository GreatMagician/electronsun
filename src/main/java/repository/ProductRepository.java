package repository;

import model.Product;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 25.11.2016.
 */
public interface ProductRepository {

    Product save (Product product);

    Product get(Long id);

    List<Product> getAll();

    void delete(Long id);
}
