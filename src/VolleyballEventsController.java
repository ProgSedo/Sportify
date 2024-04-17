import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class VolleyballEventsController {

    @FXML
    private boolean isSideOpen;

    @FXML
    void VolleyballEventsSideBar(ActionEvent event) {
        
        if(isSideOpen == false) 
        {
            Model.getInstance().getViewFactory().getDecider().set("VolleyballEvents+");
            isSideOpen = true;
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("VolleyballEvents");
            isSideOpen = false; 
        }
    }
}