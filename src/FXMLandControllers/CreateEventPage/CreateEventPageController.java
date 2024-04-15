package FXMLandControllers.CreateEventPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateEventPageController {

    @FXML
    private Button sideBarButton;
    
    @FXML
    private TextField dateTextField;

    @FXML
    private TextField placeTextField;

    @FXML
    private TextArea detailsTextArea;

    @FXML
    private RadioButton footballRadioButton;

    @FXML
    private ComboBox<?> footballSizeComboBox;

    @FXML
    private RadioButton volleyballRadioButton;

    @FXML
    private ComboBox<?> volleyballSizeComboBox;

    @FXML
    private RadioButton tennisRadioButton;

    @FXML
    private ComboBox<?> tennisSizeComboBox;

    @FXML
    private RadioButton tournamentRadioButton;

    @FXML
    private ComboBox<?> roundNumberComboBox;

    @FXML
    private RadioButton matchRadioButton;

    @FXML
    private Button createEventButton;

    @FXML
    void createEventButtonClicked(ActionEvent event) {

    }

    @FXML
    void sideBarButtonClicked(ActionEvent event) {

    }

}



