import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class VolleyballEventsController {

    @FXML
    private boolean isSideOpen;

    public VolleyballEventsController()
    {
        isSideOpen = false;
    }

    @FXML
    void VolleyballEventsSideBar(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        
        if(Model.getInstance().getViewFactory().getIsSideBarOpen()) 
        {
            Model.getInstance().getViewFactory().getDecider().set("VolleyballEvents+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("VolleyballEvents");
        }
    }
}