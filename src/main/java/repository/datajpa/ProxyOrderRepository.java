package repository.datajpa;

import model.Order;
import model.StatusOrder;
import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр on 14.11.2016.
 */
@Transactional
public interface ProxyOrderRepository extends JpaRepository<Order, Long> {
    @Override
    Order getOne(Long id);

    @Override
    Order save(Order order);

    @Override
    void delete(Long id);

    @Override
    List<Order> findAll();

    List<Order> findByUser(User user);

    List<Order> findByStatusOrder(StatusOrder statusOrder);
}
