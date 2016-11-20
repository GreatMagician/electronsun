package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Александр on 07.11.2016.
 * Заказы
 */
@Entity
@Table(name = "order")
public class Order extends BaseEntity {
    @Column(name = "registered", columnDefinition = "timestamp default now()")
    private Date registered = new Date();

    @Column(name = "price", nullable = false)
    private int price;

    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @JoinColumn(name="device_id")
    private Device device;

    /**
     * оплачено
     */
    @Column(name = "paid")
    private boolean paid;

    @Enumerated
    @Column(name = "status")
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
