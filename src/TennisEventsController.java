import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TennisEventsController {

    @FXML
    private boolean isSideOpen;

    @FXML
    void TennisEventsSideBar(ActionEvent event) {

        if(isSideOpen == false) 
        {
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents+");
            isSideOpen = true;
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("TennisEvents");
            isSideOpen = false; 
        }
    }
}