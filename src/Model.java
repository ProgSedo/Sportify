public class Model {
    
    private static Model model;
    private final ViewFactory viewFactory;
    private static User user;

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

    public User getUser()
    {
        return user;
    }

    public void setEmail(User aUser)
    {
        user = aUser;
    }
}
