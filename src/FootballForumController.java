

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FootballForumController {

    @FXML
    private Button backButton;

    @FXML
    private TextArea footBallForumTextArea;

    @FXML
    private Label footballTitleLabel;

    @FXML
    private Button menuBarButton;

    @FXML
    void menuBarButtonClicked(ActionEvent event) 
    {   System.out.println("a");
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

}
