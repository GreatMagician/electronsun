package model;

/**
 * Created by Александр on 05.11.2016.
 * Светодиод
 */
public class Led extends BaseEntity {
    private byte R;
    private byte G;
    private byte B;
    private boolean enabled;

    public Led() {
    }

    public Led(Integer id) {
        super(id);
    }

    public Led(Integer id, byte r, byte g, byte b) {
        super(id);
        R = r;
        G = g;
        B = b;
    }

    public void setRGB(byte r, byte g, byte b){
        R = r;
        G = g;
        B = b;
    }

    public byte getR() {
        return R;
    }

    public void setR(byte r) {
        R = r;
    }

    public byte getG() {
        return G;
    }

    public void setG(byte g) {
        G = g;
    }

    public byte getB() {
        return B;
    }

    public void setB(byte b) {
        B = b;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
