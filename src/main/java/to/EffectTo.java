package to;

/**
 * Created by Alexander on 28.02.2017.
 */
public class EffectTo {

    private final Long id;

    private final String name;

    // кол-во событий в эффекте
    private final int countEventEffect;

    // время начала эффекта в шоу
    private final int timeStart;

    public EffectTo(Long id, String name, int countEventEffect, int timeStart) {
        this.id = id;
        this.name = name;
        this.countEventEffect = countEventEffect;
        this.timeStart = timeStart;
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

    public int getTimeStart() {
        return timeStart;
    }
}
