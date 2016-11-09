package model;

import java.util.UUID;

/**
 * Created by Александр on 08.11.2016.
 * прибор
 */
public class Device  extends BaseEntity {

    private Description description;

    private int maxLed; // кол-во светодиодов в приборе

    private boolean enabled; // подключен ли прибор

    private String serialID; // серийный номер прибора (уникальный)

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

    public String getSerialID() {
        return serialID;
    }

    public void createSerialID(){
        if (serialID == null)
            serialID = generateSerialID();
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
