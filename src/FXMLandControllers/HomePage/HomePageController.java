package FXMLandControllers.HomePage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomePageController {

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
    private Button footballMatchButton;

    @FXML
    private Button footballTournamentButton;

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
    private Button tennisMatchButton;

    @FXML
    private Button tennisTournamentButton;

    @FXML
    private Button volleyballMatchButton;

    @FXML
    private Button volleyballTournamentButton;

    @FXML
    void eventsFootballButtonClicked(ActionEvent event) {

        Parent root = FXMLLoader.load(getClass().getResource("FootballEvents.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void eventsTennisButtonClicked(ActionEvent event) {

        Parent root = FXMLLoader.load(getClass().getResource("TennisEvents.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void eventsVolleyballlButtonClicked(ActionEvent event) {

        Parent root = FXMLLoader.load(getClass().getResource("VolleyballEvents.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void footballMatchButtonClicked(ActionEvent event) {
        
    }

    @FXML
    void footballTournamentButtonClicked(ActionEvent event) {

    }

    @FXML
    void forumsFootballButtonClicked(ActionEvent event) {

        Parent root = FXMLLoader.load(getClass().getResource("FootballForum.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void forumsTennisButtonClicked(ActionEvent event) {

        Parent root = FXMLLoader.load(getClass().getResource("TennisForum.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void forumsVolleyballButtonClicked(ActionEvent event) {

        Parent root = FXMLLoader.load(getClass().getResource("VolleyballForum.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void friendsPageButtonClicked(ActionEvent event) {

        
    }

    @FXML
    void menuBarButtonClicked(ActionEvent event) {

    }

    @FXML
    void tennisMatchButtonClicked(ActionEvent event) {

    }

    @FXML
    void tennisTournamentButtonClicked(ActionEvent event) {

    }

    @FXML
    void volleyballMatchButtonClicked(ActionEvent event) {

    }

    @FXML
    void volleyballTournamentButtonClicked(ActionEvent event) {

    }

}

