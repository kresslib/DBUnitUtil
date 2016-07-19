
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ikress
 */
public class ConnectionClass {

    private static final String DATABASE_SERVER_CONNECTION_STRING = "jdbc:postgresql://localhost:5432/infoenergo_mobile_core_flashback";
    private static final String DATABASE_SERVER_USER = "postgres";
    private static final String DATABASE_SERVER_PASSWORD = "kl0pik";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(DATABASE_SERVER_CONNECTION_STRING, DATABASE_SERVER_USER, DATABASE_SERVER_PASSWORD);
        con.setAutoCommit(false);
        return con;
    }

}
