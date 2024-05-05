

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FriendsPageController {

    @FXML
    private Button acceptButton;

    @FXML
    private Button addFriendButton;

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
    void acceptButtonClicked(ActionEvent event) 
    {

    }

    @FXML
    void addFriendButtonClicked(ActionEvent event) 
    {

    }

    @FXML
    void declineButtonClicked(ActionEvent event) 
    {

    }

    @FXML
    void searchFriendButtonClicked(ActionEvent event) 
    {

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


