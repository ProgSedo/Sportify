import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

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
                    break;
                case "HomePage+":
                    generalPane.setLeft(Model.getInstance().getViewFactory().getSideBarView());
                    generalPane.setCenter(Model.getInstance().getViewFactory().getHomePageView());
                    break;
                default:
                    generalPane.setCenter(Model.getInstance().getViewFactory().getHomePageView());
            }
        });
    }

}

