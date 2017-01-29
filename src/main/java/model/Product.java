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

    public Product(Long id, String name, String description, double price) {
        super(id, name);
        this.description = description;
        this.price = price;
    }

    public Product(Long id, String name, String description, double price, int maxLed) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.maxLed = maxLed;
    }

    public Product(Long id, String name, String description, double price, int discount, int maxLed) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.discount = discount;
        setDiscount(discount);
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

    public void setMaxLed(int maxLed) {
        this.maxLed = maxLed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        return description.equals(product.description);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + description.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
