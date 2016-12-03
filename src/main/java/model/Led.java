package model;

import util.exception.ExceptionUtil;
import util.exception.ExcessValueException;

import javax.persistence.*;

/**
 * Created by Александр on 05.11.2016.
 * Светодиод
 */
@Entity
@Table(name = "leds")
public class Led extends BaseEntity {

    @Column(name="r")
    private int r;

    @Column(name="g")
    private int g;

    @Column(name="b")
    private int b;

    @Column(name="enabled")
    private boolean enabled = false; // включён или выключен

    @Column(name="number")
    private int number; // номер светодиода в приборе

    @ManyToOne
    @JoinColumn(name = "effect_id", nullable = false)
    private Effect effect;

    public Led() {
    }


    public Led(Long id, int r, int g, int b, int number, Effect effect) {
        super(id);
        this.r = ExceptionUtil.checkExcessValueToByte(r);
        this.g = ExceptionUtil.checkExcessValueToByte(g);
        this.b = ExceptionUtil.checkExcessValueToByte(b);
        this.number = number;
        this.effect = effect;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = ExceptionUtil.checkExcessValueToByte(r);
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = ExceptionUtil.checkExcessValueToByte(g);
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = ExceptionUtil.checkExcessValueToByte(b);
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
