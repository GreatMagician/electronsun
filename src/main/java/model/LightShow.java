package model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.applet.AudioClip;
import java.util.List;
import java.util.Map;

/**
 * Created by Александр on 06.11.2016.
 * Световое шоу
 */
@Entity
@Table(name = "lightShows")
public class LightShow  extends  NamedEntity {

    /**
     * key - объект эффект
     * value - позиция начала эффекта в милисекундах
     */
    @JsonIgnore
    @ElementCollection
    @CollectionTable(name="lightShow_effect_time_start",joinColumns = @JoinColumn(name = "lightShow_id"))
    @MapKeyJoinColumn(name="effect_id")
    @Column(name="time")
    private Map<Effect, Integer> effects;

    @JsonIgnore
    @ElementCollection
    @CollectionTable(name="lightShow_devices",joinColumns = @JoinColumn(name = "lightShow_id"))
    @JoinColumn(name="devices_id")
    private List<Device> devices;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     *  ссылка на id шоу на каторый делаем ремикс
     */
    @Column(name = "lightshow_remix_id")
    private Long lightShowRemixId;

    /**
     *  Список id шоу ремиксов на это шоу
     */
    @JsonIgnore
    @ElementCollection
    @CollectionTable(name="lightShow_remixes",joinColumns = @JoinColumn(name = "lightShow_id"))
    @Column(name = "remixid", nullable = false)
    private List<Long> lightShowRemixes;

    @Column(name = "time", nullable = false)
    private int time; // в милисекундах продолжительность шоу

    @OneToOne
    @JoinColumn(name = "audio_id")
    private Audio audio;

    @Column(name = "public")
    private boolean publicShow = false;

    public LightShow() {
    }

    public LightShow(Long id, String name, List<Device> devices, User user) {
        super(id, name);
        this.devices = devices;
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

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getLightShowRemixId() {
        return lightShowRemixId;
    }

    public void setLightShowRemixId(Long lightShowRemixId) {
        this.lightShowRemixId = lightShowRemixId;
    }

    public List<Long> getLightShowRemixes() {
        return lightShowRemixes;
    }

    public void setLightShowRemixes(List<Long> lightShowRemixes) {
        this.lightShowRemixes = lightShowRemixes;
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

    public boolean isPublicShow() {
        return publicShow;
    }

    public void setPublicShow(boolean publicShow) {
        this.publicShow = publicShow;
    }

    @Override
    public String toString() {
        return name + "("  + audio != null ? audio.getName() : "" + ')';
    }
}
