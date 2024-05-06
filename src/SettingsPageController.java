


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SettingsPageController implements Initializable{

    @FXML
    private Label passwordWarningLabel;

    @FXML
    private Button aboutMeSaveButton;

    @FXML
    private TextArea aboutMeTextArea;

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
    private Label infoWarningLabel;

    @FXML
    private CheckBox tennisCheckBox;

    @FXML
    private CheckBox volleyballCheckBox;

    @FXML
    private CheckBox footballCheckBox;

    @FXML
    private TextField newPasswordTextField;

    @FXML
    private ImageView profilePhoto;

    @FXML
    private Button sideBarButton;

    @FXML
    private TextField usernameTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        String email = Model.getInstance().getEmail();
        emailTextField.setText("email cannot be changed!");
        emailTextField.setEditable(false);

        if (Database.isTennisSelected(email))
            tennisCheckBox.setSelected(true);
        if (Database.isFootballSelected(email))
            footballCheckBox.setSelected(true);
        if (Database.isVolleyballSelected(email))
            volleyballCheckBox.setSelected(true);
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
        else if(newPasswordTextField.getText().length() < 5 || newPasswordTextField.getText().length() > 13)
        {
            passwordWarningLabel.setText("Password should contain 5-13 characters!");
        }
        else
        {
            passwordWarningLabel.setText("Passwords does not match!");
        }
    }

    @FXML
    void saveButtonClicked(ActionEvent event) 
    {
        if(!usernameTextField.getText().isEmpty() && !Database.checkUsername(usernameTextField.getText()))
        {
            Database.updateUsernameInfo(usernameTextField.getText());
        }
        else
        {
            infoWarningLabel.setText("Invalid Entry");
        }
        
        Database.updateTennisInfo(tennisCheckBox.isSelected());
        Database.updateFootballInfo(footballCheckBox.isSelected());
        Database.updateVolleyballInfo(volleyballCheckBox.isSelected());
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


