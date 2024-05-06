import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FootballForumController {

    @FXML
    private TextArea displayMessagesTextField;

    @FXML
    private Button sendButton;

    @FXML
    private TextArea sendMessageTextField;

    @FXML
    private Button sideBarButton;

    @FXML
    void sideBarButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen()) 
        {
            Model.getInstance().getViewFactory().getDecider().set("FootballForumPage+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("FootballForumPage");
        }
    }

    @FXML
    void sendButtonClicked(ActionEvent event) 
    {

    }

}
