

public class Model {
    
    private static Model model;
    private final ViewFactory viewFactory;
    private static String currUserEmail;

    private Model()
    {
        this.viewFactory = new ViewFactory();
    }

    public static synchronized Model getInstance()
    {
        if(model == null)
        {
            model = new Model();
        }

        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public String getEmail()
    {
        return currUserEmail;
    }

    public void setEmail(String email)
    {
        currUserEmail = email;
    }
}
