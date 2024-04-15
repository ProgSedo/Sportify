package Views;

import java.io.IOException;

import FXMLandControllers.HomePage.HomePageController;
import FXMLandControllers.RegisterPage.RegisterController;
import FXMLandControllers.SignInPage.SignInController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewFactory {
    
    private VBox sideBarView;

    public ViewFactory(){}

    public VBox getSideBarView() throws IOException
    {
        if(sideBarView == null)
        {
            try
            {
            sideBarView = new FXMLLoader(getClass().getResource("FXMLandControllers/SideBar/SideBar.fxml")).load();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return sideBarView;
    }

    public void showSignInWindow()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLandControllers/SignInPage/SignIn.fxml"));
        SignInController controller = new SignInController();
        loader.setController(controller);
        createStage(loader);
    }

    public void showHomePage()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLandControllers/HomePage/HomePage.fxml"));
        HomePageController controller = new HomePageController();
        loader.setController(controller);
        createStage(loader);
    }

    public void showRegisterPage()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLandControllers/RegisterPage/Register.fxml"));
        RegisterController controller = new RegisterController();
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
}
