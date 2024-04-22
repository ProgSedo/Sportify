

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
        Model.getInstance().getViewFactory().getDecider().set("CreateEvents");
    }

    @FXML
    void eventsFootballButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().getDecider().set("FootballEvents");
    }

    @FXML
    void eventsTennisButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().getDecider().set("TennisEvents");
    }

    @FXML
    void eventsVolleyballlButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().getDecider().set("VolleyballEvents");
    }

    @FXML
    void forumsFootballButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().getDecider().set("FootballForumPage");
    }

    @FXML
    void forumsTennisButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().getDecider().set("TennisForumPage");
    }

    @FXML
    void forumsVolleyballButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().getDecider().set("VolleyballForumPage");
    }

    @FXML
    void friendsPageButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().getDecider().set("FriendsPage");
    }

    @FXML
    void menuBarButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen())
        {
            Model.getInstance().getViewFactory().getDecider().set("HomePage+");
        }
        else
        {
            Model.getInstance().getViewFactory().getDecider().set("HomePage");
        }
    }

}


