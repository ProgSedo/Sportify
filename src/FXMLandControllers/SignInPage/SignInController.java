package FXMLandControllers.SignInPage;

import java.io.IOException;

import Models.Database;
import Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SignInController {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField emailTextField;

    @FXML
    private Text getStartedText;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Button signInButton;

    @FXML
    private Text sportifyText;

    @FXML
    private Text welcomeText;

    @FXML
    void registerButtonClicked(ActionEvent event) {
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        if (!Database.checkEmail(email)) {
            if (password.equals())
        }
    }

    @FXML
    void signInButtonClicked(ActionEvent event) throws IOException{
        if (Database.checkEmail(emailTextField.getText())) {
            if (Database.checkPassword(emailTextField.getText(), passwordTextField.getText())) {
                User user = Database.getUser(emailTextField.getText());
                Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                 stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                 scene = new Scene(root);
                 stage.setScene(scene);
                 stage.show();
            }
        }
    }

}
