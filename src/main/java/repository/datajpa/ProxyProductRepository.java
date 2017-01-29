package repository.datajpa;

import model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 25.11.2016.
 */
public interface ProxyProductRepository extends JpaRepository<Product, Long> {

    @Override
    Product save (Product product);

    @Override
    Product findOne(Long id);

    @Override
    List<Product> findAll();

    @Override
    void delete(Long id);
}
