package model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Александр on 08.11.2016.
 * прибор
 */
@Entity
@Table(name = "devices")
public class Device  extends BaseEntity {

    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "maxLed", nullable = false)
    private int maxLed; // кол-во светодиодов в приборе

    @Column(name = "enabled")
    private boolean enabled = false; // подключен ли прибор к программе

    @Column(name = "uuid")
    private UUID uuid; // серийный номер прибора (уникальный)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Device() {
    }

    public Device(Long id, Product product) {
        super(id);
        this.product = product;
        maxLed = product.getMaxLed();
    }


    public Product getProduct() {
        return product;
    }

    public int getMaxLed() {
        return maxLed;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void createSerialID(){
        if (uuid == null)
            uuid = UUID.randomUUID();
    }

    public void setMaxLed(int maxLed) {
        this.maxLed = maxLed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
