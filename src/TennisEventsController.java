import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TennisEventsController {

    @FXML
    private boolean isSideOpen;

    @FXML
    void TennisEventsSideBar(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen()) 
        {
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents");
        }
    }
}