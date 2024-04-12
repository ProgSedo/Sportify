package FXMLandControllers.SignInPage;

import Models.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SignInController {

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

    }

    @FXML
    void signInButtonClicked(ActionEvent event) {
        if (Database.checkEmail(emailTextField.getText())) {
            if (Database.checkPassword(emailTextField.getText(), passwordTextField.getText())) {
                //TBC by ata
            }
        }
    }

}
