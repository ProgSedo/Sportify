import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class VisitorPageController implements Initializable{

    @FXML
    private TextArea aboutMeTextArea;

    @FXML
    private TextField ageTextField;

    @FXML
    private Button backButton;

    @FXML
    private TextArea commentsTextArea;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField interestsTextField;

    @FXML
    private ImageView profilePhoto;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button inviteToYourTeamButton;

    public void initialize(URL location, ResourceBundle resources) {
        String email = Model.getInstance().getFriendEmail();
        emailTextField.setText(email);
        ageTextField.setText("" + Database.getAge(email));
        usernameTextField.setText(Database.getUsername(email));
        interestsTextField.setText(Database.getInterests(email));


        aboutMeTextArea.setText(Database.getAboutMe(email));
        aboutMeTextArea.setWrapText(true);
        
        emailTextField.setEditable(false);
        interestsTextField.setEditable(false);
        usernameTextField.setEditable(false);
        ageTextField.setEditable(false);
        aboutMeTextArea.setEditable(false);
        commentsTextArea.setEditable(false);

    }

    @FXML
    void backButtonClicked(ActionEvent event) 
    {
        Model.getInstance().setFriendEmail(null);
        Model.getInstance().getViewFactory().getDecider().set("FriendsPage");
    }

}

