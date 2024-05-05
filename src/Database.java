

import java.sql.Statement;
import java.util.ArrayList;

import org.w3c.dom.events.Event;

import java.sql.Connection;
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

        try 
        {
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
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return new User(email, password, birthYearr, false, false, false);
    }

    public static void insertNewUser(User user) {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO Users (email, password, name, surname, aboutMe, birthYear)"
            + "VALUES ('" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getName() + "', '" + user.getSurname() + "', '" + user.getAboutMe() + "', '" + user.getBirthYear() + "')";
            st.execute(sql);
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertNewComment(Comment comment) {

        try 
        {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO Comments ( user, commentor, comment ) VALUES (" + comment.getUser() + ", " + comment.getCommentor() + ", " + comment.getComment() + ")";
            st.execute( sql );
        
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertNewEvent( Events event ) {

        try 
        {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO Events ( eventName, eventTime, sportType ) VALUES (" + event.getEventName() + ", " + event.getEventTime() + ", " + event.getSportType() + ")";
            st.execute( sql );
        
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateAboutMe(String text) 
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "UPDATE Users SET aboutMe = '" + text + "' WHERE email = '" + Model.getInstance().getEmail() + "'";
            st.execute( sql );
        
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updatePassword(String password)
    {
        try 
        {
            Statement st = connection.createStatement();
            String sql = "UPDATE Users SET password = '" + password + "' WHERE email = '" + Model.getInstance().getEmail() + "'";
            st.execute( sql );
        
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static int getAge(String email) 
    {
        //not tested
        int age = 0;
        try 
        {
            email = Model.getInstance().getEmail();
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

    public static void updateInfo(String username, int age, boolean doesFootball, boolean doesTennis,
    boolean doesVolleyball)
    {
        String email = Model.getInstance().getEmail();
        try 
        {
            Statement st = connection.createStatement();
            String sql = "UPDATE Users SET username = '" + username + "' WHERE email = '" + email + "'\n";
            sql += "UPDATE Users SET age = " + age + " WHERE email = '" + email + "'\n";
            sql += "UPDATE Users SET doesFootball = " + doesFootball + " WHERE email = '" + email + "'\n";
            sql += "UPDATE Users SET doesVolleyball = " + doesVolleyball + " WHERE email = '" + email + "'\n";
            sql += "UPDATE Users SET doesTennis = " + doesTennis + " WHERE email = '" + email + "'";
            st.execute( sql );
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
