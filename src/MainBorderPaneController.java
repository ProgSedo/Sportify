import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.transform.Source;

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
            clearLeft();
            clearCenter();
            switch(newVal)
            {
                case "HomePage":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getHomePageView());
                    break;
                case "HomePage+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getHomePageView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "TennisForumPage":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getTennisForumView());
                    break;
                case "TennisForumPage+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getTennisForumView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "FootballForumPage":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getFootballForumView());
                    break;
                case "FootballForumPage+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getFootballForumView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "VolleyballForumPage":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getVoleyballForumView());
                    break;
                case "VolleyballForumPage+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getVoleyballForumView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "FootballEvents":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getFootballEventsView());
                    break;
                case "FootballEvents+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getFootballEventsView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "VolleyballEvents":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getVoleyballEventsView());
                    break;
                case "VolleyballEvents+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getVoleyballEventsView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "TennisEvents":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getTennisEventsView());
                    break;
                case "TennisEvents+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getTennisEventsView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "Logout":
                    Model.getInstance().getViewFactory().showSignInPage();
                    break;
                case "Settings":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getSettingsView());
                    break;
                case "Settings+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getSettingsView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "Profile":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getProfileView());
                    break;
                case "Profile+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getProfileView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "FriendsPage":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getFriendsPageView());
                    break;
                case "FriendsPage+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getFriendsPageView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "CreateEvents":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getCreateEventView());
                    break;
                case "CreateEvents+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getCreateEventView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "MyFootballEvents+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getMyFootballEvents());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "MyFootballEvents":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getMyFootballEvents());
                    break;
                case "MyTennisEvents+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getMyTennisEvents());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "MyTennisEvents":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getMyTennisEvents());
                    break;
                case "MyVolleyballEvents+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getMyVolleyballEvents());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    break;
                case "MyVolleyballEvents":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getMyVolleyballEvents());
                    break;
            }
            Model.getInstance().getViewFactory().getStage().sizeToScene();
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

