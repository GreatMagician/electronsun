package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Александр on 07.11.2016.
 */
@Entity
@Table(name = "effects")
public class Effect extends NamedEntity {

    // кол-во событий в эффекте
    @Column(name="counteventeffect")
    private int countEventEffect = 0;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lightshow_id", nullable = false)
    private LightShow lightShow;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Effect() {
    }

    public Effect(Long id, String name, LightShow lightShow, User user) {
        super(id, name);
        this.lightShow = lightShow;
        this.user = user;
    }


    public int getCountEventEffect() {
        return countEventEffect;
    }

    public int addCountEventEffect() {
        return countEventEffect++;
    }

    public int removeCountEventEffect() {
        return  (countEventEffect >0) ? countEventEffect-- : 0;
    }

    public LightShow getLightShow() {
        return lightShow;
    }

    public void setLightShow(LightShow lightShow) {
        this.lightShow = lightShow;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}