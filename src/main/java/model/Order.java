package model;

import java.util.Date;

/**
 * Created by Александр on 07.11.2016.
 * Заказы
 */
public class Order extends BaseEntity {

    private Date registered = new Date();

    private int price;

    private User user;

    private Device device;

    /**
     * оплачено
     */
    private boolean paid;

    private Status status;

    public Order() {
    }

    public Order(Integer id, int price, User user, Device device) {
        super(id);
        this.price = price;
        this.user = user;
        this.device = device;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private enum Status {
        /**
         * Ожидает обработки
         */
        PENDING,
        /**
         * обработка
         */
        TREATMENT,
        /**
         * отправлено
         */
        SENT;
    }
}
