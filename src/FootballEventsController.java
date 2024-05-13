

import java.awt.Color;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FootballEventsController implements Initializable
{
    private int matchIndex;
    private int tournamentIndex;
    private DateTimeFormatter timeFormatter;

    @FXML
    private Label matchName;
    
    @FXML
    private Label tournamentName;

    @FXML
    private TextArea footballMatchesInfoArea;

    @FXML
    private TextArea footballTournamentsInfoArea;

    @FXML
    private Button joinMatchButton;

    @FXML
    private Button viewTournamentButton;

    @FXML
    private Button nextMatchButton;

    @FXML
    private Button nextTournamentButton;

    @FXML
    private Button previousMatchButton;

    @FXML
    private Button previousTournamentButton;

    @FXML
    private Button sideBarButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        footballMatchesInfoArea.setEditable(false);
        footballTournamentsInfoArea.setEditable(false);
        footballMatchesInfoArea.setWrapText(true);
        footballTournamentsInfoArea.setWrapText(true);
        matchIndex = 0;
        tournamentIndex = 0;
        timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        displayMatches(matchIndex);
        displayTournaments(tournamentIndex);
    }

    @FXML
    void joinMatchButtonClicked(ActionEvent event) 
    {
        ArrayList<Integer> IDs = Database.getEvents(0);

        if (!IDs.isEmpty()) 
        {
            int id = IDs.get(matchIndex);
            ArrayList<String> participants  = Database.getEventParticipants(id);
            if (participants.size() < 2 * Database.getEventSize(id, 0)) 
            {
                if (!participants.contains(Model.getInstance().getEmail())) 
                {
                    Database.joinEvent(Model.getInstance().getEmail(), id);
                    Database.addParticipant(Model.getInstance().getEmail(), id);
                }
                else 
                {
                    System.out.println("you in event");
                }
            }
            else 
            {
                System.out.println("event full");
                
            }
        }
        
    }

    @FXML
    void viewTournamentButtonClicked(ActionEvent event) 
    {
        ArrayList<Integer> footballTournaments = Database.getEvents(1);
        Model.getInstance().setTournament(footballTournaments.get(tournamentIndex));
        Model.getInstance().setParameter(1);
        Model.getInstance().getViewFactory().getDecider().set("TournamentView");
    }

    @FXML
    void previousMatchButtonClicked(ActionEvent event) 
    {
        if(matchIndex > 0)
        {
            matchIndex--;
            displayMatches(matchIndex);
        }
    }

    @FXML
    void nextMatchButtonClicked(ActionEvent event) 
    {
        if(matchIndex < Database.getEvents(0).size()-1)
        {
            matchIndex++;
            displayMatches(matchIndex);
        }
    }

    @FXML
    void previousTournamentButtonClicked(ActionEvent event) 
    {
        if(tournamentIndex > 0)
        {
            tournamentIndex--;
            displayTournaments(tournamentIndex);
        }
    }

    @FXML
    void nextTournamentButtonClicked(ActionEvent event) 
    {
        if(tournamentIndex < Database.getEvents(1).size()-1)
        {
            tournamentIndex++;
            displayTournaments(tournamentIndex);
        }
    }

    @FXML
    void sideBarButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        
        if(Model.getInstance().getViewFactory().getIsSideBarOpen()) 
        {
            Model.getInstance().getViewFactory().getDecider().set("FootballEvents+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("FootballEvents");
        }
    }

    void displayMatches(int index)
    {
        String datetime = "";
        String date = "";
        String time = "";
        String place = "";
        String details = "";
        String seperator = "------------------------------------------------";
        String info = "";
        ArrayList<Integer> footballMatches = Database.getEvents(0);
        
        if (footballMatches.size() > 0) 
        {
            int id = footballMatches.get(index);
            matchName.setText(Database.getEventName(id, 0));
    
            datetime = Database.getDateTime(id, 0).format(timeFormatter);
            date = datetime.substring(0,10);
            time = datetime.substring(11, 16);
            place = Database.getPlace(id, 0);
            details = Database.getDetails(id, 0);
            info += "Date: " + date + "\n" + seperator + "\n" + "Time: " + time + "\n" + seperator + "\n" + "Place: " + place + "\n"  + seperator + "\n" + "Details: " + details;
        }
        else 
        {
            matchName.setText("");
            info = "Currently there is no such event";
        }        
        footballMatchesInfoArea.setText(info);
    }

    void displayTournaments(int index)
    {
        String datetime = "";
        String date = "";
        String time = "";
        String place = "";
        String details = "";
        String seperator = "------------------------------------------------";
        String info = "";
        ArrayList<Integer> footballTournaments = Database.getEvents(1);
        
        if (footballTournaments.size() > 0) 
        {
            int id = footballTournaments.get(index);
            tournamentName.setText(Database.getEventName(id, 0));
    
            datetime = Database.getDateTime(id, 1).format(timeFormatter);
            date = datetime.substring(0,10);
            time = datetime.substring(11, 16);
            place = Database.getPlace(id, 1);
            details = Database.getDetails(id, 1);
            info += "Date: " + date + "\n" + seperator + "\n" + "Time: " + time + "\n" + seperator + "\n" + "Place: " + place + "\n"  + seperator + "\n" + "Details: " + details;
        }
        else 
        {
            tournamentName.setText("");
            info = "Currently there is no such event";
        }        
        footballTournamentsInfoArea.setText(info);
    }
}
