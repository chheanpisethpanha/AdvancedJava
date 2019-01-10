package transactiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TransactionDB {
    
    public static void main(String[] args) throws SQLException{
        
        Connection con = null;
        
       
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/batch4", "root", "root");
            PreparedStatement ps = con.prepareStatement("INSERT INTO bank (id, name, cash) VALUES (?,?,?)");
            con.setAutoCommit(false);
            
            ps.setInt(1, 2);
            ps.setString(2, "Sothea");
            ps.setInt(3, 1000);
            ps.execute();
            
//            ps.setInt(1, 3);
//            ps.setString(2, "Lynan");
//            ps.setInt(3, 5000);
//            ps.execute();
            
            con.commit();
            System.out.println("Transaction success...");
            
        } catch (SQLException ex) {
            try {
                con.rollback();
                System.out.println("Rollback...");
            } catch (SQLException ex1) {
                System.out.println("Exception...");
            }
        }
       
    }
    
}
