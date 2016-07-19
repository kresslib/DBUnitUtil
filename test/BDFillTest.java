/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class BDFillTest {

    public BDFillTest() {
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
     * Test of createTables method, of class BDFill.
     */
    @Test
    public void testCreateTables() {
        System.out.println("createTables");
        String createAllTablesScript = "CREATE TABLE devices_stack\n"
                + "(\n"
                + "  hash character varying(4000) NOT NULL,\n"
                + "  dt_create timestamp without time zone,\n"
                + "  server_key bytea,\n"
                + "  device_key bytea,\n"
                + "  user_code character varying(6),\n"
                + "  dt_delete timestamp without time zone\n"
                + ")\n"
                + "WITH (\n"
                + "  OIDS=FALSE\n"
                + ");\n"
                + "ALTER TABLE devices_stack\n"
                + "  OWNER TO postgres;\n"
                + "COMMENT ON TABLE devices_stack\n"
                + "  IS 'Стэк устройст зарегистрированных в системе.';"
                + "\n"
                + "CREATE TABLE temp_devices_stack\n"
                + "(\n"
                + "  hash character varying(4000) NOT NULL,\n"
                + "  dt_create timestamp without time zone,\n"
                + "  dt_complete timestamp without time zone,\n"
                + "  server_key bytea,\n"
                + "  device_key bytea,\n"
                + "  user_code character varying(6),\n"
                + "  ban integer DEFAULT 0,\n"
                + "  CONSTRAINT pk_temp_devices_stack PRIMARY KEY (hash)\n"
                + ")\n"
                + "WITH (\n"
                + "  OIDS=FALSE\n"
                + ");\n"
                + "ALTER TABLE temp_devices_stack\n"
                + "  OWNER TO postgres;\n"
                + "COMMENT ON TABLE temp_devices_stack\n"
                + "  IS 'Стэк устройст находящихся в процессе регистрации и ожидающих подтверждения регистрации.';"
                + "\n"
                + "CREATE TABLE upload_db\n"
                + "(\n"
                + "  id numeric(14,0),\n"
                + "  dt_create time without time zone,\n"
                + "  upload_data bytea,\n"
                + "  hash character varying(4000)\n"
                + ")\n"
                + "WITH (\n"
                + "  OIDS=FALSE\n"
                + ");\n"
                + "ALTER TABLE upload_db\n"
                + "  OWNER TO postgres;";
        Connection con = null;
        try {
            con = ConnectionClass.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBClearTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBClearTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] tables = new String[]{"devices_stack", "temp_devices_stack", "upload_db"};
        DBFill.createTables(createAllTablesScript);
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBClearTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT count(*) hastriggers FROM pg_tables where schemaname = 'public' ";
        try {
            for (String s_tablename : tables) {
                ResultSet rs = st.executeQuery(sql + "and tablename = '" + s_tablename + "'");
                while (rs.next()) {
                    assertFalse((rs.getInt(1) != 1));
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
