import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TournamentViewController implements Initializable {
    @FXML
    private Button announceButton;

    @FXML
    private Button joinButton;

    @FXML
    private TextArea participantsTextArea;

    @FXML
    private Button backButton;

    @FXML
    private TextField firstRound1;

    @FXML
    private TextField firstRound2;

    @FXML
    private TextField firstRound3;

    @FXML
    private TextField firstRound4;

    @FXML
    private TextField firstRound5;

    @FXML
    private TextField firstRound6;

    @FXML
    private TextField firstRound7;

    @FXML
    private TextField firstRound8;

    @FXML
    private TextField secondRound1;

    @FXML
    private TextField secondRound2;

    @FXML
    private TextField secondRound3;

    @FXML
    private TextField secondRound4;

    @FXML
    private TextField thirdRound1;

    @FXML
    private TextField thirdRound2;

    @FXML
    private TextField fourthRound;

    @FXML
    private Label warningLabel;

    @FXML
    private Label infoLabel;

    @FXML
    void announceButtonClicked(ActionEvent event) {

        firstRound1.setText("EMPTY");
        firstRound2.setText("EMPTY");
        firstRound3.setText("EMPTY");
        firstRound4.setText("EMPTY");
        firstRound5.setText("EMPTY");
        firstRound6.setText("EMPTY");
        firstRound7.setText("EMPTY");
        firstRound8.setText("EMPTY");

        secondRound1.setText("TBA");
        secondRound2.setText("TBA");
        secondRound3.setText("TBA");
        secondRound4.setText("TBA");
        thirdRound1.setText("TBA");
        thirdRound2.setText("TBA");
        fourthRound.setText("TBA");
        ArrayList<String> participants;
        int id = Model.getInstance().getTournament();
        // if it is not tennis
        if (Model.getInstance().getParameter() != 5) {
            ArrayList<String> teams = new ArrayList<>();
            participants = Database.getEventParticipants(id);
            for (String e : participants) {
                teams.add(Database.getTeamName(e));
            }

            int size = participants.size();
            Collections.shuffle(teams);
            if (size >= 1)
                firstRound1.setText(teams.get(size - 1));
            if (size >= 2)
                firstRound2.setText(teams.get(size - 2));
            if (size >= 3)
                firstRound3.setText(teams.get(size - 3));
            if (size >= 4)
                firstRound4.setText(teams.get(size - 4));
            if (size >= 5)
                firstRound5.setText(teams.get(size - 5));
            if (size >= 6)
                firstRound6.setText(teams.get(size - 6));
            if (size >= 7)
                firstRound6.setText(teams.get(size - 7));
            if (size >= 8)
                firstRound6.setText(teams.get(size - 8));

        }
        // if it is tennis
        else {
            participants = Database.getEventParticipants(id);
            Collections.shuffle(participants);
            int size = participants.size();
            if (size >= 1)
                firstRound1.setText(participants.get(size - 1));
            if (size >= 2)
                firstRound2.setText(participants.get(size - 2));
            if (size >= 3)
                firstRound3.setText(participants.get(size - 3));
            if (size >= 4)
                firstRound4.setText(participants.get(size - 4));
            if (size >= 5)
                firstRound5.setText(participants.get(size - 5));
            if (size >= 6)
                firstRound6.setText(participants.get(size - 6));
            if (size >= 7)
                firstRound6.setText(participants.get(size - 7));
            if (size >= 8)
                firstRound6.setText(participants.get(size - 8));

        }

        displayTournament();
    }

    @FXML
    void joinButtonClicked(ActionEvent event) {
        int id = Model.getInstance().getTournament();
        int parameter = Model.getInstance().getParameter();
        String email = Model.getInstance().getEmail();
        ArrayList<String> participants = Database.getEventParticipants(id);
        ArrayList<String> teams = new ArrayList<>();
        for (String e : participants) {
            teams.add(Database.getTeamName(e));
        }
        if (Database.getTeamName(email) == null && Model.getInstance().getParameter() != 5) {
            warningLabel.setText("you need a team");
            return;
        }
        if (participants.size() < 2 * Database.getEventSize(id, parameter)) {
            if (!participants.contains(email) && !teams.contains(Database.getTeamName(email))) {
                Database.joinEvent(email, id);
                Database.addParticipant(email, id);
            } else {
                warningLabel.setText("You have already joined");
            }
        } else {
            warningLabel.setText("Event is full");
        }
        displayTournament();
    }

    @FXML
    void backButtonClicked(ActionEvent event) {
        if (Model.getInstance().getParameter() == 1) {
            Model.getInstance().getViewFactory().getDecider().set("FootballEvents");
        }
        if (Model.getInstance().getParameter() == 3) {
            Model.getInstance().getViewFactory().getDecider().set("VolleyballEvents");
        }
        if (Model.getInstance().getParameter() == 5) {
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents");
        }
    }

    ArrayList<String> draw() {
        ArrayList<String> participants = Database.getEventParticipants(Model.getInstance().getTournament());
        ArrayList<String> draw = new ArrayList<String>();
        int ln = participants.size();
        int rnd;
        for (int i = 0; i < ln; i++) {
            rnd = (int) ((ln - i) * Math.random());
            draw.add(participants.get(rnd));
            participants.remove(rnd);
        }
        return draw;
    }

    public void displayTournament() {
        ArrayList<String> participants = Database.getEventParticipants(Model.getInstance().getTournament());

        if (Model.getInstance().getParameter() != 5) {
            if (participants.size() > 0) {
                String participantString = "";

                for (int i = 0; i < participants.size(); i++) {
                    participantString += Database.getTeamName(participants.get(i)) + "\n";
                }
                participantsTextArea.setText(participantString);
                infoLabel.setText(participants.size() + " / 8");
            }

            else {
                warningLabel.setText("No participants");
            }
        } else {
            if (participants.size() > 0) {
                String participantString = "";

                for (int i = 0; i < participants.size(); i++) {
                    participantString += participants.get(i) + "\n";
                }
                participantsTextArea.setText(participantString);
                infoLabel.setText(participants.size() + " / 8");
            }

            else {
                warningLabel.setText("No participants");
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstRound1.setEditable(false);
        firstRound2.setEditable(false);
        firstRound3.setEditable(false);
        firstRound4.setEditable(false);
        firstRound5.setEditable(false);
        firstRound6.setEditable(false);
        firstRound7.setEditable(false);
        firstRound8.setEditable(false);
        secondRound1.setEditable(false);
        secondRound2.setEditable(false);
        secondRound3.setEditable(false);
        secondRound4.setEditable(false);
        thirdRound1.setEditable(false);
        thirdRound2.setEditable(false);
        fourthRound.setEditable(false);
        participantsTextArea.setEditable(false);

        displayTournament();
    }
}
