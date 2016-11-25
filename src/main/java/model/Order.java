package model;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

/**
 * Created by Александр on 07.11.2016.
 * Заказы
 */
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column(name = "registered", columnDefinition = "timestamp default now()")
    private Date registered = new Date();

    @ElementCollection
    @CollectionTable(name = "order_products",joinColumns = @JoinColumn(name = "order_id"))
    @MapKeyColumn(name = "product_id")
    @Column(name = "number", nullable = false)
    private Map<Product, Integer> products; // number - кол-во приборов в заказе

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * оплачено
     */
    @Column(name = "paid")
    private boolean paid = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusOrder")
    private StatusOrder statusOrder;

    public Order() {
    }

    public Order(Long id, Map<Product, Integer> products, User user, StatusOrder statusOrder) {
        super(id);
        this.products = products;
        this.user = user;
        this.statusOrder = statusOrder;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
