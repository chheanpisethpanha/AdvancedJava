package mydbtest;

import java.sql.SQLException;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetExample {
    public static void main(String[] args) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            JdbcRowSet jrc = RowSetProvider.newFactory().createJdbcRowSet();
            //benifits of using this driver: you can have more features than RowSet
//            1. you don't have to load the driver
//            2. scrollable and flexible
            
            jrc.setUrl("jdbc:mysql://localhost:3306/mysql");
            jrc.setUsername("root");
            jrc.setPassword("");
            jrc.setCommand("SELECT * FROM batch4");
            jrc.addRowSetListener(new MyListener());
            jrc.execute();
            
            while(jrc.next()){
                System.out.println("ID: " + jrc.getInt(1)); //1 is the number of column position
                System.out.println("Name: " + jrc.getString(2)); 
            }
            
        }
        catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException...");
        }
        catch(SQLException ex){
            System.out.println("SQLException...");
        }
    }
}

class MyListener implements RowSetListener
{
    @Override
    public void rowSetChanged(RowSetEvent rse){
        
    }
    @Override
    public void rowChanged(RowSetEvent rse){
        
    }
    @Override
    public void cursorMoved(RowSetEvent rse){
        System.out.println("Cursor Moved...");
    }
}


