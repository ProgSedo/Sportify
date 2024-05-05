

import java.util.ArrayList;
import java.util.Date;
/**
 * Single game events.
 * 
 */
public class SingleEvent extends Events{

    private int teamSize;
    private ArrayList<User> team1Participants;
    private ArrayList<User> team2Participants;

    public SingleEvent(String place, Date eventTime, SportType sportType, int teamSize) {
        super(place, eventTime, sportType);
        this.teamSize = teamSize;
        team1Participants = new ArrayList<>();
        team2Participants = new ArrayList<>();

    }

    public int getTeam1Size() {
        return team1Participants.size();
    }

    public int getTeam2Size() {
        return team2Participants.size();
    }

    public boolean isTeam1Full() {
        
        if (team1Participants.size() < teamSize)
            return false;
        return true;
    }

    public boolean isTeam2Full() {
        if (team2Participants.size() < teamSize)
            return false;
        return true;
    }

    public String toString() {
        return super.toString() + " SingleGame";        
    }
    
}
