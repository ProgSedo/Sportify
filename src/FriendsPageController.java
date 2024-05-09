

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FriendsPageController implements Initializable{

    private int friendIndex;

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
    public void initialize(URL location, ResourceBundle resources) 
    {
        displayFriendsTextArea.setWrapText(true);
        displayRequests();
        displayFriends(0);
    }

    public void displayRequests() 
    {
        ArrayList<String> friendRequests = Database.returnList(Model.getInstance().getEmail(), 0);
        if (friendRequests.size() > 0) 
        {
            friendRequestTextField.setText(Database.usernameByEmail(friendRequests.get(0)));
        }
        if(friendRequests.size() == 0)
        {
            friendRequestTextField.setText("");
        }
    }

    public void displayFriends(int index)
    {
        ArrayList<String> friends = Database.returnList(Model.getInstance().getEmail(), 1);
        friendIndexManager();
        if(friends.size() > 0)
        {
            String username = Database.usernameByEmail(friends.get(index));
            displayFriendsTextArea.setText(username + "\nInterests: " + Database.getInterests(friends.get(index)));
        }
        if(friends.size() == 0)
        {
            displayFriendsTextArea.setText("");
        }
    }
    
    @FXML
    void acceptButtonClicked(ActionEvent event) 
    {
        ArrayList<String> friendRequests = Database.returnList(Model.getInstance().getEmail(), 0);
        if (friendRequests.size() > 0) 
        {
            Database.acceptFriendRequest(friendRequests.get(0));
        }
        friendRequestTextField.setText("");
        displayRequests();
        displayFriends(friendIndex);
    }

    @FXML
    void sendRequestButtonClicked(ActionEvent event) 
    {
        ArrayList<String> friends = Database.returnList(Model.getInstance().getEmail(), 1);
        ArrayList<String> friendRequests = Database.returnList(Model.getInstance().getEmail(), 0);
        String username = friendDisplayLabel.getText();
        String email = Database.emailByUsername(username);
        if(! (friends.contains(email) || friendRequests.contains(email)))
        {
            System.out.println("-------------------------------------");
            Database.sendFriendRequest(email);
        }
    }

    @FXML
    void declineButtonClicked(ActionEvent event) 
    {
        ArrayList<String> friendRequests = Database.returnList(Model.getInstance().getEmail(), 0);
        if (friendRequests.size() > 0) 
        {
            Database.declineFriend(friendRequests.get(0));
        }
        friendRequestTextField.setText("");
        displayRequests();
    }

    @FXML
    void searchFriendButtonClicked(ActionEvent event) 
    {
        ArrayList<String> friends = Database.returnList(Model.getInstance().getEmail(), 1);
        ArrayList<String> friendRequests = Database.returnList(Model.getInstance().getEmail(), 0);
        String username = usernameTextField.getText();
        String email = Database.emailByUsername(username);
        if(Model.getInstance().getEmail().equals(email))
        {
            warningLabel.setText("You cannot search yourself");
        }
        else if(friends.contains(email))
        {
            warningLabel.setText("You are already friend");
        }
        else if(friendRequests.contains(email))
        {
            warningLabel.setText("You have already sent friend request");
        }
        else if (!Database.checkUsername(username)) 
        {
            warningLabel.setText("No such user");
        }
        else 
        {
            friendDisplayLabel.setText(username);
            warningLabel.setText("");
        }
    }

    @FXML
    void nextButtonClicked(ActionEvent event) 
    {
        ArrayList<String> friends = Database.returnList(Model.getInstance().getEmail(), 1);
        if(friendIndex < friends.size() - 1)
        {
            friendIndex++;
            displayFriends(friendIndex);
        }
    }

    @FXML
    void previousButtonClicked(ActionEvent event) 
    {
        if(friendIndex > 0)
        {
            friendIndex--;
            displayFriends(friendIndex);
        }
        
    }

    @FXML
    void removeFriendButtonClicked(ActionEvent event) 
    {
        ArrayList<String> friends = Database.returnList(Model.getInstance().getEmail(), 1);
        if(friends.size()>0)
        {
            Database.removeFriend(friends.get(friendIndex));
            friendIndexManager();
            displayFriends(friendIndex);
        }
    }

    @FXML
    void visitFriendButtonClicked(ActionEvent event) 
    {
        ArrayList<String> friends = Database.returnList(Model.getInstance().getEmail(), 1);
        if(friends.size()>0)
        {
            Model.getInstance().setFriendEmail(friends.get(friendIndex));
            Model.getInstance().getViewFactory().getDecider().set("VisitFriend");
        }
        else
        {
            System.out.println("Eziksin.");
        }
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

    public void friendIndexManager()
    {
        ArrayList<String> friends = Database.returnList(Model.getInstance().getEmail(), 1);
        if(friendIndex > friends.size())
        {
            friendIndex = Math.max(friends.size()-1,0);
        }
    }

}


