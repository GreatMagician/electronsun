package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.applet.AudioClip;
import java.nio.file.Path;

/**
 * Created by Александр on 08.11.2016.
 * Класс работы с музыкой
 */
@Entity
@Table(name = "audios")
public class Audio extends NamedEntity implements AudioClip{
    @Column(name = "path", nullable = false)
    private String path;

    public Audio() {
    }

    public Audio(Integer id, String name, String path) {
        super(id, name);
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
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
