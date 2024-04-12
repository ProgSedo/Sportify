package FXMLandControllers.RegisterPage;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class RegisterController {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField confirmPasswordTextField;

    @FXML
    private Text dateOfBirthText;

    @FXML
    private ComboBox<Integer> dayComboBox;

    @FXML
    private TextField emailTextField;

    @FXML
    private CheckBox footballCheckBox;

    @FXML
    private Text interestsText;

    @FXML
    private ComboBox<Integer> monthComboBox;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Text resgisterText;

    @FXML
    private Button signInButton;

    @FXML
    private Text sportifyText;

    @FXML
    private CheckBox tennisCheckBox;

    @FXML
    private TextField usernameTextField;

    @FXML
    private CheckBox volleyballCheckBox;

    @FXML
    private ComboBox<Integer> yearComboBox;

    @FXML
    void registerButtonClicked(ActionEvent event) throws IOException{
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        if (!Database.checkEmail(email)) {
            if (password.equals(confirmPasswordTextField.getText())) {
                User user = new User(email, password, yearComboBox.getValue(), isFootballSelected(), isVolleyballelected(), isTennisSelected());
                //LATER GOING TO BE USED ON APP
                Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    @FXML
    void signInClicked(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private boolean isTennisSelected() {
        if (tennisCheckBox.isSelected())
            return true;
            return false;
    }

    private boolean isFootballSelected() {
        if (footballCheckBox.isSelected())
            return true;
            return false;
    }

    private boolean isVolleyballelected() {
        if (volleyballCheckBox.isSelected())
            return true;
            return false;
    }

}
