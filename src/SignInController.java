

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.Database;
import Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SignInController{
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField emailTextField;

    @FXML
    private Text getStartedText;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button signInButton;

    @FXML
    private Text sportifyText;

    @FXML
    private Text welcomeText;

    @FXML
    void registerButtonClicked(ActionEvent event)
    {
        onRegister();
    }

    @FXML
    void signInButtonClicked(ActionEvent event){
        System.out.println(Database.checkEmail(emailTextField.getText()));
        if (Database.checkEmail(emailTextField.getText())) {
            System.out.println("111");
            if (Database.checkPassword(emailTextField.getText(), passwordField.getText())) {
                System.out.println("4563");
                //User user = Database.getUser(emailTextField.getText());
                //LATER GOING TO BE USED ON APP
                //Model.getInstance().getViewFactory().getHomePageView();
                onSignIn();
                System.out.println("222");
            }
        }

        
    }

    private void onRegister()
    {
        Model.getInstance().getViewFactory().showRegisterPage();
    }

    private void onSignIn()
    {
        Stage stage = (Stage) signInButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showGeneralPane();
        Model.getInstance().getViewFactory().getDecider().set("HomePage");
    }

    

}
