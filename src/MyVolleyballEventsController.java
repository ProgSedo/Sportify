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

public class MyVolleyballEventsController implements Initializable
{
    private int matchIndex;
    private int tournamentIndex;
    private DateTimeFormatter timeFormatter;

    @FXML
    private Label matchName;
    
    @FXML
    private Label tournamentName;

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

    @FXML
    private TextArea volleyballMatchesInfoArea;

    @FXML
    private TextArea volleyballTournamentsInfoArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        volleyballMatchesInfoArea.setEditable(false);
        volleyballTournamentsInfoArea.setEditable(false);
        volleyballMatchesInfoArea.setWrapText(true);
        volleyballTournamentsInfoArea.setWrapText(true);
        matchIndex = 0;
        tournamentIndex = 0;
        timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        displayMatches(matchIndex);
        displayTournaments(tournamentIndex);
    }

    @FXML
    void nextMatchButtonClicked(ActionEvent event) 
    {
        if(matchIndex < Database.getUserEvents(Model.getInstance().getEmail(),3).size()-1)
        {
            matchIndex++;
            displayMatches(matchIndex);
        }
    }

    @FXML
    void nextTournamentButtonClicked(ActionEvent event) 
    {
        if(tournamentIndex < Database.getEvents(3).size()-1)
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
    void previousTournamentButtonClicked(ActionEvent event) 
    {
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
            Model.getInstance().getViewFactory().getDecider().set("MyVolleyballEvents+");
        }
        else
        {
            Model.getInstance().getViewFactory().getDecider().set("MyVolleyballEvents");
        }
    }

    @FXML
    void unjoinMatchButtonClicked(ActionEvent event) 
    {
        ArrayList<Integer> volleyballMatches = Database.getUserEvents(Model.getInstance().getEmail(),2);
        if(volleyballMatches.size() > 0)
        {
            Database.deleteParticipant(Model.getInstance().getEmail(), volleyballMatches.get(matchIndex));
            Database.unjoinEvent(Model.getInstance().getEmail(), volleyballMatches.get(matchIndex));
            matchIndexManager();
            displayMatches(matchIndex);
        }
    }

    @FXML
    void viewTournamentButtonClicked(ActionEvent event) 
    {
        ArrayList<Integer> volleyballTournaments = Database.getUserEvents(Model.getInstance().getEmail(),3);
        Model.getInstance().setTournament(volleyballTournaments.get(tournamentIndex));
        Model.getInstance().setParameter(3);
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
        ArrayList<Integer> volleyballMatches = Database.getUserEvents(Model.getInstance().getEmail(), 2);

        if (volleyballMatches.size() > 0) 
        {
            int id = volleyballMatches.get(index);
            matchName.setText(Database.getEventName(id, 2));
            datetime = Database.getDateTime(id, 2).format(timeFormatter);
            date = datetime.substring(0,10);
            time = datetime.substring(11, 16);
            place = Database.getPlace(id, 2);
            details = Database.getDetails(id, 2);
            info += "Date: " + date + "\n" + seperator + "\n" + "Time: " + time + "\n" + seperator + "\n" + "Place: " + place + "\n"  + seperator + "\n" + "Details: " + details;
        }

        else 
        {
            matchName.setText("");
            info = "Currently there is no such event";
        }      
        volleyballMatchesInfoArea.setText(info);
    }

    void matchIndexManager()
    {
        ArrayList<Integer> volleyballMatches = Database.getUserEvents(Model.getInstance().getEmail(),2);
        if(matchIndex > volleyballMatches.size()-1)
        {
            matchIndex = Math.max(volleyballMatches.size()-1,0);
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
        ArrayList<Integer> volleyballTournaments = Database.getUserEvents(Model.getInstance().getEmail(), 3);

        if (volleyballTournaments.size() > 0) {
            int id = volleyballTournaments.get(index);

        tournamentName.setText(Database.getEventName(id, 3));
        datetime = Database.getDateTime(id, 3).format(timeFormatter);
        date = datetime.substring(0,10);
        time = datetime.substring(11, 16);
        place = Database.getPlace(id, 3);
        details = Database.getDetails(id, 3);

        info += "Date: " + date + "\n" + seperator + "\n" + "Time: " + time + "\n" + seperator + "\n" + "Place: " + place + "\n"  + seperator + "\n" + "Details: " + details;
        
        }

        else {
            info = "Currently there is no such event";
        }      
        volleyballTournamentsInfoArea.setText(info);
    }
}

