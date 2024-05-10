import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class MyFootballEventsController 
{
    @FXML
    private Label matchName;
    
    @FXML
    private Label tournamentName;

    @FXML
    private TextArea footballMatchesInfoArea;

    @FXML
    private TextArea footballTournamentsInfoArea;

    @FXML
    private Button nextMatchButton;

    @FXML
    private Button nextTournamentButton;

    @FXML
    private Button previousMatchButton;

    @FXML
    private Button previousTournamentButton;

    @FXML
    private Button sideBarButton;

    @FXML
    private Button unjoinMatchButton;

    @FXML
    private Button unjoinTournamentButton;

    @FXML
    void nextMatchButtonClicked(ActionEvent event) {

    }

    @FXML
    void nextTournamentButtonClicked(ActionEvent event) {

    }

    @FXML
    void previousMatchButtonClicked(ActionEvent event) {

    }

    @FXML
    void previousTournamentButtonClicked(ActionEvent event) {

    }

    @FXML
    void sideBarButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen())
        {
            Model.getInstance().getViewFactory().getDecider().set("MyFootballEvents+");
        }
        else
        {
            Model.getInstance().getViewFactory().getDecider().set("MyFootballEvents");
        }
    }

    @FXML
    void unjoinMatchButtonClicked(ActionEvent event) 
    {
        
    }

    @FXML
    void unjoinTournamentButtonClicked(ActionEvent event) 
    {
        
    }

}

