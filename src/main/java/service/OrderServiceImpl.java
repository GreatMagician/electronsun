package service;

import model.Order;
import model.StatusOrder;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.List;

/**
 * Created by Александр on 22.11.2016.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public Order get(Long id) {
        return repository.get(id);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public List<Order> getUser(User user) {
        return repository.getUser(user);
    }

    @Override
    public List<Order> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Order> getStatusAll(StatusOrder statusOrder) {
        return repository.getStatusAll(statusOrder);
    }
}
