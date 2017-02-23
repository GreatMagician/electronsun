package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Александр on 07.11.2016.
 */
@Entity
@Table(name = "effects")
public class Effect extends NamedEntity {
    @JsonIgnore
    @ElementCollection
    @CollectionTable(name="effects_eventEffects",joinColumns = @JoinColumn(name = "effects_id"))
    @MapKeyColumn(name="event")
    @JoinColumn(name="eventeffect_id")
    private Map<Integer, EventEffect> eventEffectMap;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lightShows_id", nullable = false)
    private LightShow lightShow;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Effect() {
    }

    public Effect(Long id, String name, Map<Integer, EventEffect> eventEffectMap, LightShow lightShow, User user) {
        super(id, name);
        this.eventEffectMap = eventEffectMap;
        this.lightShow = lightShow;
        this.user = user;
    }

    public Map<Integer, EventEffect> getEventEffectMap() {
        return eventEffectMap;
    }

    public void setEventEffectMap(Map<Integer, EventEffect> eventEffectMap) {
        this.eventEffectMap = eventEffectMap;
    }

    public LightShow getLightShow() {
        return lightShow;
    }

    public void setLightShow(LightShow lightShow) {
        this.lightShow = lightShow;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Effect effect = (Effect) o;

        if (eventEffectMap != null ? !eventEffectMap.equals(effect.eventEffectMap) : effect.eventEffectMap != null)
            return false;
        if (lightShow != null ? !lightShow.equals(effect.lightShow) : effect.lightShow != null) return false;
        return user != null ? user.equals(effect.user) : effect.user == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (eventEffectMap != null ? eventEffectMap.hashCode() : 0);
        result = 31 * result + (lightShow != null ? lightShow.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}