

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class TennisEventsController implements Initializable{

    private int matchIndex;
    private int tournamentIndex;
    private DateTimeFormatter timeFormatter;

    @FXML
    private Label matchName;

    @FXML
    private Label tournamentName;

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

    @FXML
    private TextArea tennisMatchesInfoArea;

    @FXML
    private TextArea tennisTournamentsInfoArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        tennisMatchesInfoArea.setEditable(false);
        tennisTournamentsInfoArea.setEditable(false);
        tennisMatchesInfoArea.setWrapText(true);
        tennisTournamentsInfoArea.setWrapText(true);
        matchIndex = 0;
        tournamentIndex = 0;
        timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        displayMatches(matchIndex);
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
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents");
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
        ArrayList<Integer> tennisMatches = Database.getEvents(4);

        if (tennisMatches.size() > 0) {
            int id = tennisMatches.get(index);

        matchName.setText(Database.getEventName(id, 4));
        datetime = Database.getDateTime(id, 4).format(timeFormatter);
        date = datetime.substring(0,10);
        time = datetime.substring(11, 16);
        place = Database.getPlace(id, 4);
        details = Database.getDetails(id, 4);

        info += "Date: " + date + "\n" + seperator + "\n" + "Time: " + time + "\n" + seperator + "\n" + "Place: " + place + "\n"  + seperator + "\n" + "Details: " + details;
        
        }
        else {
            info = "Currently there is no such event";
        }      
        tennisMatchesInfoArea.setText(info);
    }

    void displayTournaments(int index)
    {
        
    }

}
