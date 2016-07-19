/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.util.Arrays;
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
public class DBUnitHelperTest {

    public DBUnitHelperTest() {
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
     * Test of tablesDrop method, of class DBUnitHelper.
     */
    @Test
    public void testTablesDrop() {
        System.out.println("tablesDrop");
        Connection con = null;
        String[] tables = null;
        DBUnitHelper.tablesDrop(con, tables);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTables method, of class DBUnitHelper.
     */
    @Test
    public void testGetTables() {
        System.out.println("getTables");
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
        String[] tables_exp = new String[]{"devices_stack", "temp_devices_stack", "upload_db"};
        String[] tables_real = DBUnitHelper.getTables(createAllTablesScript);
        String s_tables_exp = Arrays.toString(tables_exp);
        String s_tables_real = Arrays.toString(tables_real);
        assertTrue(s_tables_exp.equalsIgnoreCase(s_tables_real));
    }
    
    /**
     * Test of getTables method, of class DBUnitHelper.
     */
    @Test
    public void testGetTablesDubleSpase() {

        System.out.println("getTables");
        String createAllTablesScript1
                = "CREATE TABLE    devices_stack   \n"
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
        createAllTablesScript1 = createAllTablesScript1;
        String[] tables_exp = new String[]{"devices_stack", "temp_devices_stack", "upload_db"};
        String[] tables_real = DBUnitHelper.getTables(createAllTablesScript1);
        String s_tables_exp = Arrays.toString(tables_exp);
        String s_tables_real = Arrays.toString(tables_real);
        assertTrue(s_tables_exp.equalsIgnoreCase(s_tables_real));

    }
    

}
