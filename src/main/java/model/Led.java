package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import util.exception.ExceptionUtil;
import util.exception.ExcessValueException;

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
    @Size(min=0, max=255, message = "Значение должно быть от 0 до 255")
    private int r;

    @Column(name="g")
    @Size(min=0, max=255, message = "Значение должно быть от 0 до 255")
    private int g;

    @Column(name="b")
    @Size(min=0, max=255, message = "Значение должно быть от 0 до 255")
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


}
