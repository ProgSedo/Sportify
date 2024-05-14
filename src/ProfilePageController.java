

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ProfilePageController implements Initializable{

    @FXML
    private TextArea aboutMeTextArea;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextArea commentsTextArea;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField interestsTextField;

    @FXML
    private ImageView profilePhoto;

    @FXML
    private Button sideBarButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button footballEventsButton;

    @FXML
    private Button tennisEventsButton;

    @FXML
    private Button volleyballEventsButton;

    @FXML
    private TextField teamTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String email = Model.getInstance().getEmail();
        emailTextField.setText(email);
        ageTextField.setText("" + Database.getAge(email));
        usernameTextField.setText(Database.getUsername(email));
        interestsTextField.setText(Database.getInterests(email));

        
        aboutMeTextArea.setText(Database.getAboutMe(email));
        aboutMeTextArea.setWrapText(true);
        
        displayComments();
        commentsTextArea.setWrapText(true);
        
        
        emailTextField.setEditable(false);
        interestsTextField.setEditable(false);
        usernameTextField.setEditable(false);
        ageTextField.setEditable(false);
        aboutMeTextArea.setEditable(false);
        commentsTextArea.setEditable(false);
        displayTeam();
    }

   
    @FXML
    void sideBarButtonClicked(ActionEvent event) {
        Model.getInstance().getViewFactory().closeAndOpenSideBar();
        if(Model.getInstance().getViewFactory().getIsSideBarOpen()) 
        {
            Model.getInstance().getViewFactory().getDecider().set("Profile+");
        }
        else 
        {
            Model.getInstance().getViewFactory().getDecider().set("Profile");
        }
    }

    @FXML
    void footballEventsButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeSideBar();
        Model.getInstance().getViewFactory().getDecider().set("MyFootballEvents");
    }

    @FXML
    void tennisEventsButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeSideBar();
        Model.getInstance().getViewFactory().getDecider().set("MyTennisEvents");
    }

    @FXML
    void volleyballEventsButtonClicked(ActionEvent event) 
    {
        Model.getInstance().getViewFactory().closeSideBar();
        Model.getInstance().getViewFactory().getDecider().set("MyVolleyballEvents");
    }

    void displayComments()
    {
        ArrayList<String> comments = Database.getComments(Model.getInstance().getEmail());
        int length = comments.size();

        String commentArea = "";
        for(int i = length - 1; i > Math.max(length - 11, -1); i--)
        {
            commentArea += Database.getUsernameByComment(comments.get(i), Model.getInstance().getEmail());
            commentArea += ": ";
            commentArea += comments.get(i);
            commentArea += "\n";
        }
        commentsTextArea.setText(commentArea);
    }

    void displayTeam()
    {
        String teamName = Database.getTeamName(Model.getInstance().getEmail());
        if(teamName != null)
        {
            teamTextField.setText(teamName);
        }
        else
        {
            teamTextField.setText("You are not in a team");
        }
    }

}

