package to;

/**
 * Created by Alexander on 07.03.2017.
 */
public class LedTo {

    private final Long id;

    // номер светодиода в приборе
    private final int number;

    private final Long eventEffectId;

    public LedTo(Long id, int number, Long eventEffectId) {
        this.id = id;
        this.number = number;
        this.eventEffectId = eventEffectId;
    }

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public Long getEventEffectId() {
        return eventEffectId;
    }
}
