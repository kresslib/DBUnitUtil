/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertFalse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ikress
 */
public class DBClearTest {

    public DBClearTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of tablesDrop method, of class DBClear.
     */
    @Test
    public void testTablesDrop() {

        System.out.println("tablesDrop");
        Connection con = null;
        try {
            con = ConnectionClass.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBClearTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBClearTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] tables = new String[]{"devices_stack", "temp_devices_stack", "upload_db"};
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBClearTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT count(*) hastriggers FROM pg_tables where schemaname = 'public' ";

        DBClear.tablesDrop(tables);
        // TODO review the generated test code and remove the default call to fail.
        try {
            for (String s_tablename : tables) {
                ResultSet rs = st.executeQuery(sql + "and tablename = '" + s_tablename + "'");
                while (rs.next()) {
                    assertFalse((rs.getInt(1) != 0));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBClearTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBClearTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
