import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class TennisForumController implements Initializable{

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
        displayMessagesTextField.setEditable(false);
        displayMessagesTextField.setWrapText(true);
        sendMessageTextField.setWrapText(true);
        messages = Database.getMessagesOfTennisForum();
        displayForumMessages();

    }

    @FXML
    void menuBarButtonClicked(ActionEvent event) 
    {
        System.out.println("b");
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen()) 
        {
            Model.getInstance().getViewFactory().getDecider().set("TennisForumPage+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("TennisForumPage");
        }
    }

    @FXML
    void sendButtonClicked(ActionEvent event) 
    {
        Database.addNewMessageToTennisForum(sendMessageTextField.getText(), Model.getInstance().getEmail());
        displayForumMessages();
        sendMessageTextField.setText("");
    }

    void displayForumMessages()
    {
        messages = Database.getMessagesOfTennisForum();
        String forum = "";
        for(String i : messages)
        {

            String email = Database.getEmailFromForums(0, i);
            forum += Database.usernameByEmail(email) + ": ";
            forum += i;

            forum += "\n";
        }
        displayMessagesTextField.setText(forum);
    }

    @FXML
    void sideBarButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen())
        {
            Model.getInstance().getViewFactory().getDecider().set("TennisForumPage+");
        }
        else
        {
            Model.getInstance().getViewFactory().getDecider().set("TennisForumPage");
        }
    }

    

}
