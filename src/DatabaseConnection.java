import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private Connection con;


    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://MSI-MAGNUS;database=DMI_DB;username=sa;password=12345;encrypt=true;trustServerCertificate=true");
            System.out.println("Connected to database..");
            return con;
        } catch (SQLException e){
            System.err.println("Cannot create connection " + e.getMessage());
        }
        return null;
    }


}
