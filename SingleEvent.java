import java.util.ArrayList;
import java.util.Date;

public class SingleEvent extends Events{

    

    private int team1Size;
    private int team2Size;
    private ArrayList<User> team1Participants;
    private ArrayList<User> team2Participants;

    public SingleEvent(Date eventTime, String eventName, SportType sportType, int team1Size, int team2Size) {
        super(eventTime, eventName, sportType);
        this.team1Size = team1Size;
        this.team2Size = team2Size;
    }

    public int getTeam1Size() {
        return team1Size;
    }

    public int getTeam2Size() {
        return team2Size;
    }

    public boolean isTeam1Full() {
        if (team1Participants.size() < team1Size)
            return false;
        return true;
    }

    public boolean isTeam2Full() {
        if (team2Participants.size() < team2Size)
            return false;
        return true;
    }
    
}
