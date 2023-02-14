package lk.sankalpa.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;
    private static DBConnection dBConnection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Jausa_Construction_Maldives", "root", "1234");

    }

    public static DBConnection getInstance()  {
        if (dBConnection == null) {
            try {
                dBConnection = new DBConnection();
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return dBConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
