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

public class MyTennisEventsController implements Initializable 
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
    private TextArea tennisMatchesInfoArea;

    @FXML
    private TextArea tennisTournamentsInfoArea;

    @FXML
    private Button unjoinMatchButton;

    @FXML
    private Button unjoinTournamentButton;

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
    void nextMatchButtonClicked(ActionEvent event) 
    {
        if(matchIndex < Database.getUserEvents(Model.getInstance().getEmail(),4).size()-1)
        {
            matchIndex++;
            displayMatches(matchIndex);
        }
    }

    @FXML
    void nextTournamentButtonClicked(ActionEvent event) {

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

    }

    @FXML
    void sideBarButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen())
        {
            Model.getInstance().getViewFactory().getDecider().set("MyTennisEvents+");
        }
        else
        {
            Model.getInstance().getViewFactory().getDecider().set("MyTennisEvents");
        }
    }

    @FXML
    void unjoinMatchButtonClicked(ActionEvent event)
    {
        ArrayList<Integer> tennisMatches = Database.getUserEvents(Model.getInstance().getEmail(),4);
        if(tennisMatches.size() > 0)
        {
            Database.deleteParticipant(Model.getInstance().getEmail(), tennisMatches.get(matchIndex));
            Database.unjoinEvent(Model.getInstance().getEmail(), tennisMatches.get(matchIndex));
            matchIndexManager();
            displayMatches(matchIndex);
        }
    }

    @FXML
    void unjoinTournamentButtonClicked(ActionEvent event) {

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
        ArrayList<Integer> tennisMatches = Database.getUserEvents(Model.getInstance().getEmail(),4);

        if (tennisMatches.size() > 0) 
        {
            int id = tennisMatches.get(index);
            matchName.setText(Database.getEventName(id, 4));
            datetime = Database.getDateTime(id, 4).format(timeFormatter);
            date = datetime.substring(0,10);
            time = datetime.substring(11, 16);
            place = Database.getPlace(id, 4);
            details = Database.getDetails(id, 4);
            info += "Date: " + date + "\n" + seperator + "\n" + "Time: " + time + "\n" + seperator + "\n" + "Place: " + place + "\n"  + seperator + "\n" + "Details: " + details;
        }
        else 
        {
            matchName.setText("");
            info = "Currently there is no such event";
        }      
        tennisMatchesInfoArea.setText(info);
    }

    void matchIndexManager()
    {
        ArrayList<Integer> tennisMatches = Database.getUserEvents(Model.getInstance().getEmail(),4);
        if(matchIndex > tennisMatches.size()-1)
        {
            matchIndex = Math.max(tennisMatches.size()-1,0);
        }
    }
}

