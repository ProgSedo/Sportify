import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class MainBorderPaneController implements Initializable{

    @FXML
    private BorderPane generalPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        Model.getInstance().getViewFactory().getDecider().addListener((observableValue, oldVal, newVal) -> {
            switch(newVal)
            {
                case "HomePage":
                    clearLeft();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getHomePageView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "HomePage+":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getHomePageView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "TennisForumPage":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getTennisForumView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "TennisForumPage+":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getTennisForumView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "FootballForumPage":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getFootballForumView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "FootballForumPage+":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getFootballForumView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "VoleyballForumPage":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getVoleyballForumView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "FootballEvents":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getFootballEventsView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "FootballEvents+":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getFootballEventsView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "VoleyballEvents":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getVoleyballEventsView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "VoleyballEvents+":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getVoleyballEventsView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "TennisEvents":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getTennisEventsView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "TennisEvents+":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getTennisEventsView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;

                case "Logout":
                    Model.getInstance().getViewFactory().showSignInPage();
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "Settings":
                    clearLeft();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getSettingsView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "Profile":
                    clearLeft();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getProfileView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "Profile+":
                    clearLeft();
                    clearCenter();
                    generalPane.setCenter(Model.getInstance().getViewFactory().getProfileView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                default:
                    generalPane.getChildren().add(Model.getInstance().getViewFactory().getHomePageView());
            }
        });
    }

    private void clearLeft()
    {
        if(generalPane.getLeft() != null)
        {
            generalPane.getChildren().remove(generalPane.getLeft());
        }
    }

    private void clearCenter()
    {
        if(generalPane.getCenter() != null)
        {
            generalPane.getChildren().remove(generalPane.getCenter());
        }
    }

}

