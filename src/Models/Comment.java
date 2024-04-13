package Models;

import java.util.*;

public class Comment
{
    private User user;
    private User commentor;
    private String comment;

    public Comment(User user, User commentor, String comment)
    {
        this.user = user;
        this.commentor = commentor;
        this.comment = comment;

        Database.insertNewComment(this);
    }

    public User getUser()
    {
        return user;
    }
    
    public User getCommentor()
    {
        return commentor;
    }

    public String getComment()
    {
        return comment;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public void setCommentor(User commentor)
    {
        this.commentor = commentor;
    }
    
    public void setComment(String comment)
    {
        this.comment = comment;
    }
}
