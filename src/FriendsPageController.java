

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FriendsPageController implements Initializable{

    private ArrayList<String> friends;
    private ArrayList<String> friendRequests;


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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        friends = Database.returnList(Model.getInstance().getEmail(), 1);
        friendRequests = Database.returnList(Model.getInstance().getEmail(), 0);
        displayRequests();

    }

    public void displayRequests() {
        if (friendRequests.size() > 0) {
            friendRequestTextField.setText(friendRequests.get(0));
        }
    }
    
    @FXML
    void acceptButtonClicked(ActionEvent event) 
    {
        if (friendRequests.size() > 0) {
            Database.acceptFriendRequest(friendRequests.get(0));
            friendRequests.remove(0);
        }
        friendRequestTextField.setText("");
        displayRequests();
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
        if (friendRequests.size() > 0) {
            Database.declineFriend(friendRequests.get(0));
            friendRequests.remove(0);
        }
        friendRequestTextField.setText("");
        displayRequests();
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


