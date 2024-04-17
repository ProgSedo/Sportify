
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SideBarController {

    @FXML
    private Button HomePageButton;

    @FXML
    private Button LogoutButton;

    @FXML
    private Button ProfileButton;

    @FXML
    private Button SettingsButton;

    @FXML
    void homePageButtonClicked(ActionEvent event) {

    }

    @FXML
    void logoutButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().getDecider().set("Logout");
    }

    @FXML
    void profileButtonClicked(ActionEvent event) {

    }

    @FXML
    void settingsButtonClicked(ActionEvent event) {

    }

}

