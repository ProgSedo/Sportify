

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
    private Button joinTournamentButton;

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
    }

    @FXML
    void joinMatchButtonClicked(ActionEvent event) 
    {
        
    }

    @FXML
    void joinTournamentButtonClicked(ActionEvent event) 
    {

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
        System.out.println("aaaaaaaaaaa");
        String datetime = "";
        String date = "";
        String time = "";
        String place = "";
        String details = "";
        String seperator = "------------------------------------------------";
        String info = "";
        ArrayList<Integer> footballMatches = Database.getEvents(0);
        int id = footballMatches.get(index);

        matchName.setText(Database.getEventName(id, 0));
        datetime = Database.getDateTime(id, 0).format(timeFormatter);
        date = datetime.substring(0,10);
        time = datetime.substring(11, 16);
        place = Database.getPlace(id, 0);
        details = Database.getDetails(id, 0);

        info += "Date: " + date + "\n" + seperator + "\n" + "Time: " + time + "\n" + seperator + "\n" + "Place: " + place + "\n"  + seperator + "\n" + "Details: " + details;
        footballMatchesInfoArea.setText(info);
    }

    void displayTournaments(int index)
    {

    }
}
