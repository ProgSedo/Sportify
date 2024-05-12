

import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

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

    public static void insertNewUser(User user) 
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO Users (email, password, username, aboutMe, birthYear, eventID, doesTennis, doesFootball, doesVolleyball)"
            + "VALUES ('" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getUsername() + "', '" + user.getAboutMe() + "', '" + user.getBirthYear() + "', '" + user.getEventID() + "', '" + user.getIsTennis() + "', '" + user.getIsFootball() + "', '" + user.getIsVolleyball() +  "')";
            st.execute(sql);
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void createCommentsTable(String emailTable)
    {    
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

    public static void addComment(String emailToBeAdded, String commentText) 
    {
        String email = Model.getInstance().getEmail();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO " + emailToBeAdded + "_comments (email, comment) VALUES ('" + email + "','" + commentText +"')";
            st.execute(sql);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        System.out.println("comment added");
    }

    public static void updateAboutMe(String text) 
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "UPDATE Users SET aboutMe = '" + text + "' WHERE email = '" + Model.getInstance().getEmail() + "'";
            st.execute( sql );
        
        } 
        catch (Exception e) 
        {
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

    public static void insertNewEvent(int parameter, String name, LocalDateTime datetime, int teamSize, String place, String details, boolean isOver)
    {
        try 
        {
            Statement st = connection.createStatement();
            System.out.println(Timestamp.valueOf(datetime));
            String sql = "INSERT INTO " + parameterToTableName(parameter) + " (name, datetime, teamSize, place, details, isOver)"
            + "VALUES ('" + name + "', '" + Timestamp.valueOf(datetime) + "'," + teamSize + ", '" + place + "', '" + details + "', " + Database.convertBoolean(isOver) + ")";
            st.execute(sql);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void createEventParticipants(int eventID)
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "CREATE TABLE participants_" + eventID + " (email VARCHAR(50))";
            st.executeUpdate(sql);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void addParticipant(String email, int eventID)
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO participants_" + eventID + " (email) VALUES ('" + email + "')";
            st.execute(sql);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    

    public static void joinEvent(String email, int eventID)
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO " + email + "_events (eventID, isCommented) VALUES ('" + eventID + "'," + 0 + ")";
            st.execute(sql);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void doesComment(String email, int eventID)
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "UPDATE" + email + "_events SET isCommented = '" + 1 + "' WHERE eventID = '" + eventID + "'";
            st.execute( sql );
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void createUserEvents(String email)
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "CREATE TABLE " + email + "_events (eventID int, isCommented BIT)";
            st.executeUpdate(sql);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    //Will be implemented to have a variable int parameter
    public static ArrayList<Integer> getUserEvents(String email, int parameter)
    {
        ArrayList<Integer> events = new ArrayList<Integer>();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT eventID FROM " + email + "_events";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                int ID = rs.getInt(1);
                if( parameter * 1000000 <= ID && ID < (parameter +1) * 1000000 )
                {
                    events.add(ID);
                }
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return events;
    }

    // football_matches: 0
    // football_tournaments: 1
    // volleyball_mathces: 2
    // volleyball_tournaments: 3
    // tennis_matches: 4
    // tennis_tournaments: 5
    public static ArrayList<Integer> getEvents(int parameter)
    {
        ArrayList<Integer> events = new ArrayList<Integer>();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT eventID FROM " + parameterToTableName(parameter);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                events.add(Integer.parseInt(rs.getString(1)));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return events;
    }

    public static String getEventName(int eventID, int parameter)
    {
        String name = "";
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT name FROM " + parameterToTableName(parameter) + " WHERE eventID = " + eventID ;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                name = rs.getString(1);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return name;
    }

    public static LocalDateTime getDateTime(int eventID, int parameter)
    {
        LocalDateTime datetime = null;
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT datetime FROM " + parameterToTableName(parameter) + " WHERE eventID = " + eventID ;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                Timestamp time = rs.getTimestamp(1);
                datetime = time.toLocalDateTime();
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return datetime;
    }

    public static String getPlace(int eventID, int parameter)
    {
        String place = "";
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT place FROM " + parameterToTableName(parameter) + " WHERE eventID = " + eventID ;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                place = rs.getString(1);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return place;
    }

    public static String getDetails(int eventID, int parameter)
    {
        String details = "";
        try 
        {
            Statement st = connection.createStatement();
            String sql = "SELECT details FROM " + parameterToTableName(parameter) + " WHERE eventID = " + eventID ;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                details = rs.getString(1);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return details;
    }

    public static String parameterToTableName(int parameter)
    {
        String name = "";
        if(parameter == 0)
        {
            name = "football_matches";
        }
        else if(parameter == 1)
        {
            name = "football_tournaments";
        }
        else if(parameter == 2)
        {
            name = "volleyball_matches";
        }
        else if(parameter == 3)
        {
            name = "volleyball_tournaments";
        }
        else if(parameter == 4)
        {
            name = "tennis_matches";
        }
        else
        {
            name = "tennis_tournaments";
        }
        return name;
    }

    public static int returnLastEvent(int parameter) {
        int id = 0;
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT eventID FROM " + parameterToTableName(parameter) + " WHERE eventID = (SELECT MAX(eventID) FROM " + parameterToTableName(parameter) + ")";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static ArrayList<String> getEventParticipants(int ID) {
        ArrayList<String> lst = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            String sql = "SELECT email FROM participants_" + ID;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lst.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lst;

    }

    public static int getEventSize(int eventID, int parameter) {
        int size = 0;

        try {
            Statement st = connection.createStatement();
            String sql = "SELECT teamSize FROM " + parameterToTableName(parameter) + " WHERE eventID = " + eventID;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                size = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }
}
