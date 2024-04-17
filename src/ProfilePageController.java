

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ProfilePageController {

    @FXML
    private TextArea aboutMeTextArea;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextArea commentsTextArea;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField interestsTextField;

    @FXML
    private ImageView profilePhoto;

    @FXML
    private Button sideBarButton;

    @FXML
    private TextField usernameTextField;
    private boolean isSideOpen;

    @FXML
    void sideBarButtonClicked(ActionEvent event) {
        if(isSideOpen == false) {
        Model.getInstance().getViewFactory().getDecider().set("Profile+");
        isSideOpen = true;
        }
        else {
        Model.getInstance().getViewFactory().getDecider().set("Profile");
        isSideOpen = false;
        }
    }

}

