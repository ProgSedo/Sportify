package Models;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private static Connection connection = JavaConnect2SQL.connect2Database();

    public static boolean checkEmail(String email) {

        ArrayList<String> emailList = new ArrayList<String>();
        boolean eMailExists = false;
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT email FROM User";
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
            String sql = "SELECT password FROM User WHERE email = '" + email + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                userPassword = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password.equals(userPassword);
    }

    public static User getUser(String email) {
        String password = "";
        String name = "";
        String surname = "";
        int birthYearr = 0;

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM User WHERE email = '" + email + "'";
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
            String sql = "INSERT INTO Users (emial, password, name, surname, aboutMe, birthYear)"
            + "SELECT " + user.getEmail() + ", '" + user.getPassword() + "', '" + user.getName() + "', '" + user.getSurname() + "', '" + user.getAboutMe() + "', '" + user.getBirthYear();
            st.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
