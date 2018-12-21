package mydbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyDBTest {
    public static void main(String[] args) {
        try{
             //1. Load driver (Type 4 driver)
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully...");
            
            //2. Connecting to Database
            DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
            System.out.println("DB connected successfully...");
            
            //3.Create object reference to create statement
            //We create statement to prepare environment to run the queries
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            Statement stt = con.createStatement();
            System.out.println("The statement created successfully...");
            
            //4. Create query string
//            String queryString = "CREATE TABLE batch4 (id int(50), name varchar(256));"; //create table
////            String queryString = "INSERT INTO batch4 values(1, 'Ratanawan');"; //insert value
//           
////          //Execute the queries
//            stt.execute(queryString); //If you already, created the table and you run it twice, you will get SQLException
//            System.out.println("The statement executed...");

//-------------------------Get input from user until the user say no-----------------------------//
//Getting user input and then insert into the table
//                Scanner s = new Scanner(System.in);
//                int id;
//                String name;
//                char choice = 0;
//                
//                do{
//                System.out.println("Input ID: ");
//                id = s.nextInt();
//                
//                System.out.println("Input name: ");
//                name = s.next();
//                
//                String queryString = "INSERT INTO batch4 VALUES(" + id + "," + " '" + name + "' " + ");" ;
//                stt.execute(queryString);
//                System.out.println("Query executed...");
//                }while(choice == 'y');

//-----------------------------Prepare statement-------------------------------------------//
//        Scanner s = new Scanner(System.in);
//                int id;
//                String name;
//                
//        String query = "INSERT INTO batch4 values(?,?);";
//        PreparedStatement ps = con.prepareStatement(query);
//        
//            System.out.println("Enter id: ");
//            id = s.nextInt();
//            System.out.println("Enter name: ");
//            name = s.next();
//            
//            ps.setInt(1, id);
//            ps.setString(2, name);
//            ps.execute();

//----------------------------Batch Execution(Execute many queries at a time)-------------------//
//            String query1 = "INSERT INTO batch4 VALUES(4, 'Panha');";
//            String query2 = "INSERT INTO batch4 VALUES(5, 'V');";
//            String query3 = "INSERT INTO batch4 VALUES(6, 'Dane');";
//            
//            stt.addBatch(query1);
//            stt.addBatch(query2);
//            stt.addBatch(query3);
//            
//            stt.executeBatch();

//-----------------------------------Read from database-----------------------------------------//
//              ResultSet rs = stt.executeQuery("SELECT * FROM batch4;");
//              while(rs.next()){
//                  System.out.println("ID: " + rs.getInt("id"));
//                  System.out.println("Name: " + rs.getString("name"));
//              }

//-----------------------------------Update data in database-----------------------------------//
               String updateQuery = "UPDATE batch4 SET name = ? WHERE id = ?;";
               PreparedStatement ps = con.prepareStatement(updateQuery);
               ps.setString(1, "Eh Yo!!");
               ps.setInt(2, 3);
               ps.execute();
               ResultSet rs = stt.executeQuery("SELECT * FROM batch4;");
                while(rs.next()){
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                }
               
            
        }catch(ClassNotFoundException e){
            System.out.println("Problem loading driver...");
        }
        catch(SQLException ex){
            System.out.println("SQL exception");

        }
    }
    
}
