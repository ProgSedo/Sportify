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
    private Button unjoinTournamentButton;

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
    }

    @FXML
    void nextMatchButtonClicked(ActionEvent event) {

    }

    @FXML
    void nextTournamentButtonClicked(ActionEvent event) {

    }

    @FXML
    void previousMatchButtonClicked(ActionEvent event) {

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
        
    }

    @FXML
    void unjoinTournamentButtonClicked(ActionEvent event) 
    {
        
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
        ArrayList<Integer> footballMatches = Database.getUserEvents(Model.getInstance().getEmail());
        
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
            info = "Currently there is no such event";
        }        
        footballMatchesInfoArea.setText(info);
    }

}

