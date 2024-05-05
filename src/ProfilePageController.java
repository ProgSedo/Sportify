

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailTextField.setText(Model.getInstance().getEmail());
        
        emailTextField.setEditable(false);
        interestsTextField.setEditable(false);
        usernameTextField.setEditable(false);
        ageTextField.setEditable(false);
        aboutMeTextArea.setEditable(false);
        commentsTextArea.setEditable(false);

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

}

