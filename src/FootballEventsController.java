import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FootballEventsController {

    @FXML
    void FootballEventsSideBar(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        
        if(Model.getInstance().getViewFactory().getIsSideBarOpen()) 
        {
            Model.getInstance().getViewFactory().getDecider().set("FootballEvents+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("FootballEvents");
        }
    }
}