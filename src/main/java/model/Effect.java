package model;

import java.util.List;

/**
 * Created by Александр on 07.11.2016.
 */
public class Effect extends NamedEntity {

    private List<Led> beginLedList; // начальный цвет
    private List<Led> endLedList; // конечный цвет
    /**
     *  Общее время эффекта в милисикундах
     */
    private int commonTime;

    /**
     * Затухание
     */
    private boolean attenuation;

    /**
     * Появление
     */
    private boolean appearance;

    private User user;

    public Effect() {
    }

    public Effect(Integer id, String name) {
        super(id, name);
    }

    public List<Led> getBeginLedList() {
        return beginLedList;
    }

    public void setBeginLedList(List<Led> beginLedList) {
        this.beginLedList = beginLedList;
    }

    public List<Led> getEndLedList() {
        return endLedList;
    }

    public void setEndLedList(List<Led> endLedList) {
        this.endLedList = endLedList;
    }

    public int getCommonTime() {
        return commonTime;
    }

    public void setCommonTime(int commonTime) {
        this.commonTime = commonTime;
    }

    public boolean isAttenuation() {
        return attenuation;
    }

    public void setAttenuation(boolean attenuation) {
        this.attenuation = attenuation;
    }

    public boolean isAppearance() {
        return appearance;
    }

    public void setAppearance(boolean appearance) {
        this.appearance = appearance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addBeginLed(Led led){
        beginLedList.add(led);
    }
    public void removeBeginLed(Led led){
        beginLedList.remove(led);
    }
    public void addEndLed(Led led){
        endLedList.add(led);
    }
    public void removeEndLed(Led led){
        endLedList.remove(led);
    }
}
