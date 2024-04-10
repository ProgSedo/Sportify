package Models;

import java.util.*;

public class Comment
{
    private User user;
    private String comment;

    public Comment(User user, String comment)
    {
        this.user = user;
        this.comment = comment;
    }

    public User getUser()
    {
        return user;
    }
    
    public String getComment()
    {
        return comment;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }
}
