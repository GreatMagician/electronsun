package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Alexander on 22.02.2017.
 * события эффекта
 */
@Entity
@Table(name = "eventeffect")
public class EventEffect extends BaseEntity {
    @ElementCollection
    @CollectionTable(name = "eventeffect_leds", joinColumns = @JoinColumn(name = "eventeffect_id"))
    @JoinColumn(name = "led_id")
    private List<Led> leds;
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
    @Size(min = 0, max = 100, message = "Яркость должна быть от 0 до 100")
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

    public EventEffect(Long id, List<Led> leds, int glow, Effect effect) {
        super(id);
        this.leds = leds;
        this.glow = glow;
        this.effect = effect;
    }

    public EventEffect(Long id, List<Led> leds, int appearance, int glow, int brightness, boolean newColor, String newColorLed, int transition, int attenuation, int pause, Effect effect) {
        super(id);
        this.leds = leds;
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

    public List<Led> getLeds() {
        return leds;
    }

    public void setLeds(List<Led> leds) {
        this.leds = leds;
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
