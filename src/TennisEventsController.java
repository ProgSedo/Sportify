
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

public class TennisEventsController implements Initializable {

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

    @FXML
    private TextArea tennisMatchesInfoArea;

    @FXML
    private TextArea tennisTournamentsInfoArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tennisMatchesInfoArea.setEditable(false);
        tennisTournamentsInfoArea.setEditable(false);
        tennisMatchesInfoArea.setWrapText(true);
        tennisTournamentsInfoArea.setWrapText(true);
        matchIndex = 0;
        tournamentIndex = 0;
        timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        displayMatches(matchIndex);
        displayTournaments(tournamentIndex);
    }

    @FXML
    void joinMatchButtonClicked(ActionEvent event) {
        ArrayList<Integer> IDs = Database.getEvents(4);

        if (!IDs.isEmpty()) {
            int id = IDs.get(matchIndex);
            ArrayList<String> participants = Database.getEventParticipants(id);
            if (participants.size() < 2 * Database.getEventSize(id, 4)) {
                if (!participants.contains(Model.getInstance().getEmail())) {
                    Database.joinEvent(Model.getInstance().getEmail(), id);
                    Database.addParticipant(Model.getInstance().getEmail(), id);
                } else {
                    System.out.println("you in event");
                }
            }

            else {
                System.out.println("event full");

            }
        }
    }

    @FXML
    void viewTournamentButtonClicked(ActionEvent event) {
        ArrayList<Integer> tennisTournaments = Database.getEvents(5);
        if (tennisTournaments.size() > 0) {
            Model.getInstance().setTournament(tennisTournaments.get(tournamentIndex));
            Model.getInstance().setParameter(5);
            Model.getInstance().getViewFactory().getDecider().set("TournamentView");
        }
    }

    @FXML
    void previousMatchButtonClicked(ActionEvent event) {
        if (matchIndex > 0) {
            matchIndex--;
            displayMatches(matchIndex);
        }
    }

    @FXML
    void nextMatchButtonClicked(ActionEvent event) {
        if (matchIndex < Database.getEvents(4).size() - 1) {
            matchIndex++;
            displayMatches(matchIndex);
        }
    }

    @FXML
    void previousTournamentButtonClicked(ActionEvent event) {
        if (tournamentIndex > 0) {
            tournamentIndex--;
            displayTournaments(tournamentIndex);
        }
    }

    @FXML
    void nextTournamentButtonClicked(ActionEvent event) {
        if (tournamentIndex < Database.getEvents(5).size() - 1) {
            tournamentIndex++;
            displayTournaments(tournamentIndex);
        }
    }

    @FXML
    void sideBarButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if (Model.getInstance().getViewFactory().getIsSideBarOpen()) {
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents+");
        } else {
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents");
        }
    }

    void displayMatches(int index) {
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
            date = datetime.substring(0, 10);
            time = datetime.substring(11, 16);
            place = Database.getPlace(id, 4);
            details = Database.getDetails(id, 4);

            info += "Date: " + date + "\n" + seperator + "\n" + "Time: " + time + "\n" + seperator + "\n" + "Place: "
                    + place + "\n" + seperator + "\n" + "Details: " + details;

        } else {
            matchName.setText("");
            info = "Currently there is no such event";
        }
        tennisMatchesInfoArea.setText(info);
    }

    void displayTournaments(int index) {
        String datetime = "";
        String date = "";
        String time = "";
        String place = "";
        String details = "";
        String seperator = "------------------------------------------------";
        String info = "";
        ArrayList<Integer> tennisTournaments = Database.getEvents(5);

        if (tennisTournaments.size() > 0) {
            int id = tennisTournaments.get(index);

            tournamentName.setText(Database.getEventName(id, 5));
            datetime = Database.getDateTime(id, 5).format(timeFormatter);
            date = datetime.substring(0, 10);
            time = datetime.substring(11, 16);
            place = Database.getPlace(id, 5);
            details = Database.getDetails(id, 5);

            info += "Date: " + date + "\n" + seperator + "\n" + "Time: " + time + "\n" + seperator + "\n" + "Place: "
                    + place + "\n" + seperator + "\n" + "Details: " + details;

        } else {
            tournamentName.setText("");
            info = "Currently there is no such event";
        }
        tennisTournamentsInfoArea.setText(info);
    }

}
