

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FootballEventsController {

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
            Model.getInstance().getViewFactory().getDecider().set("FootballEvents+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("FootballEvents");
        }
    }

}
