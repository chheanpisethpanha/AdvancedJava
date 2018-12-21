package dbprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBProcedure {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            CallableStatement cs = con.prepareCall("{call insertBatch4(?)}");
            Controllers c = new Controllers();
            c.insertRecord();
      
            cs.execute();
            System.out.println("The record has inserted successfully...");
        }catch(ClassNotFoundException | SQLException e){
             System.out.println(e);
        }
    }
    
}
