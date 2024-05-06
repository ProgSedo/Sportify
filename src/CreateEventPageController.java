

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CreateEventPageController implements Initializable{

    @FXML
    private Button sideBarButton;

    @FXML
    private ComboBox<Integer> dateDayComboBox;
    
    @FXML
    private ComboBox<Integer> dateMonthComboBox;

    @FXML
    private ComboBox<Integer> dateYearComboBox;

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

        ToggleGroup sportType = new ToggleGroup();
        footballRadioButton.setToggleGroup(sportType);
        volleyballRadioButton.setToggleGroup(sportType);
        tennisRadioButton.setToggleGroup(sportType);
        tennisRadioButton.setSelected(true);

        ToggleGroup matchType = new ToggleGroup();
        tournamentRadioButton.setToggleGroup(matchType);
        matchRadioButton.setToggleGroup(matchType);
        matchRadioButton.setSelected(true);

        for (int size = 1; size <= 5; size++) {
            footballSizeComboBox.getItems().add(size);
        }
        footballSizeComboBox.getSelectionModel().selectFirst();

        for (int size = 1; size <= 4; size++) {
            volleyballSizeComboBox.getItems().add(size);
        }
        volleyballSizeComboBox.getSelectionModel().selectFirst();
        for (int size = 1; size <= 2; size++) {
            tennisSizeComboBox.getItems().add(size);
        }
        tennisSizeComboBox.getSelectionModel().selectFirst();

        for (int round = 1; round <= 3; round++) {
            roundNumberComboBox.getItems().add(round);
        }
        roundNumberComboBox.getSelectionModel().selectFirst();

        for (int day = 1; day <= 30; day++) {
            dateDayComboBox.getItems().add(day);
        }
        dateDayComboBox.getSelectionModel().selectFirst();

        for (int month = 1; month <= 12; month++) {
            dateMonthComboBox.getItems().add(month);
        }
        dateMonthComboBox.getSelectionModel().selectFirst();

        for (int year = 2024; year <= 2025; year++) {
            dateYearComboBox.getItems().add(year);
        }
        dateYearComboBox.getSelectionModel().selectFirst();


        
    }

    @FXML
    void createEventButtonClicked(ActionEvent event) {

        Calendar myCalendar = new GregorianCalendar(dateYearComboBox.getValue(), dateMonthComboBox.getValue(), dateDayComboBox.getValue());
        Date myDate = myCalendar.getTime();
        
        SportType selectedType = null;
        int teamSize = 0;
        if(footballRadioButton.isSelected()){
            selectedType = SportType.football;
            teamSize = footballSizeComboBox.getValue();
        }
        else if(volleyballRadioButton.isSelected()){
            selectedType = SportType.volleyball;
            teamSize = volleyballSizeComboBox.getValue();
        }
        else if(tennisRadioButton.isSelected()){
            selectedType = SportType.tennis;
            teamSize = tennisSizeComboBox.getValue();
        }

        if(tournamentRadioButton.isSelected()){
            Tournament myTournament = new Tournament(placeTextField.getText(), myDate, selectedType, roundNumberComboBox.getValue()) {
            
            };
            Database.insertNewEvent(myTournament);
        }
        else{
            SingleEvent mySingleEvent = new SingleEvent(placeTextField.getText(), myDate, selectedType, teamSize);
            Database.insertNewEvent(mySingleEvent);
        }    
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



