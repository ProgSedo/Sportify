

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FriendsPageController {

    @FXML
    private Button acceptButton;

    @FXML
    private Button addFriendButton;

    @FXML
    private Text addFriendsText;

    @FXML
    private Button declineButton;

    @FXML
    private Label friendDisplayLabel;

    @FXML
    private TextField friendRequestTextField;

    @FXML
    private ScrollPane friendsScrollPane;

    @FXML
    private Label friendsText;

    @FXML
    private Label friendsText1;

    @FXML
    private TextArea friendsTextArea;

    @FXML
    private Button searchFriendButton;

    @FXML
    private Button sideBarButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    void acceptButtonClicked(ActionEvent event) {

    }

    @FXML
    void addFriendButtonClicked(ActionEvent event) {

    }

    @FXML
    void declineButtonClicked(ActionEvent event) {

    }

    @FXML
    void searchFriendButtonClicked(ActionEvent event) {

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


