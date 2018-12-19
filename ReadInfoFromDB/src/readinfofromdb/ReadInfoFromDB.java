/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readinfofromdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ReadInfoFromDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // 1- Load Driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully...");
            
            // 2- Connect Driver
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
            
            // 3- Create statement
            Statement stt = con.createStatement();
            String queryString = ("update batch4 set name = 'Moonlight' where id='101'");
            
            // 4- Execute statement
            stt.execute(queryString);
            
            ResultSet rs = stt.executeQuery("select * from batch4");
            
            while(rs.next())
            {
                System.out.println("Id : "+rs.getInt("id")+"\nName :"+rs.getString("name"));
             
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
        } catch (SQLException ex) {
            Logger.getLogger(ReadInfoFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
