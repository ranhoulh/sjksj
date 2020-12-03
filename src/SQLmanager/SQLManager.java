package SQLmanager;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLManager {

    public static Connection getConnection() {
        Connection con = null;
        try {
            System.out.println("begin.");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=three","xl","123");
            System.out.println("end.");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

}
