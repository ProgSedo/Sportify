package Project;

import java.util.*;

public class User 
{
    private String email;
    private String password;
    private String name;
    private String surname;
    private Date birthday;
    private String aboutMe;
    private Image profilePhoto;

    private boolean football;
    private boolean volleyball;
    private boolean tennis;

    private ArrayList<User> friends;
    private ArrayList<User> friendRequests;
    private ArrayList<Event> eventsEngagedIn;

    public User(String userEmail, String userPassword, Date dateOfBirth
                boolean isFootball, boolean isVolleyball, boolean isTennis)
    {
        email = userEmail;
        password = userPassword;
        birthday = dateOfBirth;
        football = isFootball;
        volleyball = isVolleyball;
        tennis = isTennis;
    }



}
