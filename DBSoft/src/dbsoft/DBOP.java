/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbsoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ztranger
 */
public class DBOP {
    
    static Student st = new Student();
    static Scanner s = new Scanner(System.in);
    static ArrayList<Student> al =  new ArrayList<>();
    
    
    public  void chooseOption () throws SQLException {
        
        System.out.println("Press 1 : Insert a data\nPress 2 : Insert multiple data\n"
                + "Press 3 : View a record\nPress 4 : View All Record\nPress 5 : Update a record\nPress 6 : Delete a record\nEnter here!!! >>>");
        int ch=s.nextInt();
        
        //Switch Case for User Options
        
        switch (ch){
            case 1:
                System.out.println("Option 1: Insert a data");
                Student data = inputData();
                insert(data);
                System.out.println("Inserted Successfully");
                break;
                
            case 2:
                System.out.println("Option 2: Insert Multiple data");
                do
                  {
                    ch='y';
                    if (ch == 'y')
                      {
                        Student dataMulti = inputData();
                        al.add(dataMulti);
                      }
                    else if (ch == 'n') break;
                    else System.out.println("invalid input!");
                    System.out.println("Do you want to continue insert? y/n");
                    ch = s.next().charAt(0);
                }while(ch!='n');
                insertMulti(al);
                break;
                 
            case 3:
                System.out.println("Option3");
                System.out.println("Enter id");
                int view;
                view = s.nextInt();
                Student obj = viewARecord(view);
                System.out.println(obj);
                break;
                
            case 4:
                System.out.println("Option4");
                al = viewAllRecord();
                for(Student all:al) System.out.println(all);
                break;
                
            case 5:
                System.out.println("Option 5");
                System.out.println("Enter ID you want to update:");
                int id = s.nextInt();
                System.out.println("Enter name you want to change:");
                String name = s.next();
                updateRecord(id, name);
                break;
                
            case 6:
                System.out.println("Option 6");
                System.out.println("Enter ID you want to delete");
                id = s.nextInt();
                deleteRecord(id);
                break;
                
            default: 
                System.out.println("Try the choices next time, K?");
                break;
        }
    }
    
    
    private static Student inputData(){
                int id = 0;
                String name;
                System.out.println("ID: ");
                id = s.nextInt();
                System.out.println("NAME: ");
                name = s.next();
                st.setId(id);
                st.setName(name);
                return st;
    }
    
    
    public static Connection con = null;
    public Connection getCon() throws ClassNotFoundException, SQLException
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
            return con;
        }
    
    
    public void insert(Student s) throws SQLException {
        String query = "insert into batch4 values(?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setInt(1, s.getId());
        ps.setString(2, s.getName());
        ps.execute();
        
    }
    
    
    public void insertMulti(ArrayList<Student> al) throws SQLException{
        
//        char ch = 0;
//        int i = 0;
//        int size = al.size();
 //       String query = ("insert values into batch4(?,?)");
            
//            while(size<0)
//            {     
//                PreparedStatement ps = DBOP.con.prepareStatement(query);
//
//                ps.setInt(1, al.get(1).getId());
//                ps.setString(2, al.get(1).getName());
//                ps.addBatch(query);
//                i++;
//                size--;
//            }

            Statement stt = con.createStatement();
            
            for(Student obj:al)
            {
                stt.execute("insert into batch4 values ("+obj.getId()+",'"+obj.getName()+"')");
            }
            System.out.println("All record inserted");
}
    
    
    public Student viewARecord(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("select * from batch4 where id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();    //Select should be used with executeQuery
         rs.next();                          //ResultSet is like a table to store data from database
        int id1 = rs.getInt("id");           //get id from database current record
        String name1 = rs.getString("name"); //get name
       
        
        Student obj = new Student();
        obj.setId(id1);
        obj.setName(name1);
        
        return obj;
    }
    
    
    
    public ArrayList<Student> viewAllRecord() throws SQLException {
        ArrayList<Student> al = new ArrayList();
        Statement stt = con.createStatement();
        ResultSet rs = stt.executeQuery("select * from batch4");
        while(rs.next())
        {
            Student obj = new Student();
            obj.setId(rs.getInt("id"));
            obj.setName(rs.getString("name"));
            al.add(obj);
        }    
        return al;
    }
    
    
    public void updateRecord(int id, String name) throws SQLException {
        PreparedStatement ps = con.prepareStatement("update batch4 set name=? where id=?");
        ps.setString(1, name);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Updated Successfully");
    }
    
    
    public void deleteRecord(int id) throws SQLException{
        PreparedStatement ps = con.prepareStatement("delete from batch4 where id = ?");
        ps.setInt(1, id);
        ps.execute();
    }
}

    
    
    
    
    
    

    
    
    


   
    
    
    
    
   
    

   

    


