import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FootballEventsController {

    @FXML
    private boolean isSideOpen;

    @FXML
    void FootballEventsSideBar(ActionEvent event) {

        if(isSideOpen == false) 
        {
            Model.getInstance().getViewFactory().getDecider().set("FootballEvents+");
            isSideOpen = true;
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("FootballEvents");
            isSideOpen = false; 
        }
    }
}