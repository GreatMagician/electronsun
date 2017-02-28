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

    private final Long id;

    private final String name;

    // кол-во эффектов шоу
    private final int countEffect;

    private final List<DeviceTo> devices;

    private final Long lightShowRemixId;

    private final List<Long> lightShowRemixes;

    private final int time; // в милисекундах продолжительность шоу

    private final Audio audio;

    private final boolean publicShow;

    public LightShowTo(Long id, String name, int countEffect, List<DeviceTo> devices, Long lightShowRemixId, List<Long> lightShowRemixes, int time, Audio audio, boolean publicShow) {
        this.id = id;
        this.name = name;
        this.countEffect = countEffect;
        this.devices = devices;
        this.lightShowRemixId = lightShowRemixId;
        this.lightShowRemixes = lightShowRemixes;
        this.time = time;
        this.audio = audio;
        this.publicShow = publicShow;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCountEffect() {
        return countEffect;
    }

    public List<DeviceTo> getDevices() {
        return devices;
    }

    public Long getLightShowRemixId() {
        return lightShowRemixId;
    }

    public List<Long> getLightShowRemixes() {
        return lightShowRemixes;
    }

    public int getTime() {
        return time;
    }

    public Audio getAudio() {
        return audio;
    }

    public boolean isPublicShow() {
        return publicShow;
    }
}
