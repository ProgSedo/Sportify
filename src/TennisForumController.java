import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class TennisForumController {

    @FXML
    private TextArea displayMessagesTextField;
    
    @FXML
    private Button sendButton;

    @FXML
    private TextArea sendMessageTextField;

    @FXML
    private Button sideBarButton;

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
    void sendButtonClicked(ActionEvent event) {

    }

}
