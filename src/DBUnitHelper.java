
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ikress
 */
public class DBUnitHelper {



    public static String[] getTables(String createAllTablesScript) {

        List<String> tbl_names = new ArrayList<String>();
        createAllTablesScript = createAllTablesScript.toUpperCase();
        createAllTablesScript = createAllTablesScript.replaceAll("\n", " ");
        String[] all_scripts = createAllTablesScript.split("CREATE TABLE");
        for (String tbl_script : all_scripts) {
            String[] all_words = tbl_script.split(" ");

            if (all_words.length != 0) {
                for (String line_text : all_words) {
                    Pattern p = Pattern.compile("\\w");
                    Matcher m = p.matcher(line_text);
                    if (m.find()) {
                        tbl_names.add(line_text);
                        break;
                    }
                }

            }

        }
        return tbl_names.toArray(new String[0]);
    }
    
    public static String getTableDropScript(String tableName)
    {
        String result = "DROP TABLE "+ tableName+";";
        return result;
    }

}
