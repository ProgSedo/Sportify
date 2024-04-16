import java.io.IOException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewFactory {

    private final StringProperty decider;
    
    private AnchorPane sideBarView;

    private VBox profileView;

    private VBox homePageView;

    public ViewFactory()
    {
        this.decider = new SimpleStringProperty("");
    }

    public StringProperty getDecider()
    {
        return decider;
    }

    public AnchorPane getSideBarView()
    {
        if(sideBarView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SideBar.fxml"));
                SideBarController controller = new SideBarController();
                loader.setController(controller);
                sideBarView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return sideBarView;
    }

    public VBox getProfileView()
    {
        if(profileView == null)
        {
            try
            {
                profileView = new FXMLLoader(getClass().getResource("ProfilePage.fxml")).load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return profileView;
    }

    public VBox getHomePageView()
    {
        if(homePageView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                HomePageController controller = new HomePageController();
                loader.setController(controller);
                homePageView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return homePageView;
    }

    public void showSignInPage()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
        SignInController controller = new SignInController();
        loader.setController(controller);
        createStage(loader);
    }

    public void showRegisterPage()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
        RegisterController controller = new RegisterController();
        loader.setController(controller);
        createStage(loader);
    }

    public void showGeneralPane()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainBorderPane.fxml"));
        MainBorderPaneController controller = new MainBorderPaneController();
        loader.setController(controller);
        createStage(loader);
    }

    public void createStage(FXMLLoader loader)
    {
        Scene scene = null;
        try
        {
            scene = new Scene(loader.load());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Sportify");
        stage.show();
    }

    public void closeStage(Stage stage)
    {
        stage.close();
    }
}
