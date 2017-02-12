package to;

import model.Audio;
import model.Effect;
import model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Александр on 09.02.2017.
 */
public class LightShowTo {

    private final String name;

    private final Map<Effect, Integer> effects;

    private final List<DeviceTo> devices;

    private final UserTo remixUser;

    private final int time; // в милисекундах продолжительность шоу

    private final Audio audio;

    public LightShowTo(String name, Map<Effect, Integer> effects, List<DeviceTo> devices, UserTo remixUser, int time, Audio audio) {
        this.name = name;
        this.effects = effects;
        this.devices = devices;
        this.remixUser = remixUser;
        this.time = time;
        this.audio = audio;
    }

    public String getName() {
        return name;
    }

    public Map<Effect, Integer> getEffects() {
        return effects;
    }

    public List<DeviceTo> getDevices() {
        return devices;
    }

    public UserTo getRemixUser() {
        return remixUser;
    }

    public int getTime() {
        return time;
    }

    public Audio getAudio() {
        return audio;
    }
}
