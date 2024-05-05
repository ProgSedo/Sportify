

import java.sql.Statement;
import java.util.ArrayList;

import org.w3c.dom.events.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    public static Connection connection = JavaConnect2SQL.connect2Database();

    public static boolean checkEmail(String email) {

        ArrayList<String> emailList = new ArrayList<String>();
        boolean eMailExists = false;
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT email FROM Users";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                emailList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (String str : emailList) {
            if (str.equals(email)) {
                eMailExists = true;
                break;
            }
        }
        return eMailExists;
    }

    public static boolean checkPassword(String email, String password) {
        String userPassword = "";
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT password FROM Users WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                userPassword = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //lengths are different so put .trim
        System.out.println(password.trim().equals(userPassword.trim()));
        return password.trim().equals(userPassword.trim());
    }

    public static User getUser(String email) {
        String password = "";
        String name = "";
        String surname = "";
        int birthYearr = 0;

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Users WHERE email = '" + email + "'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                email = rs.getString(2);
                password = rs.getString(1);
                name = rs.getString(2);
                surname = rs.getString(3);
                birthYearr = rs.getInt(4);

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return new User(email, password, birthYearr, false, false, false);
    }

    public static void insertNewUser(User user) {
        try {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO Users (email, password, username, aboutMe, birthYear, eventID, doesTennis, doesFootball, doesVolleyball)"
            + "VALUES ('" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getUsername() + "', '" + user.getAboutMe() + "', '" + user.getBirthYear() + "', '" + user.getEventID() + "', '" + user.getIsTennis() + "', '" + user.getIsFootball() + "', '" + user.getIsVolleyball() +  "')";
            st.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertNewComment(Comment comment) {

        try {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO Comments ( user, commentor, comment ) VALUES (" + comment.getUser() + ", " + comment.getCommentor() + ", " + comment.getComment() + ")";
            st.execute( sql );
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertNewEvent( Events event ) {

        String sportTypeStr = "";
        if(event.getSportType() == SportType.tennis){
            sportTypeStr = "tennis";
        }
        else if(event.getSportType() == SportType.volleyball){
            sportTypeStr = "volleyball";
        }
        else if(event.getSportType() == SportType.football){
            sportTypeStr = "football";
        }
        try {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO Events ( eventID, eventTime, eventPlace, sportType ) VALUES (" + event.getEventID() + ", " + event.getEventTime() + ", '" + event.getPlace() + "', '" + sportTypeStr + "')";
            st.execute( sql );
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateAboutMe(String text) 
    {
        try {
            Statement st = connection.createStatement();
            String sql = "UPDATE Users SET aboutMe = '" + text + "' WHERE email = '" + Model.getInstance().getEmail() + "'";
            st.execute( sql );
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updatePassword(String password)
    {
        try {
            Statement st = connection.createStatement();
            String sql = "UPDATE Users SET password = '" + password + "' WHERE email = '" + Model.getInstance().getEmail() + "'";
            st.execute( sql );
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getAge(String email) {
        //not tested
        int age = 0;
        try {
            email = Model.getInstance().getEmail();
            Statement st = connection.createStatement();
            String sql = "SELECT birthYear FROM Users WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                int birthYear = rs.getInt(1);
                age = java.time.Year.now().getValue() - birthYear;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return age;
    }

    public static void updateUsernameInfo(String username)
    {
        String email = Model.getInstance().getEmail();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "UPDATE Users SET username = '" + username + "' WHERE email = '" + email + "'";
            st.execute( sql );
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void updateFootballInfo(boolean doesFootball)
    {
        String email = Model.getInstance().getEmail();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "UPDATE Users SET doesFootball = " + convertBoolean(doesFootball) + " WHERE email = '" + email + "'\n";
            st.execute( sql );
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void updateVolleyballInfo( boolean doesVolleyball)
    {
        String email = Model.getInstance().getEmail();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "UPDATE Users SET doesVolleyball = " + convertBoolean(doesVolleyball) + " WHERE email = '" + email + "'";
            st.execute( sql );
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static int convertBoolean(boolean does) {
        if (does) {
            return 1;
        }
        else return 0;
    }

    public static void updateTennisInfo(boolean doesTennis)
    {
        String email = Model.getInstance().getEmail();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "UPDATE Users SET doesTennis = " + convertBoolean(doesTennis) + " WHERE email = '" + email + "'";
            st.execute( sql );
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static String getUsername(String email) {
        //not tested
        String username = "aaaaa";
        try {
            email = Model.getInstance().getEmail();
            Statement st = connection.createStatement();
            String sql = "SELECT username FROM Users WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                username = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return username;
    }


    public static String getInterests(String email) {
        //not tested
        String interests = "";
        try {
            email = Model.getInstance().getEmail();
            Statement st = connection.createStatement();
            String sql = "SELECT doesFootball FROM Users WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                  
                 if (Integer.parseInt(rs.getString(1)) == 1) {
                    interests += "Football ";
                 }
            }

             sql = "SELECT doesVolleyball FROM Users WHERE email = '" + email + "'";
             rs = st.executeQuery(sql);
            while (rs.next()) {
                if (Integer.parseInt(rs.getString(1)) == 1) {
                    interests += "Volleyball ";
                 }
            }
            
            sql = "SELECT doesTennis FROM Users WHERE email = '" + email + "'";
            rs = st.executeQuery(sql);
           while (rs.next()) {
               
            if (Integer.parseInt(rs.getString(1)) == 1) {
                interests += "Tennis ";
             }
           }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return interests;
    }

    public static String getAboutMe(String email) {
        //not tested
        String str = "";
        try {
            email = Model.getInstance().getEmail();
            Statement st = connection.createStatement();
            String sql = "SELECT aboutMe FROM Users WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                str = rs.getString(1);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return str;
    }

    public static void createFriendsTable(String emailTable) {
        try {
            Statement st = connection.createStatement();
            String sql = "CREATE TABLE " + emailTable + "( email VARCHAR(50) UNIQUE NOT NULL)";
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void sendFriendRequest(String emailToBeAdded) {
        String email = Model.getInstance().getEmail();
        try {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO " + emailToBeAdded + "_friends (email, friend_status) VALUES ('" + email + "', 0)";
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void declineFriend(String emailToBeDeclined) {
        String email = Model.getInstance().getEmail();
        try {
            Statement st = connection.createStatement();
            String sql = "DELETE FROM " + email + "_friends WHERE email='" + emailToBeDeclined + "'";
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeFriend(String emailToBeRemoved) {
        String email = Model.getInstance().getEmail();
        try {
            Statement st = connection.createStatement();
            String sql = "DELETE FROM " + email + "_friends WHERE email='" + emailToBeRemoved + "'";
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Statement st = connection.createStatement();
            String sql = "DELETE FROM " + emailToBeRemoved + "_friends WHERE email='" + email + "'";
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void acceptFriendRequest(String emailToBeAdded) {
        String email = Model.getInstance().getEmail();
        try {
            Statement st = connection.createStatement();
            String sql = "UPDATE TABLE " + email + "_friends SET friend_status = 1 WHERE email = " + emailToBeAdded + "";
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO " + emailToBeAdded + "_friends (email, friend_status) VALUES ('" + email + "', 1)";
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }









    /* 
    public static void insertMessageToForum(String forumName, Comment comment) {
    try {
        Connection connection = getConnection(); // Assuming getConnection() returns a valid database connection
        PreparedStatement pst = connection.prepareStatement("INSERT INTO " + forumName + " (forum, user, message) VALUES (;
        pst.setString(1, forumName);?, ?, ?)")
        pst.setString(2, comment.getUser());
        pst.setString(3, comment.getComment());
        pst.executeUpdate();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    */
}
