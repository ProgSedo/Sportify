public class Model {
    
    private static Model model;
    private final ViewFactory viewFactory;
    private static String email;
    private static String friendEmail;
    private static int currentTournament;
    private static int parameter;

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

    public String getFriendEmail()
    {
        return friendEmail;
    }

    public void setFriendEmail(String anEmail)
    {
        friendEmail = anEmail;
    }
    
    public int getTournament()
    {
        return currentTournament;
    }

    public void setTournament(int eventID)
    {
        currentTournament = eventID;
    }

    public int getParameter()
    {
        return parameter;
    }

    public void setParameter(int pm)
    {
        parameter = pm;
    }
}
