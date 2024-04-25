

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class TennisEventsController {

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

    @FXML
    void joinMatchButtonClicked(ActionEvent event) {

    }

    @FXML
    void joinTournamentButtonClicked(ActionEvent event) {

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
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents");
        }
    }

}
