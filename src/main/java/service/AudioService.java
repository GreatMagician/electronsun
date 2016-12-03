package service;

import model.Audio;
import util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Александр on 27.11.2016.
 */
public interface AudioService {

    Audio save (Audio audio) throws NotFoundException;

    Audio get(Long id) throws NotFoundException;

    List<Audio> getAll();

    Audio getName(String name) throws NotFoundException;

    void delete(Long id);

}
