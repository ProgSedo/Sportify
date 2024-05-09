

import java.sql.Statement;
import java.util.ArrayList;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    public static Connection connection = JavaConnect2SQL.connect2Database();

    public static boolean checkEmail(String email) {

        ArrayList<String> emailList = new ArrayList<String>();
        boolean eMailExists = false;
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT email FROM Users";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                emailList.add(rs.getString(1));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        for (String str : emailList) 
        {
            if (str.equals(email)) 
            {
                eMailExists = true;
                break;
            }
        }
        return eMailExists;
    }

    public static boolean isTennisSelected(String email) {
        int selection = 0;
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT doesTennis FROM Users WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
               selection = rs.getInt(1);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        if (selection == 1)
            return true;
            return false;
    }

    public static boolean isFootballSelected(String email) {
        int selection = 0;
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT doesFootball FROM Users WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
               selection = rs.getInt(1);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        if (selection == 1)
            return true;
            return false;
    }

    public static boolean isVolleyballSelected(String email) {
        int selection = 0;
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT doesVolleyball FROM Users WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
               selection = rs.getInt(1);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        if (selection == 1)
            return true;
            return false;
    }

    

    public static ArrayList<String> returnList(String email, int number) {

        ArrayList<String> List = new ArrayList<String>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT email FROM " + email + "_friends WHERE friend_status = " + number;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                List.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return List;
    }


    public static boolean checkUsername(String username) {

        ArrayList<String> usernameList = new ArrayList<String>();
        boolean usernameExists = false;
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT username FROM Users";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                usernameList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (String str : usernameList) {
            if (str.equals(username)) {
                usernameExists = true;
                break;
            }
        }
        return usernameExists;
    }

    public static String emailByUsername(String username) {
        String email = "";
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT email FROM Users WHERE username = '" + username + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    public static String usernameByEmail(String email) {
        String username = "";
        try {
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

        return new User(email, password, "asda", birthYearr, false, false, false);
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

    public static void createCommentsTable(String emailTable) {

        
       
        try 
        {
            Statement st = connection.createStatement();
            String sql = "CREATE TABLE " + emailTable + "( email VARCHAR(50) UNIQUE NOT NULL, comment VARCHAR(MAX))";
            st.executeUpdate(sql);
        } 
        catch (Exception e) 
        {
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
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT birthYear FROM Users WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                int birthYear = rs.getInt(1);
                age = java.time.Year.now().getValue() - birthYear;
            }
        } 
        catch (SQLException e) 
        {
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
        String username = "";
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT username FROM Users WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                username = rs.getString(1);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return username;
    }


    public static String getInterests(String email) {
        //not tested
        String interests = "";
        try {
            
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
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT aboutMe FROM Users WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                str = rs.getString(1);
                
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        if (str.equals("null"))
            return "";
        return str;
    }


    public static void createFriendsTable(String emailTable) {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "CREATE TABLE " + emailTable + "( email VARCHAR(50) UNIQUE NOT NULL, friend_status BIT)";
            st.executeUpdate(sql);
        } 
        catch (Exception e) 
        {
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
            String sql = "DELETE FROM " + email + "_friends WHERE email='" + emailToBeRemoved + "'\n";
            sql += "DELETE FROM " + emailToBeRemoved + "_friends WHERE email='" + email + "'";
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void acceptFriendRequest(String emailToBeAdded) {
        String email = Model.getInstance().getEmail();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "UPDATE " + email + "_friends SET friend_status = 1 WHERE email = '" + emailToBeAdded + "'";
            st.execute(sql);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        try 
        {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO " + emailToBeAdded + "_friends (email, friend_status) VALUES ('" + email + "', 1)";
            st.execute(sql);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getMessagesOfTennisForum()
    {
        ArrayList<String> messages = new ArrayList<String>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT message FROM tennis_forum";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                messages.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return messages;
    }

    public static ArrayList<String> getMessagesOfVolleyballForum()
    {
        ArrayList<String> messages = new ArrayList<String>();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT message FROM volleyball_forum";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                messages.add(rs.getString(1));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
        return messages;
    }

    public static ArrayList<String> getMessagesOfFootballForum()
    {
        ArrayList<String> messages = new ArrayList<String>();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT message FROM football_forum";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                messages.add(rs.getString(1));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
        return messages;
    }

    public static void addNewMessageToTennisForum(String message, String email)
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO tennis_forum (message, email) VALUES ('" + message + "', '" + email + "')";
            st.execute(sql);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void addNewMessageToFootballForum(String message, String email)
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO football_forum (message, email) VALUES ('" + message + "', '" + email + "')";
            st.execute(sql);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void addNewMessageToVolleyballForum(String message, String email)
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO volleyball_forum (message, email) VALUES ('" + message + "', '" + email + "')";
            st.execute(sql);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    //0 is tennis, 1 is volleyball, 2 or others is football.
    public static String getEmailFromForums(int sportType, String message) 
    {
        String email = "";
        if (sportType == 0) 
        {
            try 
            {
                Statement st = connection.createStatement();
                String sql = "SELECT email FROM tennis_forum WHERE message = '" + message + "'";;
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) 
                {
                    email = rs.getString(1);
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
        else if (sportType == 1) 
        {
            try 
            {
                Statement st = connection.createStatement();
                String sql = "SELECT email FROM volleyball_forum WHERE message = '" + message + "'";;
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) 
                {
                    email = rs.getString(1);
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
        else 
        {
            try 
            {
                Statement st = connection.createStatement();
                String sql = "SELECT email FROM football_forum WHERE message = '" + message + "'";;
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) 
                {
                    email = rs.getString(1);
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
        return email;
    }

    // to take the comments made on the user with email "email"
    public static ArrayList<String> getComments(String email)
    {
        ArrayList<String> comments = new ArrayList<String>();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT comment FROM "+ email +"_comments";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                comments.add(rs.getString(1));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return comments;
    }

    // returns the username of the commenter
    public static String getUsernameByComment(String comment, String email)
    {
        String senderEmail = "";
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT email FROM " + email + "_comments WHERE comment = '" + comment + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                senderEmail = rs.getString(1);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return usernameByEmail(senderEmail);
    }
}
