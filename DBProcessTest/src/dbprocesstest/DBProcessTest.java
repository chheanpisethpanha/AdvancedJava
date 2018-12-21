package dbprocesstest;

import java.sql.SQLException;

public class DBProcessTest {

    public static void main(String[] args) { 
       DBProcessInterface dbop = new DBOP();
       
        try {
            
            dbop.getCon(); //get connection
            dbop.operateChoice(); //operate users choice
            
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            System.out.println(e);
        }
    }
}

    