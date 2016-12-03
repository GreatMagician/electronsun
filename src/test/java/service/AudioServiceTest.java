package service;

import model.Audio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Александр on 27.11.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-config.xml",
        "classpath:spring/spring-mvc.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class AudioServiceTest {
    @Autowired
    private AudioService audioService;

    @Test
    public void save() throws Exception {
        Audio newAudio = new Audio(null, "test", "c:\\test.mp3");
        Audio created = audioService.save(newAudio);
        assertThat(created.getId(), is(notNullValue()));
    }

    @Test
    public void get() throws Exception {
        Audio created = audioService.get(18l);
        assertThat(created.getId(), is(notNullValue()));
    }

    @Test
    public void getAll() throws Exception {
        List<Audio> audios = audioService.getAll();
        assertThat(audios.size()>=1, is(true));
        audios.forEach(value -> assertThat(value.getId(), is(notNullValue())));
    }

    @Test
    public void getName() throws Exception {
        Audio audio = audioService.getName("test");
        assertThat(audio.getId(), is(notNullValue()));
    }

    @Test
    public void delete() throws Exception {
        audioService.delete(19l);
    }

}