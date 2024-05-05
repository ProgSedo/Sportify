

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FriendsPageController {

    @FXML
    private Button acceptButton;

    @FXML
    private Button sendRequestButton;

    @FXML
    private Button declineButton;

    @FXML
    private TextArea displayFriendsTextArea;

    @FXML
    private Label friendDisplayLabel;

    @FXML
    private TextField friendRequestTextField;

    @FXML
    private Button nextFriendButton;

    @FXML
    private Button previousFriendButton;

    @FXML
    private Button removeFriendButton;

    @FXML
    private Button searchFriendButton;

    @FXML
    private Button sideBarButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button visitFriendButton;

    @FXML
    private Label warningLabel;
    
    @FXML
    void acceptButtonClicked(ActionEvent event) 
    {

    }

    @FXML
    void sendRequestButtonClicked(ActionEvent event) 
    {
        String username = friendDisplayLabel.getText();
        String email = Database.emailByUsername(username);
        Database.sendFriendRequest(email);
    }

    @FXML
    void declineButtonClicked(ActionEvent event) 
    {

    }

    @FXML
    void searchFriendButtonClicked(ActionEvent event) 
    {
        String username = usernameTextField.getText();
        String email = Database.emailByUsername(username);
        if (Database.checkUsername(username) && !Model.getInstance().getEmail().equals(email)) {
            friendDisplayLabel.setText(username);
            warningLabel.setText("");

        }
        else {
            warningLabel.setText("Invalid username");
        }
    }

    @FXML
    void nextButtonClicked(ActionEvent event) 
    {

    }

    @FXML
    void previousButtonClicked(ActionEvent event) 
    {

    }

    @FXML
    void removeFriendButtonClicked(ActionEvent event) 
    {

    }

    @FXML
    void visitFriendButtonClicked(ActionEvent event) 
    {

    }

    @FXML
    void sideBarButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen())
        {
            Model.getInstance().getViewFactory().getDecider().set("FriendsPage+");
        }
        else
        {
            Model.getInstance().getViewFactory().getDecider().set("FriendsPage");
        }
    }

}


