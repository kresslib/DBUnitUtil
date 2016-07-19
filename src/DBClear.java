
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class DBClear {

    public static void tablesDrop(String[] tables) {
        Connection con = null;
        try {
            con = ConnectionClass.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBClear.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBClear.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String s_tablename : tables) {
            try {
                ScriptHelper.RunDDL(DBUnitHelper.getTableDropScript(s_tablename), con);
            } catch (SQLException ex) {
                Logger.getLogger(DBClear.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBClear.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
