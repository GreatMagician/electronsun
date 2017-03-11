package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import util.exception.ExceptionUtil;

import javax.persistence.*;
import javax.validation.constraints.Size;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "eventEffect_id", nullable = false)
    private EventEffect eventEffect;

    public Led() {
    }

    public Led(Long id, int number, EventEffect eventEffect) {
        super(id);
        this.number = number;
        this.eventEffect = eventEffect;
    }

    public Led(Long id, int r, int g, int b, int number, EventEffect eventEffect) {
        super(id);
        this.r = ExceptionUtil.checkExcessValueToByte(r);
        this.g = ExceptionUtil.checkExcessValueToByte(g);
        this.b = ExceptionUtil.checkExcessValueToByte(b);
        this.number = number;
        this.eventEffect = eventEffect;
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

    public EventEffect getEffect() {
        return eventEffect;
    }

    public void setEffect(EventEffect eventEffect) {
        this.eventEffect = eventEffect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Led led = (Led) o;

        if (r != led.r) return false;
        if (g != led.g) return false;
        if (b != led.b) return false;
        if (enabled != led.enabled) return false;
        if (number != led.number) return false;
        return eventEffect != null ? eventEffect.equals(led.eventEffect) : led.eventEffect == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + r;
        result = 31 * result + g;
        result = 31 * result + b;
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + number;
        result = 31 * result + (eventEffect != null ? eventEffect.hashCode() : 0);
        return result;
    }
}
