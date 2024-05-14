import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.util.*;
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
    private Button joinTeamButton;

    @FXML
    private PasswordField passwordName;

    @FXML
    private ImageView profilePhoto;

    @FXML
    private TextField teamName;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label warningLabel;

    @FXML
    private Button commentButton;

    @FXML
    private TextField commentTextField;

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
        displayComments();
    }

    @FXML
    void backButtonClicked(ActionEvent event) 
    {
        Model.getInstance().setFriendEmail(null);
        Model.getInstance().getViewFactory().getDecider().set("FriendsPage");
    }

    @FXML
    void joinTeamButtonClicked(ActionEvent event) {
        ArrayList<String> teamNames = Database.getAllTeamNames();
        if (teamName.getText().isEmpty() || passwordName.getText().isEmpty()) {
            warningLabel.setText("missing fields");
            return;
        }

        if (teamNames.contains(teamName.getText())) {
            if (passwordName.getText().equals(Database.getTeamPasswordByTeamName(teamName.getText()))) {
                Database.updateTeamName(teamName.getText());
                Database.updateTeamPassword(passwordName.getText());
                passwordName.setText("");
                teamName.setText("");
                
            } else {
                warningLabel.setText("Wrong password");
            }
        } else {
            warningLabel.setText("No such team");
        }
    }

    @FXML
    void commentButtonClicked(ActionEvent event) {
        if(!commentTextField.getText().isEmpty())
        {
            Database.addComment(Model.getInstance().getFriendEmail(), commentTextField.getText());
            commentTextField.setText("");
        }
        displayComments();
    }

    void displayComments()
    {
        ArrayList<String> comments = Database.getComments(Model.getInstance().getFriendEmail());
        int length = comments.size();

        String commentArea = "";
        for(int i = length - 1; i > Math.max(length - 11, -1); i--)
        {
            commentArea += Database.getUsernameByComment(comments.get(i), Model.getInstance().getFriendEmail());
            commentArea += ": ";
            commentArea += comments.get(i);
            commentArea += "\n";
        }
        commentsTextArea.setText(commentArea);
    }

}

