package to;

import java.util.List;

/**
 * Created by Alexander on 28.02.2017.
 */
public class EffectTo {

    private final Long id;

    private final String name;

    // кол-во событий в эффекте
    private final int countEventEffect;

    // время начала эффекта в шоу
    private final List<Integer> timeStart;

    private final String colorText;

    private final String colorBackground;

    private final int track;

    public EffectTo(Long id, String name, int countEventEffect, List<Integer> timeStart, String colorText, String colorBackground, int track) {
        this.id = id;
        this.name = name;
        this.countEventEffect = countEventEffect;
        this.timeStart = timeStart;
        this.colorText = colorText;
        this.colorBackground = colorBackground;
        this.track = track;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCountEventEffect() {
        return countEventEffect;
    }

    public List<Integer> getTimeStart() {
        return timeStart;
    }

    public String getColorText() {
        return colorText;
    }

    public String getColorBackground() {
        return colorBackground;
    }

    public int getTrack() {
        return track;
    }
}
