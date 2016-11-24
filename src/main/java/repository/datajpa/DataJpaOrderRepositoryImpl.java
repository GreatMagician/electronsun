package repository.datajpa;

import model.Order;
import model.StatusOrder;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import repository.OrderRepository;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
@Repository
public class DataJpaOrderRepositoryImpl implements OrderRepository{
    private static final Sort SORT_REGISTERED_USER = new Sort("registered", "user");

    @Autowired
    private ProxyOrderRepository proxy;

    @Override
    public Order save(Order order) {
        return proxy.save(order);
    }

    @Override
    public Order get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public void delete(int id) {
        proxy.delete(id);
    }

    @Override
    public List<Order> getUser(User user) {
        return proxy.findByUser(user);
    }

    @Override
    public List<Order> getAll() {
        return proxy.findAll(SORT_REGISTERED_USER);
    }

    @Override
    public List<Order> getStatusAll(StatusOrder statusOrder) {
        return proxy.findByStatusOrder(statusOrder);
    }
}
