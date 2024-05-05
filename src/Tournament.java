

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class Tournament extends Events{
    

    private ArrayList<User> participantList;
    private ArrayList<User> activePlayers;
    private int roundNumber;

    public Tournament(String place, Date eventTime, SportType sportType, int roundNumber) {
        super(place, eventTime, sportType);
        this.roundNumber = roundNumber;
        participantList = new ArrayList<>();
        activePlayers = new ArrayList<>();
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

    public ArrayList<User> shuffleActivePlayers(ArrayList<User> list) {
        Collections.shuffle(list);
        return list;
    }
    
}
