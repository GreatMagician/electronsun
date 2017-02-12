package to;

import model.Product;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Александр on 09.02.2017.
 * class Transfer Object
 */
public class DeviceTo {

    private final Long id;

    private final Product product;

    private final String description;

    private final int maxLed; // кол-во светодиодов в приборе

    private final boolean enabled; // подключен ли прибор к программе

    private final UUID uuid; // серийный номер прибора (уникальный)



    public DeviceTo(Long id, Product product, String description, int maxLed, boolean enabled, UUID uuid) {
        this.id = id;
        this.product = product;
        this.description = description;
        this.maxLed = maxLed;
        this.enabled = enabled;
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxLed() {
        return maxLed;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public UUID getUuid() {
        return uuid;
    }
}
