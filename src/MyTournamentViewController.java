import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MyTournamentViewController 
{
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

    }

    @FXML
    void backButtonClicked(ActionEvent event) 
    {
        if(Model.getInstance().getParameter() == 1)
        {
            Model.getInstance().getViewFactory().getDecider().set("MyFootballEvents");
        }
        if(Model.getInstance().getParameter() == 3)
        {
            Model.getInstance().getViewFactory().getDecider().set("MyVolleyballEvents");
        }
        if(Model.getInstance().getParameter() == 5)
        {
            Model.getInstance().getViewFactory().getDecider().set("MyTennisEvents");
        }
    }

    @FXML
    void unjoinButtonClicked(ActionEvent event) 
    {
        int id = Model.getInstance().getTournament();
        String email = Model.getInstance().getEmail();
        Database.deleteParticipant(email,id);
        Database.unjoinEvent(email,id);

        if(Model.getInstance().getParameter() == 1)
        {
            Model.getInstance().getViewFactory().getDecider().set("MyFootballEvents");
        }
        if(Model.getInstance().getParameter() == 3)
        {
            Model.getInstance().getViewFactory().getDecider().set("MyVolleyballEvents");
        }
        if(Model.getInstance().getParameter() == 5)
        {
            Model.getInstance().getViewFactory().getDecider().set("MyTennisEvents");
        }
    }

}

