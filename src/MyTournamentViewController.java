import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MyTournamentViewController implements Initializable {
    @FXML
    private Button announceButton;

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
    private TextField fourthRound;

    @FXML
    private TextArea participantsTextArea;

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
    private Button unjoinButton;

    @FXML
    private Label warningLabel;

    @FXML
    void announceButtonClicked(ActionEvent event) {

        displayTournament();
    }

    @FXML
    void backButtonClicked(ActionEvent event) {
        if (Model.getInstance().getParameter() == 1) {
            Model.getInstance().getViewFactory().getDecider().set("MyFootballEvents");
        }
        if (Model.getInstance().getParameter() == 3) {
            Model.getInstance().getViewFactory().getDecider().set("MyVolleyballEvents");
        }
        if (Model.getInstance().getParameter() == 5) {
            Model.getInstance().getViewFactory().getDecider().set("MyTennisEvents");
        }
    }

    @FXML
    void unjoinButtonClicked(ActionEvent event) {
        int id = Model.getInstance().getTournament();
        String email = Model.getInstance().getEmail();
        Database.deleteParticipant(email, id);
        Database.unjoinEvent(email, id);

        if (Model.getInstance().getParameter() == 1) {
            Model.getInstance().getViewFactory().getDecider().set("MyFootballEvents");
        }
        if (Model.getInstance().getParameter() == 3) {
            Model.getInstance().getViewFactory().getDecider().set("MyVolleyballEvents");
        }
        if (Model.getInstance().getParameter() == 5) {
            Model.getInstance().getViewFactory().getDecider().set("MyTennisEvents");
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

    public void displayTournament() {
        ArrayList<String> participants = Database.getEventParticipants(Model.getInstance().getTournament());

        if (participants.size() > 0) {
            String participantString = "";

            for (int i = 0; i < participants.size(); i++) {
                participantString += participants.get(i) + "\n";
            }
            participantsTextArea.setText(participantString);
            warningLabel.setText(participants.size() + " / 8" );
        }

        else {
            warningLabel.setText("No participants");
        }
    }

}
