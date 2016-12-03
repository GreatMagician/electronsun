package repository.datajpa;

import model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 25.11.2016.
 */
@Transactional
public interface ProxyProductRepository extends JpaRepository<Product, Long> {

    @Override
    Product save (Product product);

    @Override
    Product getOne(Long id);

    @Override
    List<Product> findAll();

    @Override
    void delete(Long id);



}
