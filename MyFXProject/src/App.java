import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class App extends Application{

    @FXML
    private Button logInButton;


    public static void main(String[] args){
        launch(args);
    }
    

    @Override
    public void start(Stage stage) throws IOException{
         
        FXMLLoader fxml = new FXMLLoader(App.class.getResource("deneme.fxml"));
        Scene scene1 = new Scene(fxml.load(),1080,720);
        stage.setScene(scene1);
        stage.show();
    }
}
