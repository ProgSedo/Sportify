public class Model {
    
    private static Model model;
    private final ViewFactory viewFactory;
    private static String email;

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
        return email;
    }

    public void setEmail(String anEmail)
    {
        email = anEmail;
    }
}
