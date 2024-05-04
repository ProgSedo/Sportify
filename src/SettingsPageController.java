

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SettingsPageController implements Initializable{

    @FXML
    private Button aboutMeSaveButton;

    @FXML
    private TextArea aboutMeTextArea;

    @FXML
    private TextField ageTextField;

    @FXML
    private Button changePP;

    @FXML
    private Button changePasswordButton;

    @FXML
    private TextField confirmNewPasswordTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button informationSaveButton;

    @FXML
    private TextField interestsTextField;

    @FXML
    private TextField newPasswordTextField;

    @FXML
    private ImageView profilePhoto;

    @FXML
    private Button sideBarButton;

    @FXML
    private TextField usernameTextField;

    private boolean sideBarOpen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailTextField.setText("email cannot be changed");
        emailTextField.setEditable(false);
    }

    public SettingsPageController()
    {
        sideBarOpen = false;
    }

    @FXML
    void aboutMeSaveButtonClicked(ActionEvent event) 
    {
        Database.updateAboutMe(aboutMeTextArea.getText());
    }

    @FXML
    void changePPClicked(ActionEvent event) 
    {

    }

    @FXML
    void changePasswordButtonClicked(ActionEvent event) 
    {
        if(newPasswordTextField.getText().equals(confirmNewPasswordTextField.getText()))
        {
            Database.updatePassword(newPasswordTextField.getText());
        }
        else
        {
            
        }
    }

    @FXML
    void saveButtonClicked(ActionEvent event) 
    {

    }

    @FXML
    void sideBarButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen())
        {
            Model.getInstance().getViewFactory().getDecider().set("Settings+");
        }
        else
        {
            Model.getInstance().getViewFactory().getDecider().set("Settings");
        }
    }

}


