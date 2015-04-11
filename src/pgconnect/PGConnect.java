/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sakwaa
 */
public class PGConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            String host = "jdbc:postgresql://localhost:5432/teammembers";
            String pswd = "student";
            String user = "student";
            String SQL  = "SELECT * FROM members";
            
            Connection db = DriverManager.getConnection( host, user, pswd );
            
            Statement query   = db.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            ResultSet results = query.executeQuery(SQL); 
            
            while(results.next()) {
                System.out.println(
                        results.getInt("id") + 
                        " " + results.getString("first_name") +
                        " " + results.getString("last_name") + 
                        " " + results.getString("job_title"));
            }
            
        } catch(SQLException e) {
            
            System.out.println("System exploded: " + e.getMessage());
        }
    }
    
}
