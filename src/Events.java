

import java.util.*;

 enum SportType {football, volleyball, tennis};

 public abstract class Events {
    
    private String place;
    private Date eventTime;
    private int eventID = 0;
    private SportType sportType;

    public Events (String place, Date eventTime, SportType sportType) {
        
        this.place = place;
        this.eventTime = eventTime;
        this.sportType = sportType;
        eventID++;
        
        Database.insertNewEvent( this );
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventName(int eventID) {
        this.eventID = eventID;
    }
    
    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }
    public String getPlace(){
        return place;
    }
    public void setPlace(String newPlace){
        place = newPlace;
    }
}
