

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaConnect2SQL {

    public static String connectionString = "jdbc:sqlserver://MSI;DatabaseName=UsersDB;IntegratedSecurity=true;TrustServerCertificate=True";
    // String connectionString =
    // "jdbc:sqlserver://MSI;DatabaseName=UsersDB;IntegratedSecurity=true;TrustServerCertificate=True;user=sa\\username;password=1";

    static String user = "sa";
    static String password = "1";


    public static Connection connect2Database() {
        try {
            Connection connection = DriverManager.getConnection(connectionString, user, password);
            //System.out.println("Attempting to establish connection...");
                return connection;
        } catch (SQLException e) {
            //System.out.println("Error: Failed to establish connection.");
            e.printStackTrace();
        }
        return null;
    }
}
