package model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Александр on 08.11.2016.
 * прибор
 */
@Entity
@Table(name = "device")
public class Device  extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "description")
    private Description description;

    @Column(name = "maxLed")
    private int maxLed; // кол-во светодиодов в приборе

    @Column(name = "enabled")
    private boolean enabled; // подключен ли прибор

    @Column(name = "serialId")
    private String serialId; // серийный номер прибора (уникальный)

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Device() {
    }

    public Device(Integer id, Description description) {
        super(id);
        this.description = description;
        maxLed = createMaxLed(description);
    }

    private int createMaxLed(Description description)
    {
        int numberLed = 0;
        switch (description){
            case ELECTRON_SUN_8_8: numberLed = 64; break;
            case ELECTRON_SUN_32_32: numberLed = 1024; break;
        }
        return numberLed;
    }

    public Description getDescription() {
        return description;
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

    public String getSerialId() {
        return serialId;
    }

    public void createSerialID(){
        if (serialId == null)
            serialId = generateSerialID();
    }
    private String generateSerialID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
