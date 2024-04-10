import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaConnect2SQL {
    public static void main(String[] args) {
       
        
                String connectionString = "jdbc:sqlserver://MSI;database=UsersDB;IntegratedSecurity=true;trustServerCertificate=true;";
                String user = "sa";
                String password = "1";
        
                try {
                    System.out.println("Attempting to establish connection...");
                    try (Connection connection = DriverManager.getConnection(connectionString, user, password)) {
                        System.out.println("Connection established successfully!");
                    }
                } catch (SQLException e) {
                    System.out.println("Error: Failed to establish connection.");
                    e.printStackTrace();
                }
            
        
        
        
        
    }
}
