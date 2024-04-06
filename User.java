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
    private int age;

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

    public Date getBirthday()
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




}
