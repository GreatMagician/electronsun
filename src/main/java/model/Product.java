package model;

import org.hibernate.annotations.Type;
import org.postgresql.util.PGmoney;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by Александр on 23.11.2016.
 * продукт для продажи, прибор или другие тавары
 */
@Entity
@Table(name = "products", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Product  extends NamedEntity {
    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private double price;
    /**
     * скидка в процентах
     */
    @Column(name = "discount")
    private int discount;

    /**
     * Цена со скидкой
     */
    @Column(name = "discount_price")
    private double discountPrice;

    /**
     * кол-во светодиодов в приборе
     */
    @Column(name = "maxLed", nullable = false)
    private int maxLed;

    public Product() {
    }

    public Product(Integer id, String name, String description, double price) {
        super(id, name);
        this.description = description;
        this.price = price;
    }

    public Product(Integer id, String name, String description, double price, int maxLed) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.maxLed = maxLed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
        discountPrice = (price * discount) / 100;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public int getMaxLed() {
        return maxLed;
    }

}
