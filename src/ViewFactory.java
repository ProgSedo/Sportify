import java.io.IOException;

import FXMLandControllers.CreateEventPage.CreateEventPageController;
import FXMLandControllers.FootballForumPage.FootballForumController;
import FXMLandControllers.SettingsPage.SettingsPageController;
import FXMLandControllers.VolleyballForumPage.VoleyballForumController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewFactory {

    private Stage stage;
    private final StringProperty decider;
    private AnchorPane sideBarView;
    private VBox profileView;
    private VBox homePageView;
    private VBox settingsView;
    private FlowPane createEventView;
    private AnchorPane footballForumView;
    private AnchorPane tennisForumView;
    private AnchorPane voleyballForumView;
    private AnchorPane footballEventsView;
    private AnchorPane tennisEventsView;
    private AnchorPane voleyballEventsView;
    private VBox friendsPageView;
    private FlowPane joinEventView;






    public ViewFactory()
    {
        this.decider = new SimpleStringProperty("");
        stage = new Stage();
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
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("Sportify");
        stage.show();
    }

    public void closeStage(Stage stage)
    {
        stage.close();
    }

    public Stage getStage()
    {
        return stage;
    }
    public VBox getSettingsView()
    {
        if(settingsView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SettingsPage.fxml"));
                SettingsPageController controller = new SettingsPageController();
                loader.setController(controller);
                settingsView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return settingsView;
    }

    public FlowPane getCreateEventView()
    {
        if(createEventView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateEventPage.fxml"));
                CreateEventPageController controller = new CreateEventPageController();
                loader.setController(controller);
                createEventView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return createEventView;
    }

    public AnchorPane getFootballForumView()
    {
        if(footballForumView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FootballForumPage.fxml"));
                FootballForumController controller = new FootballForumController();
                loader.setController(controller);
                footballForumView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return footballForumView;
    }
    public AnchorPane getVoleyballForumView()
    {
        if(voleyballForumView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("VoleyballForumPage.fxml"));
                VoleyballForumController controller = new VoleyballForumController();
                loader.setController(controller);
                voleyballForumView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return voleyballForumView;
    }
}
