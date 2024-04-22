import java.io.IOException;

import Models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application{
    private static User user;

    @Override
    public void start(Stage stage)
    {
        Model.getInstance().getViewFactory().showSignInPage();
    }

    public static void main(String[] args){
        launch();
    }
    
}
