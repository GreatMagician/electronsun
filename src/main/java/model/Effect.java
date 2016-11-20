package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Александр on 07.11.2016.
 */
@Entity
@Table(name = "effect")
public class Effect extends NamedEntity {
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @OrderBy()
    private List<Led> beginLedList; // начальный цвет

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @OrderBy()
    private List<Led> endLedList; // конечный цвет

    /**
     *  Общее время эффекта в милисикундах
     */
    @Column(name = "commonTime", nullable = false)
    private int commonTime;

    /**
     * Затухание
     */
    @Column(name = "attenuation")
    private boolean attenuation;

    /**
     * Появление
     */
    @Column(name = "appearance")
    private boolean appearance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    public Effect() {
    }

    public Effect(Integer id, String name) {
        super(id, name);
    }

    public List<Led> getBeginLedList() {
        return beginLedList;
    }

    public void setBeginLedList(List<Led> beginLedList) {
        this.beginLedList = beginLedList;
    }

    public List<Led> getEndLedList() {
        return endLedList;
    }

    public void setEndLedList(List<Led> endLedList) {
        this.endLedList = endLedList;
    }

    public int getCommonTime() {
        return commonTime;
    }

    public void setCommonTime(int commonTime) {
        this.commonTime = commonTime;
    }

    public boolean isAttenuation() {
        return attenuation;
    }

    public void setAttenuation(boolean attenuation) {
        this.attenuation = attenuation;
    }

    public boolean isAppearance() {
        return appearance;
    }

    public void setAppearance(boolean appearance) {
        this.appearance = appearance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addBeginLed(Led led){
        beginLedList.add(led);
    }
    public void removeBeginLed(Led led){
        beginLedList.remove(led);
    }
    public void addEndLed(Led led){
        endLedList.add(led);
    }
    public void removeEndLed(Led led){
        endLedList.remove(led);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Effect effect = (Effect) o;

        if (commonTime != effect.commonTime) return false;
        if (attenuation != effect.attenuation) return false;
        if (appearance != effect.appearance) return false;
        if (beginLedList != null ? !beginLedList.equals(effect.beginLedList) : effect.beginLedList != null)
            return false;
        if (endLedList != null ? !endLedList.equals(effect.endLedList) : effect.endLedList != null) return false;
        return user != null ? user.equals(effect.user) : effect.user == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (beginLedList != null ? beginLedList.hashCode() : 0);
        result = 31 * result + (endLedList != null ? endLedList.hashCode() : 0);
        result = 31 * result + commonTime;
        result = 31 * result + (attenuation ? 1 : 0);
        result = 31 * result + (appearance ? 1 : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
