package repository;

import model.Order;
import model.StatusOrder;
import model.User;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
public interface OrderRepository {

    Order save(Order order);

    Order get(Long id);

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
