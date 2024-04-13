package Models;

import java.util.*;

public class User 
{
    //personal info
    private String email;
    private String password;
    private String name;
    private String surname;
    private int birthday;
    private String aboutMe;
    private Image profilePhoto;
    private int age;

    //interests
    private boolean football;
    private boolean volleyball;
    private boolean tennis;

    //friends, events and comments
    private ArrayList<User> friends;
    private ArrayList<User> friendRequests;
    private ArrayList<Events> eventsEngagedIn;
    private ArrayList<Comment> comments;

    //statistics
    private int footballGamesPlayed;
    private int footballGamesWon;
    private int footballGamesLost;
    private int volleyballGamesPlayed;
    private int volleyballGamesWon;
    private int volleyballGamesLost;
    private int tennisGamesPlayed;
    private int tennisGamesWon;
    private int tennisGamesLost;



    public User(String userEmail, String userPassword, int birthYear,
                boolean isFootball, boolean isVolleyball, boolean isTennis)
    {
        email = userEmail;
        password = userPassword;
        birthday = birthYear;
        football = isFootball;
        volleyball = isVolleyball;
        tennis = isTennis;

        footballGamesPlayed = 0;
        footballGamesWon = 0;
        footballGamesLost = 0;
        volleyballGamesPlayed = 0;
        volleyballGamesWon = 0;
        volleyballGamesLost = 0;
        tennisGamesPlayed = 0;
        tennisGamesWon = 0;
        tennisGamesLost = 0;
        Database.insertNewUser(this);
    }

    //getter methods
    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public int getBirthYear()
    {
        return birthday;
    }

    public String getAboutMe()
    {
        return aboutMe;
    }

    public Image getProfilePhoto()
    {
        return profilePhoto;
    }

    public int getAge()
    {
        return age;
    }

    public boolean getFootball()
    {
        return football;
    }

    public boolean getVolleyball()
    {
        return volleyball;
    }

    public boolean getTennis()
    {
        return tennis;
    }

    //setter methods
    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public void setAboutMe(String aboutMe)
    {
        this.aboutMe = aboutMe;
    }

    public void setProfilePhoto(Image profilePhoto)
    {
        this.profilePhoto = profilePhoto;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setFootball(boolean football)
    {
        this.football = football;
    }

    public void setVolleyball(boolean volleyball)
    {
        this.volleyball = volleyball;
    }

    public void setTennis(boolean tennis)
    {
        this.tennis = tennis;
    }

    //statistics updater methods
    public void increaseFootballGamesPlayed(boolean win)
    {
        footballGamesPlayed++;
        if(win)
        {
            footballGamesWon++;
        }
        else
        {
            footballGamesLost++;
        }
    }

    public void increaseVolleyballGamesPlayed(boolean win)
    {
        volleyballGamesPlayed++;
        if(win)
        {
            volleyballGamesWon++;
        }
        else
        {
            volleyballGamesLost++;
        }
    }

    public void increaseTennisGamesPlayed(boolean win)
    {
        tennisGamesPlayed++;
        if(win)
        {
            tennisGamesWon++;
        }
        else
        {
            tennisGamesLost++;
        }
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public ArrayList<User> getFriendRequests() {
        return friendRequests;
    }

    public ArrayList<Events> getEventsEngagedIn() {
        return eventsEngagedIn;
    }

    public void sendFriendRequest(User u) {
        u.getFriendRequests().add(this);
    }

    public void interactFriendRequest(boolean answer, User u) {
        if (answer) {
            this.getFriends().add(u);
        }
        this.getFriendRequests().remove(u);
    }

}
