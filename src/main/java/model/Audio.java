package model;

import java.applet.AudioClip;
import java.nio.file.Path;

/**
 * Created by Александр on 08.11.2016.
 * Класс работы с музыкой
 */
public class Audio extends NamedEntity implements AudioClip{

    private Path path;

    public Audio() {
    }

    public Audio(Integer id, String name, Path path) {
        super(id, name);
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public void play() {

    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {

    }
}
