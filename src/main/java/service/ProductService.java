package service;

import model.Product;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 25.11.2016.
 */
public interface ProductService {

    Product save (Product product) throws NotFoundException;

    Product get(Long id) throws NotFoundException;

    List<Product> getAll();

    void delete(Long id);

}
