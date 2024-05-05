

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController implements Initializable{
    Stage stage;
    Scene scene;
    
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
    private PasswordField passwordField;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        int currentYear = java.time.Year.now().getValue();

        for (int year = 1900; year <= currentYear; year++) {
            yearComboBox.getItems().add(year);
        }

        yearComboBox.getSelectionModel().selectFirst();

        for (int day = 1; day <= 31; day++) {
            dayComboBox.getItems().add(day);
        }

        dayComboBox.getSelectionModel().selectFirst();

        for (int month = 1; month <= 12; month++) {
            monthComboBox.getItems().add(month);
        }

        monthComboBox.getSelectionModel().selectFirst();
    }
    
    @FXML
    void registerButtonClicked(ActionEvent event) throws IOException{
        String email = emailTextField.getText();
        String password = passwordField.getText();
        if (!Database.checkEmail(email)) {
            System.out.println("a");
            if (password.equals(confirmPasswordTextField.getText())) {
                System.out.println("b");
                User user = new User(email, password, usernameTextField.getText(), yearComboBox.getValue(), isFootballSelected(), isVolleyballelected(), isTennisSelected());
                Database.createFriendsTable(email + "_friends");
                System.out.println("c");
                //LATER GOING TO BE USED ON APP
                Model.getInstance().getViewFactory().showSignInPage();
    
            }
        }
    }

    @FXML
    void signInClicked(ActionEvent event){
        onSignIn();
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

    private void onSignIn()
    {
        Stage stage =(Stage) signInButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showSignInPage();
    }
}
