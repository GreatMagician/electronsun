package service;

import model.Order;
import model.StatusOrder;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.OrderRepository;
import util.exception.ExceptionUtil;

import java.util.List;

/**
 * Created by Александр on 22.11.2016.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;

    @Override
    public Order save(Order order) {
        Assert.notNull(order, "order не должен быть пустым");
        return repository.save(order);
    }

    @Override
    public Order get(Long id) {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public List<Order> getUser(User user) {
        Assert.notNull(user, "user не должен быть пустым");
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
