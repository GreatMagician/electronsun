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
public interface ProductService {
    @Secured("ROLE_ADMIN")
    Product save (Product product) throws NotFoundException;

    @Secured("ROLE_ADMIN")
    Product get(Long id) throws NotFoundException;

    @Secured("ROLE_USER")
    List<Product> getAll();

    @Secured("ROLE_ADMIN")
    void delete(Long id);

    @Secured("ROLE_ADMIN")
    Product update(Long id, String column, String value);

}
