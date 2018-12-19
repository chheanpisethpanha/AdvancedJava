/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ztranger
 */
public class MyDBTest {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
         int  id = 0;  
        String name ="";
        char ch = 0;
        
        try
        {
            //4 Steps to use DB
// ###############################  1. Load Driver  ###########################################
            Class.forName("com.mysql.jdbc.Driver");            
            System.out.println("Driver Loaded Successfully");
            
// ###############################  2. Connecting to DB  ######################################
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", ""); //Connection is interface
            
// ###############################  3. Create Statement  #######################################
             //To prepare to execute SQL query
            Statement stt = con.createStatement();
            System.out.println("Statement created successfully");
           
//################################ 3. Create query string  ################################################################################
            //String queryString = "create table batch4(id int(5),name varchar (256));";
            
//            System.out.println("Insert ID");
//            id = s.nextInt();
//            System.out.println("Insert Name");
//            name = s.next();
            
            //@@@@@@@@@@@@@ Getting Input while loop @@@@@@@@@@@@@@@
//            while(ch!='n')
//            {
//                System.out.println("Do you want to continue insert? y/n");
//                ch = s.next().charAt(0);
//                if (ch == 'y')
//                {
//                    System.out.println("Insert ID");
//                    id = s.nextInt();
//                    System.out.println("Insert Name");
//                    name = s.next();
//                    String queryString = "insert into batch4 values ('"+id+"','"+name+"');";
//                    stt.execute(queryString);
//                }
//                else if (ch == 'n') break;
//                else System.out.println("invalid input!");
//            }
            //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            
           // ************************** Normal way *************************************************
           // String queryString = "insert into batch4 values ('"+id+"','"+name+"');";
           // ***************************************************************************************
           
           //????????????????????????? With question mark(Place Holder) ???????????????????????
               String query = "insert into batch4 values (?,?);";
               
               PreparedStatement ps = con.prepareStatement(query);
               
               System.out.println("Enter id and name");
               id = s.nextInt();
               name = s.next();
               
               ps.setInt(1, id);
               ps.setString(2, name);
               
               
               ps.addBatch(query);
           //??????????????????????????????????????????????????????????????????????????????????
           
           //++++++++++++++++++++++ Batch exe ++++++++++++++++++++++++++++++++++++++++
//           String query1 = "insert into batch4 values ('1','Panha')";
//           String query2 = "insert into batch4 values ('2','Wann')";
//           String query3 = "insert into batch4 values ('3','VV')";
//                   
//           stt.addBatch(query1);
//           stt.addBatch(query2);
//           stt.addBatch(query3);
//           
//           stt.executeBatch();
            //################################ 4. Execute query     ###########################################
           // stt.execute(queryString);
            System.out.println("Table Created Successfully");
        }catch(ClassNotFoundException ex)
        {
            System.out.println("Problem loading driver");
        } catch (SQLException ex) {
            Logger.getLogger(MyDBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
