package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Александр on 07.11.2016.
 */
@Entity
@Table(name = "effects")
public class Effect extends NamedEntity {
    @ElementCollection
    @CollectionTable(name = "effect_beginLedList", joinColumns = @JoinColumn(name = "effect_id"))
    @Column(name = "led_id")
    private List<Led> beginLedList; // начальный цвет

    @ElementCollection
    @CollectionTable(name = "effect_endLedList", joinColumns = @JoinColumn(name = "effect_id"))
    @Column(name = "led_id")
    private List<Led> endLedList; // конечный цвет

    /**
     * Общее время эффекта в милисикундах
     */
    @Column(name = "commonTime", nullable = false)
    private int commonTime;

    /**
     * Затухание
     */
    @Column(name = "attenuation")
    private boolean attenuation = false;

    /**
     * Появление
     */
    @Column(name = "appearance")
    private boolean appearance = false;

    @ManyToOne
    @JoinColumn(name = "lightShow_id", nullable = false)
    private LightShow lightShow;

    public Effect() {
    }

    public Effect(Integer id, String name, int commonTime, LightShow lightShow) {
        super(id, name);
        this.commonTime = commonTime;
        this.lightShow = lightShow;
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

    public LightShow getLightShow() {
        return lightShow;
    }

    public void setLightShow(LightShow lightShow) {
        this.lightShow = lightShow;
    }

    public void addBeginLed(Led led) {
        beginLedList.add(led);
    }

    public void removeBeginLed(Led led) {
        beginLedList.remove(led);
    }

    public void addEndLed(Led led) {
        endLedList.add(led);
    }

    public void removeEndLed(Led led) {
        endLedList.remove(led);
    }

}