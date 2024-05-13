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

public class MyFootballEventsController implements Initializable
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
    private Button nextMatchButton;

    @FXML
    private Button nextTournamentButton;

    @FXML
    private Button previousMatchButton;

    @FXML
    private Button previousTournamentButton;

    @FXML
    private Button sideBarButton;

    @FXML
    private Button unjoinMatchButton;

    @FXML
    private Button viewTournamentButton;

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
    void nextMatchButtonClicked(ActionEvent event) 
    {
        if(matchIndex < Database.getUserEvents(Model.getInstance().getEmail(),0).size()-1)
        {
            matchIndex++;
            displayMatches(matchIndex);
        }
    }

    @FXML
    void nextTournamentButtonClicked(ActionEvent event) {
        if(tournamentIndex < Database.getEvents(1).size()-1)
        {
            tournamentIndex++;
            displayTournaments(tournamentIndex);
        }
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
    void previousTournamentButtonClicked(ActionEvent event) {
        if(tournamentIndex > 0)
        {
            tournamentIndex--;
            displayTournaments(tournamentIndex);
        }
    }

    @FXML
    void sideBarButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen())
        {
            Model.getInstance().getViewFactory().getDecider().set("MyFootballEvents+");
        }
        else
        {
            Model.getInstance().getViewFactory().getDecider().set("MyFootballEvents");
        }
    }

    @FXML
    void unjoinMatchButtonClicked(ActionEvent event) 
    {
        System.out.println("aa");
        ArrayList<Integer> footballMatches = Database.getUserEvents(Model.getInstance().getEmail(),0);
        if(footballMatches.size() > 0)
        {
            Database.deleteParticipant(Model.getInstance().getEmail(), footballMatches.get(matchIndex));
            Database.unjoinEvent(Model.getInstance().getEmail(), footballMatches.get(matchIndex));
            matchIndexManager();
            displayMatches(matchIndex);
        }
    }

    @FXML
    void viewTournamentButtonClicked(ActionEvent event) 
    {
        ArrayList<Integer> footballTournaments = Database.getUserEvents(Model.getInstance().getEmail(),1);
        Model.getInstance().setTournament(footballTournaments.get(tournamentIndex));
        Model.getInstance().setParameter(1);
        Model.getInstance().getViewFactory().getDecider().set("MyTournamentView");
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
        ArrayList<Integer> footballMatches = Database.getUserEvents(Model.getInstance().getEmail(),0);
        
        
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

    void matchIndexManager()
    {
        ArrayList<Integer> footballMatches = Database.getUserEvents(Model.getInstance().getEmail(),0);
        if(matchIndex > footballMatches.size()-1)
        {
            matchIndex = Math.max(footballMatches.size()-1,0);
        }
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
        ArrayList<Integer> footballTournaments = Database.getUserEvents(Model.getInstance().getEmail(), 1);
        
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
            info = "Currently there is no such event";
        }        
        footballTournamentsInfoArea.setText(info);
    }
}

