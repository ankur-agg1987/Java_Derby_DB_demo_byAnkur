package java_db_demo_msacces_byankur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Ankur-Agg
 */
public class Java_DB_demo_MSAcces_byAnkur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // JAVA CODE TO ACCESS DERBY DATABASE
        
        // Apache Derby database driver
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        
        // Derby database connection string
        String connectionString = "jdbc:derby://localhost:1527/sample";
        
        // Derby database username and password
        String user = "app";
        String pwd = "app";
        
        // Query string for CUSTOMER table
        String query = "Select * from CUSTOMER";
        
        // try block to handle runtime issue of database operation
        try {
            //Step1: register Derby database driver
            Class.forName(driver);
            
            //Step2: Connect to Derby database
            Connection con = DriverManager.getConnection(connectionString, user, pwd);
            
            //Step3: create a statement object over connection object
            Statement st = con.createStatement();
            
            //Step4: execute the query
            ResultSet rs = st.executeQuery(query);
            
            //Step5: traverse the ResultSet object to access Name column under CUSTOMER table in Derby database
            while(rs.next()){
                
                // Ouput the name from CUSTOMER table
                System.out.println(rs.getString("NAME"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
