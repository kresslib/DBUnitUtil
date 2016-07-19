
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ikress
 */
public class ScriptHelper {

    public static void RunDDL(String script, Connection con) throws SQLException {
        Statement st = con.createStatement();
        st.execute(script);
    }
    public static void RunDML(String script, Connection con) throws SQLException {
        RunDDL(script, con);
        con.commit();
    }
}
