import java.io.IOException;

import FXMLandControllers.FootballForumPage.FootballForumController;
import FXMLandControllers.JoinEventPage.JoinEventPageController;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewFactory {

    private Stage stage;
    private AnchorPane sideBarView;
    private VBox profileView;
    private VBox homePageView;
    private VBox settingsView;
    private FlowPane createEventView;
    private AnchorPane footballForumView;
    private AnchorPane tennisForumView;
    private AnchorPane volleyballForumView;

    private FlowPane footballEventsView;
    private FlowPane tennisEventsView;
    private FlowPane voleyballEventsView;
    private VBox friendsPageView;
    private FlowPane joinEventView;
    private FlowPane emptyPane;

    private FlowPane myTennisEvents;
    private FlowPane myFootballEvents;
    private FlowPane myVolleyballEvents;

    private boolean isSideBarOpen;
    private final StringProperty decider;


    public ViewFactory()
    {
        this.decider = new SimpleStringProperty("");
        stage = new Stage();
        emptyPane = null;
        isSideBarOpen = false;
    }

    public boolean getIsSideBarOpen()
    {
        return isSideBarOpen;
    }

    public void closeAndOpenSideBar()
    {
        isSideBarOpen = !isSideBarOpen;
    }

    public void closeSideBar()
    {
        isSideBarOpen = false;
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
        profileView = null;
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilePage.fxml"));
            ProfilePageController controller = new ProfilePageController();
            loader.setController(controller);
            profileView = loader.load();
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
        SignInController controller = new SignInController();
        loader.setController(controller);
        createNewStage(loader);
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

    public void createNewStage(FXMLLoader loader)
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
        stage = new Stage();
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
        settingsView = null;
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
        if(volleyballForumView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("VolleyballForumPage.fxml"));
                VolleyballForumController controller = new VolleyballForumController();
                loader.setController(controller);
                volleyballForumView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return volleyballForumView;
    }
    
    public AnchorPane getTennisForumView()
    {
        if(tennisForumView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TennisForumPage.fxml"));
                TennisForumController controller = new TennisForumController();
                loader.setController(controller);
                tennisForumView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return tennisForumView;
    }

    public FlowPane getFootballEventsView()
    {
        if(footballEventsView== null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FootballEventsPage.fxml"));
                FootballEventsController controller = new FootballEventsController();
                loader.setController(controller);
                footballEventsView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return footballEventsView;
    }

    public FlowPane getTennisEventsView()
    {
        if(tennisEventsView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TennisEventsPage.fxml"));
                TennisEventsController controller = new TennisEventsController();
                loader.setController(controller);
                tennisEventsView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return tennisEventsView;
    }

    public FlowPane getVoleyballEventsView()
    {
        if(voleyballEventsView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("VolleyballEventsPage.fxml"));
                VolleyballEventsController controller = new VolleyballEventsController();
                loader.setController(controller);
                voleyballEventsView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return voleyballEventsView;
    }

    public VBox getFriendsPageView()
    {
        if(friendsPageView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FriendsPage.fxml"));
                FriendsPageController controller = new FriendsPageController();
                loader.setController(controller);
                friendsPageView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return friendsPageView;
    }

    public FlowPane getMyTennisEvents()
    {
        if(myTennisEvents == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MyTennisEvents.fxml"));
                MyTennisEventsController controller = new MyTennisEventsController();
                loader.setController(controller);
                myTennisEvents = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return myTennisEvents;
    }

    public FlowPane getMyFootballEvents()
    {
        if(myTennisEvents == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MyFootballEvents.fxml"));
                MyFootballEventsController controller = new MyFootballEventsController();
                loader.setController(controller);
                myFootballEvents = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return myFootballEvents;
    }

    public FlowPane getMyVolleyballEvents()
    {
        if(myVolleyballEvents == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MyVolleyballEvents.fxml"));
                MyVolleyballEventsController controller = new MyVolleyballEventsController();
                loader.setController(controller);
                myVolleyballEvents = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return myVolleyballEvents;
    }

    public FlowPane getJoinEventView()
    {
        if(joinEventView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("JoinEvent.fxml"));
                JoinEventPageController controller = new JoinEventPageController();
                loader.setController(controller);
                joinEventView = loader.load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return joinEventView;
    }

    public VBox getVisitFriendView()
    {
        VBox visitFriend = null;
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VisitorPage.fxml"));
            VisitorPageController controller = new VisitorPageController();
            loader.setController(controller);
            visitFriend = loader.load();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return visitFriend;
    }

    public FlowPane getTournamentView()
    {
        FlowPane tournamentView = null;
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TournamentView.fxml"));
            TournamentViewController controller = new TournamentViewController();
            loader.setController(controller);
            tournamentView = loader.load();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return tournamentView;
    }

    public FlowPane getMyTournamentView()
    {
        FlowPane myTournamentView = null;
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MyTournamentView.fxml"));
            MyTournamentViewController controller = new MyTournamentViewController();
            loader.setController(controller);
            myTournamentView = loader.load();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return myTournamentView;
    }

    public FlowPane getEmptyPane()
    {
        return this.emptyPane;
    }

    public void viewNuller()
    {
        sideBarView = null;
        profileView = null;
        homePageView = null;
        settingsView = null;
        createEventView = null;
        footballForumView = null;
        tennisForumView = null;
        volleyballForumView = null;

        footballEventsView = null;
        tennisEventsView = null;
        voleyballEventsView = null;
        friendsPageView = null;
        joinEventView = null;
        emptyPane = null;

        myTennisEvents = null;
        myFootballEvents = null;
        myVolleyballEvents = null;
    }
}
