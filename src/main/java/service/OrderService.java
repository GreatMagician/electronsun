package service;

import model.Order;
import model.StatusOrder;
import model.User;
import org.springframework.stereotype.Service;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 22.11.2016.
 */
public interface OrderService {
    Order save(Order order) throws NotFoundException;

    Order get(Long id) throws NotFoundException;

    void delete(Long id);

    /**
     *  Получить все заказы юзера
     * @return
     */
    List<Order> getUser(User user);

    List<Order> getAll();

    /**
     *  Возвращает список заказов по статусу
     * @param statusOrder
     * @return
     */
    List<Order> getStatusAll(StatusOrder statusOrder);
}
