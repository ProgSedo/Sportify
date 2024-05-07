

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class VolleyballForumController implements Initializable{

    ArrayList<String> messages;

    @FXML
    private TextArea displayMessagesTextField;

    @FXML
    private Button sendButton;

    @FXML
    private TextArea sendMessageTextField;

    @FXML
    private Button sideBarButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        displayMessagesTextField.setWrapText(true);
        sendMessageTextField.setWrapText(true);
        messages = Database.getMessagesOfVolleyballForum();
        displayForumMessages();
    }

    @FXML
    void sideBarButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        
        if(Model.getInstance().getViewFactory().getIsSideBarOpen()) 
        {
            Model.getInstance().getViewFactory().getDecider().set("VolleyballForumPage+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("VolleyballForumPage");
        }    
    }

    @FXML
    void sendButtonClicked(ActionEvent event) 
    {
        Database.addNewMessageToVolleyballForum(sendMessageTextField.getText(), Model.getInstance().getEmail());
        displayForumMessages();
    }

    void displayForumMessages()
    {
        String forum = "";
        for(String i : messages)
        {
            forum += i;
            forum += "\n";
            forum += "-----------------------------------------------";
        }
        displayMessagesTextField.setText(forum);
    }

}
