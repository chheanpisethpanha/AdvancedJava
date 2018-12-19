/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowsetsexample;

import java.sql.SQLException;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author Admin
 */
public class RowSetsExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            JdbcRowSet jrc = RowSetProvider.newFactory().createJdbcRowSet();
            
            jrc.setUrl("jdbc:mysql://localhost:3306/mysql");
            jrc.setUsername("root");
            jrc.setPassword("");
            jrc.setCommand("select * from batch4");
            jrc.addRowSetListener(new MyListener());
            jrc.execute();
            
            System.out.println("Success");
            
            while(jrc.next())
            {
                System.out.println("Id : "+jrc.getInt("id"));
                System.out.println("Name : "+jrc.getString("name"));
            }
            
        } catch (SQLException ex) {
            System.out.println("SQL Exception...");
        }
    }}
class MyListener implements RowSetListener
{

    @Override
    public void rowSetChanged(RowSetEvent event) {
      
    }

    @Override
    public void rowChanged(RowSetEvent event) {
      
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("Cursor Moved...");
    }
    
}
