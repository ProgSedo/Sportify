import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TournamentViewController 
{
    @FXML
    private Button announceButton;

    @FXML
    private Button joinButton;

    @FXML
    private TextArea participantsTextArea;

    @FXML
    private Button backButton;

    @FXML
    private TextField start1;

    @FXML
    private TextField start2;

    @FXML
    private TextField start3;

    @FXML
    private TextField start4;

    @FXML
    private TextField start5;

    @FXML
    private TextField start6;

    @FXML
    private TextField start7;

    @FXML
    private TextField start8;

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
    void announceButtonClicked(ActionEvent event) 
    {

    }

    @FXML
    void joinButtonClicked(ActionEvent event) 
    {
        int id = Model.getInstance().getTournament();
        int parameter = Model.getInstance().getParameter();
        String email = Model.getInstance().getEmail();
        ArrayList<String> participants  = Database.getEventParticipants(id);

        if (participants.size() < 2 * Database.getEventSize(id, parameter)) 
        {
            if (!participants.contains(email)) 
            {
                Database.joinEvent(email, id);
                Database.addParticipant(email, id);
            }
            else 
            {
                warningLabel.setText("You have already joined");
            }
        }  
        else 
        {
            warningLabel.setText("Event is full");
        }

    }

    @FXML
    void backButtonClicked(ActionEvent event) 
    {
        if(Model.getInstance().getParameter() == 1)
        {
            Model.getInstance().getViewFactory().getDecider().set("FootballEvents");
        }
        if(Model.getInstance().getParameter() == 3)
        {
            Model.getInstance().getViewFactory().getDecider().set("VolleyballEvents");
        }
        if(Model.getInstance().getParameter() == 5)
        {
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents");
        }
    }

    ArrayList<String> draw()
    {
        ArrayList<String> participants = Database.getEventParticipants(Model.getInstance().getTournament());
        ArrayList<String> draw = new ArrayList<String>();
        int ln = participants.size();
        int rnd;
        for(int i = 0; i < ln; i++)
        {
            rnd = (int)((ln-i) * Math.random());
            draw.add(participants.get(rnd));
            participants.remove(rnd);
        }
        return draw;
    }
}
