/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbsoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        DBOP obj = new DBOP();
            obj.getCon();      
        
        obj.chooseOption();        
    }
    
}

