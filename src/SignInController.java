

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
        /* 
        if (Database.checkEmail(emailTextField.getText())) {
            if (Database.checkPassword(emailTextField.getText(), passwordField.getText())) {
                User user = Database.getUser(emailTextField.getText());
                //LATER GOING TO BE USED ON APP
                Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                 stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                 scene = new Scene(root);
                 stage.setScene(scene);
                 stage.centerOnScreen();
                 stage.show();
            }
        }
        */
        onSignIn();
    }

    private void onRegister()
    {
        Model.getInstance().getViewFactory().showRegisterPage();
    }

    private void onSignIn()
    {
        Stage stage =(Stage) signInButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showGeneralPane();
        Model.getInstance().getViewFactory().getDecider().set("HomePage");
    }

    

}
