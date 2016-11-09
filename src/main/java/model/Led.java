package model;

/**
 * Created by Александр on 05.11.2016.
 * Светодиод
 */
public class Led extends BaseEntity {

    private byte r;

    private byte g;

    private byte b;

    private boolean enabled; // включён или выключен

    private int number; // номер светодиода в приборе

    private Effect effect;

    public Led() {
    }

    public Led(Integer id) {
        super(id);
    }

    public Led(Integer id, byte r, byte g, byte b) {
        super(id);
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void setRGB(byte r, byte g, byte b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Led(Integer id, byte r, byte g, byte b, boolean enabled, int number, Effect effect) {
        super(id);
        this.r = r;
        this.g = g;
        this.b = b;
        this.enabled = enabled;
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
