package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Александр on 07.11.2016.
 */
@Entity
@Table(name = "device")
public class Effect extends NamedEntity {
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "led")
    @OrderBy()
    private List<Led> beginLedList; // начальный цвет

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "led")
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
    @Column(name = "commonTime")
    private boolean attenuation;

    /**
     * Появление
     */
    @Column(name = "appearance")
    private boolean appearance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
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
}
