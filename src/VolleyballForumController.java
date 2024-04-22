

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class VolleyballForumController {

    @FXML
    private Button backButton;

    @FXML
    private Button menuBarButton;

    @FXML
    private TextArea voleyballForumTextArea;

    @FXML
    private Label voleyballTitleLabel;

    @FXML
    void menuBarButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        
        if(Model.getInstance().getViewFactory().getIsSideBarOpen()) 
        {
            Model.getInstance().getViewFactory().getDecider().set("VolleyballForum+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("VolleyballForum");
        }    
    }

}
