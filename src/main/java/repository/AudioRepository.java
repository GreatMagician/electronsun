package repository;

import model.Audio;

import java.util.List;

/**
 * Created by Александр on 13.11.2016.
 */
public interface AudioRepository {
    Audio save (Audio audio);
    
    Audio get(Long id);
    
    List<Audio> getAll();
    
    Audio getName(String name);
    
    void delete(Long id);
}
