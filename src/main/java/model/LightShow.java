package model;


import java.applet.AudioClip;
import java.util.Map;

/**
 * Created by Александр on 06.11.2016.
 * Световое шоу
 */
public class LightShow  extends  NamedEntity {

    /**
     * key - объект эффект
     * value - позиция начала эффекта в милисекундах
     */
    private Map<Effect, Integer> effects;

    private Device device;

    private User user;

    private User remixUser;

    private int time; // в милисекундах продолжительность шоу

    private Audio audio;

    public LightShow() {
    }

    public LightShow(Integer id, String name, Device device, User user) {
        super(id, name);
        this.device = device;
        this.user = user;
    }

    public Map<Effect, Integer> getEffects() {
        return effects;
    }

    public void setEffects(Map<Effect, Integer> effects) {
        this.effects = effects;
    }

    public void sddEffect(Effect effect, int position){
        effects.put(effect, position);
    }

    public void removeEffect(Effect effect, int position){
        effects.remove(effect);
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getRemixUser() {
        return remixUser;
    }

    public void setRemixUser(User remixUser) {
        this.remixUser = remixUser;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }
}
