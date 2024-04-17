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
                    generalPane.setCenter(Model.getInstance().getViewFactory().getHomePageView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getEmptyPane());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "HomePage+":
                    generalPane.setCenter(Model.getInstance().getViewFactory().getHomePageView());
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                    break;
                case "Logout":
                    Model.getInstance().getViewFactory().showSignInPage();
                    Model.getInstance().getViewFactory().getStage().sizeToScene();
                default:
                    generalPane.getChildren().add(Model.getInstance().getViewFactory().getHomePageView());
            }
        });
    }

}

