package service;

import model.Product;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 25.11.2016.
 */
@Secured("ROLE_ADMIN")
public interface ProductService {

    Product save (Product product) throws NotFoundException;

    Product get(Long id) throws NotFoundException;

    List<Product> getAll();

    void delete(Long id);

    Product update(Long id, String column, String value);
}
