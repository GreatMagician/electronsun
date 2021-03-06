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
@Table(name = "lightshows")
public class LightShow  extends  NamedEntity {
    // кол-во эффектов шоу
    @Column(name="counteffect")
    private int countEffect = 0;

    @JsonIgnore
    @ElementCollection
    @CollectionTable(name="lightshow_devices",joinColumns = @JoinColumn(name = "lightshow_id"))
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
    @CollectionTable(name="lightshow_remixes",joinColumns = @JoinColumn(name = "lightshow_id"))
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

    public int getCountEffect() {
        return countEffect;
    }

    public int  addCountEffect() {
       return ++countEffect;
    }
    public int removeCountEffect() {
        return  (countEffect > 0) ? --countEffect : 0;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LightShow lightShow = (LightShow) o;

        if (countEffect != lightShow.countEffect) return false;
        if (time != lightShow.time) return false;
        if (publicShow != lightShow.publicShow) return false;
        if (devices != null ? !devices.equals(lightShow.devices) : lightShow.devices != null) return false;
        if (user != null ? !user.equals(lightShow.user) : lightShow.user != null) return false;
        if (lightShowRemixId != null ? !lightShowRemixId.equals(lightShow.lightShowRemixId) : lightShow.lightShowRemixId != null)
            return false;
        if (lightShowRemixes != null ? !lightShowRemixes.equals(lightShow.lightShowRemixes) : lightShow.lightShowRemixes != null)
            return false;
        return audio != null ? audio.equals(lightShow.audio) : lightShow.audio == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + countEffect;
        result = 31 * result + (devices != null ? devices.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (lightShowRemixId != null ? lightShowRemixId.hashCode() : 0);
        result = 31 * result + (lightShowRemixes != null ? lightShowRemixes.hashCode() : 0);
        result = 31 * result + time;
        result = 31 * result + (audio != null ? audio.hashCode() : 0);
        result = 31 * result + (publicShow ? 1 : 0);
        return result;
    }
}
