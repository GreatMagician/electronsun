package model;

import javax.persistence.*;

/**
 * Created by Александр on 05.11.2016.
 * Светодиод
 */
@Entity
@Table(name = "leds")
public class Led extends BaseEntity {

    @Column(name="r")
    private byte r;

    @Column(name="g")
    private byte g;

    @Column(name="b")
    private byte b;

    @Column(name="enabled")
    private boolean enabled = false; // включён или выключен

    @Column(name="number")
    private int number; // номер светодиода в приборе

    @ManyToOne
    @JoinColumn(name = "effect_id", nullable = false)
    private Effect effect;

    public Led() {
    }


    public Led(Integer id, byte r, byte g, byte b, int number, Effect effect) {
        super(id);
        this.r = r;
        this.g = g;
        this.b = b;
        this.number = number;
        this.effect = effect;
    }

    public byte getR() {
        return r;
    }

    public void setR(byte r) {
        this.r = r;
    }

    public byte getG() {
        return g;
    }

    public void setG(byte g) {
        this.g = g;
    }

    public byte getB() {
        return b;
    }

    public void setB(byte b) {
        this.b = b;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
