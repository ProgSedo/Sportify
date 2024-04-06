import java.util.ArrayList;
import java.util.Date;

public class Tournament extends Events{
    

    private ArrayList<User> participantList;

    public Tournament(Date eventTime, String eventName, SportType sportType) {
        super(eventTime, eventName, sportType);
        participantList = new ArrayList<>();
        
    }

    public ArrayList<User> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(ArrayList<User> participantList) {
        this.participantList = participantList;
    }

    public String toString() {
        return super.toString() + " Tournament";
    }
    
}
