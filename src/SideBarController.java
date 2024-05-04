
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
        Model.getInstance().getViewFactory().getDecider().set("HomePage");
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().viewNuller();
        Model.getInstance().getViewFactory().getDecider().set("Logout");
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
    }

    @FXML
    void profileButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().getDecider().set("Profile");
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
    }

    @FXML
    void settingsButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().getDecider().set("Settings");
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
    }

}

