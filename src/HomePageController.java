

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomePageController {

    @FXML
    private Button createEventButton;

    @FXML
    private Label createEventLabel;

    @FXML
    private Label createMatchLabel;

    @FXML
    private Label createTournamentButton;

    @FXML
    private Button eventsFootballButton;

    @FXML
    private Label eventsLabel;

    @FXML
    private Button eventsTennisButton;

    @FXML
    private Button eventsVolleyBallButton;

    @FXML
    private Button forumsFootballButton;

    @FXML
    private Label forumsLabel;

    @FXML
    private Button forumsTennisButton;

    @FXML
    private Button forumsVolleyballButton;

    @FXML
    private Button friendsPageButton;

    @FXML
    private Label friendsSectionLabel;

    @FXML
    private Label homePageLabel;

    @FXML
    private Button menuBarButton;

    @FXML
    void createEventButtonClicked(ActionEvent event) {

    }

    @FXML
    void eventsFootballButtonClicked(ActionEvent event) {

    }

    @FXML
    void eventsTennisButtonClicked(ActionEvent event) {

    }

    @FXML
    void eventsVolleyballlButtonClicked(ActionEvent event) {

    }

    @FXML
    void forumsFootballButtonClicked(ActionEvent event) {

    }

    @FXML
    void forumsTennisButtonClicked(ActionEvent event) {

    }

    @FXML
    void forumsVolleyballButtonClicked(ActionEvent event) {

    }

    @FXML
    void friendsPageButtonClicked(ActionEvent event) {

    }

    @FXML
    void menuBarButtonClicked(ActionEvent event) 
    {
        Stage stage =(Stage) menuBarButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().getDecider().set("HomePage+");
    }

}


