

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateEventPageController implements Initializable{

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
    private ComboBox<Integer> footballSizeComboBox;

    @FXML
    private RadioButton volleyballRadioButton;

    @FXML
    private ComboBox<Integer> volleyballSizeComboBox;

    @FXML
    private RadioButton tennisRadioButton;

    @FXML
    private ComboBox<Integer> tennisSizeComboBox;

    @FXML
    private RadioButton tournamentRadioButton;

    @FXML
    private ComboBox<Integer> roundNumberComboBox;

    @FXML
    private RadioButton matchRadioButton;

    @FXML
    private Button createEventButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        
    }

    @FXML
    void createEventButtonClicked(ActionEvent event) {

    }

    @FXML
    void sideBarButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen())
        {
            Model.getInstance().getViewFactory().getDecider().set("CreateEvents+");
        }
        else
        {
            Model.getInstance().getViewFactory().getDecider().set("CreateEvents");
        }
    }

}



