
import java.sql.Connection;
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
public class DBFill {

    public static void createTables(String script) {
        Connection con = null;
        try {
            con = ConnectionClass.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ScriptHelper.RunDDL(script, con);
        } catch (SQLException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public static void createSequence(String script) {
        Connection con = null;
        try {
            con = ConnectionClass.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ScriptHelper.RunDDL(script, con);
        } catch (SQLException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fillTables(String script) {
        Connection con = null;
        try {
            con = ConnectionClass.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ScriptHelper.RunDML(script, con);
        } catch (SQLException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBFill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

}
