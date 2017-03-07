package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Александр on 07.11.2016.
 */
@Entity
@Table(name = "effects")
public class Effect extends NamedEntity {

    // кол-во событий в эффекте
    @Column(name="counteventeffect")
    private int countEventEffect = 0;

    // время начала эффекта в шоу
    @Column(name="timestart")
    private int timeStart = 0;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lightshow_id", nullable = false)
    private LightShow lightShow;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Effect() {
    }

    public Effect(Long id, String name, LightShow lightShow, User user) {
        super(id, name);
        this.lightShow = lightShow;
        this.user = user;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
    }

    public int getCountEventEffect() {
        return countEventEffect;
    }

    public int addCountEventEffect() {
        return ++countEventEffect;
    }

    public int removeCountEventEffect() {
        return  (countEventEffect >0) ? --countEventEffect : 0;
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

        if (countEventEffect != effect.countEventEffect) return false;
        if (lightShow != null ? !lightShow.equals(effect.lightShow) : effect.lightShow != null) return false;
        return user != null ? user.equals(effect.user) : effect.user == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + countEventEffect;
        result = 31 * result + (lightShow != null ? lightShow.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}