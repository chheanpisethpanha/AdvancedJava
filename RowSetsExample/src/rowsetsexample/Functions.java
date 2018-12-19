/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rowsetsexample;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Functions {
    public void chooseOption () {
        char ch = 0;
        int id = 0;
        String name;
        Scanner s = new Scanner(System.in);
        System.out.println("Entering");
        ch = s.next().charAt(0);
        switch (ch){
            case 1:
                System.out.println("You chose option 1> Enter value:");
//                System.out.println("Name: ");
//                id = s.nextInt();
//                System.out.println("Id: ");
//                name = s.next();
                
                
                insert();
        }
    }

    private void insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//System.out.println("Insert Record: ");
//                System.out.println("How many record you want to insert?");
//                rec = s.nextInt();
//                
//                while(rec==0)
//                {
//                    System.out.println("Enter Record:"+i);
//                    
//                }