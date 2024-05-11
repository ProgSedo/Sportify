import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CreateEventPageController implements Initializable
{
    DateTimeFormatter dateFormat;

    @FXML
    private ComboBox<String> hourComboBox;

    @FXML
    private ComboBox<String> minuteComboBox;

    @FXML
    private ComboBox<String> dayComboBox;
    
    @FXML
    private ComboBox<String> monthComboBox;

    @FXML
    private ComboBox<String> yearComboBox;

    @FXML
    private Label warningLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button sideBarButton;

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

        for (int size = 5; size <= 11; size++) 
        {
            footballSizeComboBox.getItems().add(size);
        }
        footballSizeComboBox.getSelectionModel().selectFirst();

        for (int size = 3; size <= 6; size++) 
        {
            volleyballSizeComboBox.getItems().add(size);
        }
        volleyballSizeComboBox.getSelectionModel().selectFirst();

        for (int size = 1; size <= 2; size++) 
        {
            tennisSizeComboBox.getItems().add(size);
        }
        tennisSizeComboBox.getSelectionModel().selectFirst();

        for (int round = 1; round <= 3; round++) 
        {
            roundNumberComboBox.getItems().add(round);
        }
        roundNumberComboBox.getSelectionModel().selectFirst();

        for (int day = 1; day <= 30; day++) 
        {
            dayComboBox.getItems().add(Integer.toString(day));
        }
        dayComboBox.getSelectionModel().selectFirst();

        for (int month = 1; month <= 12; month++) 
        {
            monthComboBox.getItems().add(Integer.toString(month));
        }
        monthComboBox.getSelectionModel().selectFirst();

        for (int year = 2024; year <= 2025; year++) 
        {
            yearComboBox.getItems().add(Integer.toString(year));
        }
        yearComboBox.getSelectionModel().selectFirst();

        for (int hour = 0; hour <= 23; hour++) 
        {
            if(hour < 10)
            {
                hourComboBox.getItems().add("0" + Integer.toString(hour));
            }
            else
            {
                hourComboBox.getItems().add(Integer.toString(hour));
            }
        }
        hourComboBox.getSelectionModel().selectFirst();

        for (int minute = 0; minute <= 59; minute++) 
        {
            if(minute < 10)
            {
                minuteComboBox.getItems().add("0" + Integer.toString(minute));
            }
            else
            {
                minuteComboBox.getItems().add(Integer.toString(minute));
            }
        }
        minuteComboBox.getSelectionModel().selectFirst();

        dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }

    @FXML
    void createEventButtonClicked(ActionEvent event) throws ParseException 
    {
        String name = "";
        String datetime = "";
        String place = "";
        String details = "";
        int teamSize = -1;
        Timestamp time;
        int parameter = -1;
        int roundNumber = -1;

        if(nameTextField.getText().length() < 10 || nameTextField.getText().length() > 25)
        {
            warningLabel.setText("Name should contain 10-25 characters");
            return;
        }
        else
        {
            name = nameTextField.getText();
        }

        String day = dayComboBox.getSelectionModel().getSelectedItem();
        String month = monthComboBox.getSelectionModel().getSelectedItem();
        String year = yearComboBox.getSelectionModel().getSelectedItem();
        String hour = hourComboBox.getSelectionModel().getSelectedItem();
        String minute = minuteComboBox.getSelectionModel().getSelectedItem();

        datetime += day;
        datetime += "/";
        datetime += month;
        datetime += "/";
        datetime += year;
        datetime += " ";
        datetime += hour;
        datetime += ":";
        datetime += minute;

        LocalDateTime dateTime = LocalDateTime.parse(datetime, dateFormat);
        LocalDateTime now = LocalDateTime.now();
        now = now.plusDays(1);

        if(!dateTime.isAfter(now))
        {
            return;
        }
        
        place = placeTextField.getText();
        if(place.length() < 5)
        {
            return;
        }

        details = detailsTextArea.getText();
        if(details.length() < 15)
        {
            return;
        }

        roundNumber = roundNumberComboBox.getValue();

        if(footballRadioButton.isSelected())
        {
            teamSize = footballSizeComboBox.getValue();
            if(tournamentRadioButton.isSelected())
            {
                parameter = 1;
            }
            else
            {
                parameter = 0;
            }
        }
        if(volleyballRadioButton.isSelected())
        {
            teamSize = volleyballSizeComboBox.getValue();
            if(tournamentRadioButton.isSelected())
            {
                parameter = 3;
            }
            else
            {
                parameter = 2;
            }
        }
        if(tennisRadioButton.isSelected())
        {
            teamSize = tennisSizeComboBox.getValue();
            if(tournamentRadioButton.isSelected())
            {
                parameter = 5;
            }
            else
            {
                parameter = 4;
            }
        }

        if(tournamentRadioButton.isSelected())
        {
            roundNumber = roundNumberComboBox.getValue();
        }
        else
        {
            Database.insertNewEvent(parameter, name, dateTime, teamSize, place, details, false);
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



