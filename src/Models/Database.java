package Models;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private static Connection connection = JavaConnect2SQL.connect2Database();
}
