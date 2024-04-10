package Models;

import java.util.*;

 enum SportType {football, volleyball, tennis};

 public abstract class Events {
    

    private Date eventTime;
    private String eventName;
    private SportType sportType;

    public Events (Date eventTime, String eventName, SportType sportType) {
        this.eventTime = eventTime;
        this.eventName = eventName;
        this.sportType = sportType;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    
    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public String toString() {
        return eventName + eventTime;
    }
}
