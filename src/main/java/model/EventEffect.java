package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Alexander on 22.02.2017.
 * события эффекта
 */
@Entity
@Table(name = "eventeffect")
public class EventEffect extends BaseEntity {
   // номер события в эффекте
    @Column(name="numberofeffect")
    private int numberOfEffect;

    // кол-во светодиодов в событии
    @Column(name="countLed")
    private int countLed = 0;

    @Column(name="color", nullable = false)
    private String color;
    /**
     * Появление
     */
    @Column(name = "appearance")
    private int appearance = 0;

    /**
     * длительность свечения
     */
    @Column(name = "glow")
    private int glow;

    /**
     * яркость
     */
    @Column(name = "brightness")
    private int brightness = 100;

    @Column(name = "newcolor")
    private boolean newColor = false;

    // цвет в шеснадцатиричном формате
    @Column(name = "newcolorled")
    private String newColorLed;

    /**
     * длительность перехода
     */
    @Column(name = "transition")
    private int transition = 0;
    /**
     * Затухание
     */
    @Column(name = "attenuation")
    private int  attenuation = 0;

    @Column(name = "pause")
    private int pause = 0;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "effects_id", nullable = false)
    private Effect effect;


    public EventEffect() {
    }

    public EventEffect(Long id, int numberOfEffect, String color, int glow, Effect effect) {
        super(id);
        this.numberOfEffect = numberOfEffect;
        this.color = color;
        this.glow = glow;
        this.effect = effect;
    }

    public EventEffect(Long id, int numberOfEffect, int countLed, String color, int appearance, int glow, int brightness, boolean newColor, String newColorLed, int transition, int attenuation, int pause, Effect effect) {
        super(id);
        this.numberOfEffect = numberOfEffect;
        this.countLed = countLed;
        this.color = color;
        this.appearance = appearance;
        this.glow = glow;
        this.brightness = brightness;
        this.newColor = newColor;
        this.newColorLed = newColorLed;
        this.transition = transition;
        this.attenuation = attenuation;
        this.pause = pause;
        this.effect = effect;
    }

    public int getNumberOfEffect() {
        return numberOfEffect;
    }

    public void setNumberOfEffect(int numberOfEffect) {
        this.numberOfEffect = numberOfEffect;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCountLed() {
        return countLed;
    }
    public int addCountLed() {
        return ++countLed;
    }

    public int removeCountLed() {
        return  (countLed > 0) ? --countLed : 0;
    }

    public void setCountLed(int countLed) {
        this.countLed = countLed;
    }

    public int getAppearance() {
        return appearance;
    }

    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }

    public int getGlow() {
        return glow;
    }

    public void setGlow(int glow) {
        this.glow = glow;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public boolean isNewColor() {
        return newColor;
    }

    public void setNewColor(boolean newColor) {
        this.newColor = newColor;
    }

    public String getNewColorLed() {
        return newColorLed;
    }

    public void setNewColorLed(String newColorLed) {
        this.newColorLed = newColorLed;
    }

    public int getTransition() {
        return transition;
    }

    public void setTransition(int transition) {
        this.transition = transition;
    }

    public int getAttenuation() {
        return attenuation;
    }

    public void setAttenuation(int attenuation) {
        this.attenuation = attenuation;
    }

    public int getPause() {
        return pause;
    }

    public void setPause(int pause) {
        this.pause = pause;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
