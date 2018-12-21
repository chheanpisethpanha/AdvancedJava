package dbprocesstest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DBOP implements DBProcessInterface {
    //DBOP: Database Operation
    private static Connection con = null; //has to be static => it will establish the connection only once
    private static Scanner s = new Scanner(System.in);
    static int id;
    static String name;
    static String gender;
    static String province;
      
//    static function to get connection
    @Override
    public Connection getCon() throws ClassNotFoundException, SQLException{
        //Load Driver
        Class.forName("com.mysql.jdbc.Driver");
        
        //Establish Connection
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
        
        return con;
    }
    
    @Override
    public int userChoice(){
        System.out.println("Please enter your desire operation number: ");
        System.out.println("1. Insert Record\n2. Insert Multiple Record\n3. View a record\n4. View all Record\n5. Update a record\n6. Delete a record");
        
        int choice = s.nextInt();
        
        return choice;
    }
    
    @Override
    public void insert(Batch4 b4) throws SQLException{
        String query = "INSERT INTO Batch4 VALUES(?,?,?,?)";
        PreparedStatement prepare_stt =  con.prepareStatement(query);
        prepare_stt.setInt(1,b4.getId());
        prepare_stt.setString(2, b4.getName());
        prepare_stt.setString(3, b4.getGender());
        prepare_stt.setString(4, b4.getProvince());
        prepare_stt.execute();
    }
    
    @Override
    public void insertMultiple(ArrayList<Batch4> list) throws SQLException{
        String query = "INSERT INTO Batch4 VALUES(?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(query);
        
        for(Batch4 obj:list)
        {
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getGender());
            ps.setString(4, obj.getProvince());
        }
        ps.execute();
        System.out.println("Data inserted...");
    }
    
    @Override
    public Batch4 inputData(){
        Batch4 b4 = new Batch4(); //DTO: Data Transfer Object, much class name and database name, it is called as model
        
        System.out.println("Enter id: ");
        id = s.nextInt();
        System.out.println("Enter name: ");
        name =  s.next();
        System.out.println("Enter gender(Male/Female): ");
        gender = s.next();
        System.out.println("Enter province: ");
        province = s.next();

        b4.setId(id);
        b4.setName(name);
        b4.setGender(gender);
        b4.setProvince(province);
        
        return b4;
    }
    
    @Override
    public int inputId(){
        System.out.println("Input ID to view the record: ");
        id = s.nextInt();
        return id;
    }
    
    @Override
    public InsertUpdate insertUpdate(){
        InsertUpdate iu = new InsertUpdate();
        System.out.println("Enter id: ");
        int id = s.nextInt();
        System.out.println("Enter new name: ");
        String newName = s.next();
        iu.setId(id);
        iu.setNewName(newName);
        return iu;
    }
    
    @Override
    public void DeleteOneRecord(int id) throws SQLException{
        String query = "DELETE FROM Batch4 WHERE id = ?;";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);
        
        System.out.println("The record is deleted...\n\nHere is the list of record after deleted: \n");
        printAllRecord();
    }
    
    @Override
    public void printAllRecord() throws SQLException{
        ArrayList data = viewAllRecord(); //View all record after delete
        for(int i=0; i<data.size();i++){
            System.out.println(data.get(i)+"\n");
        }
    }
    
    @Override
    public void updateOneRecord(InsertUpdate iu) throws SQLException{
        String query = "UPDATE Batch4 SET name = '?', gender = '?', province = '?' WHERE id = ?;";
        PreparedStatement ps = con.prepareStatement(query);
       
        ps.setString(1, iu.getNewName());
        ps.setString(2, iu.getNewGender());
        ps.setString(3, iu.getNewProvince());
        ps.setInt(4, iu.getId());
        
        ps.execute();
        System.out.println("You have updated the record that has id = "+id+"\nHere is the updated record: \n");
        printAllRecord();
    }
    
    @Override
    public ArrayList<Batch4> viewAllRecord() throws SQLException{
        ArrayList al = new ArrayList();
        String query = "SELECT * FROM batch4;";
        Statement stt = con.createStatement();
        
        ResultSet rs = stt.executeQuery(query);
        while(rs.next()){
            Batch4 b4 = new Batch4();
            id = rs.getInt("id");
            name = rs.getString("name");
            gender = rs.getString("gender");
            province = rs.getString("province");
            
            b4.setId(id);
            b4.setName(name);
            al.add(b4);
        }
        return al;
    }

    @Override
    public Batch4 viewOneRecord(int id) throws SQLException{
        Batch4 b4 = new Batch4();
        String query = "SELECT FROM batch4 WHERE id = ?;";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        id = rs.getInt("id");
        name = rs.getString("name");
        gender = rs.getString("gender");
        province = rs.getString("province");
        
        b4.setId(id);
        b4.setName(name);
        b4.setGender(gender);
        b4.setProvince(province);
        
        return b4;
    }
    
    @Override 
    public void operateChoice() throws SQLException{
        //user choice 
            switch(userChoice()){
                case 1: {
                    Batch4 b4 = new Batch4();
                    insert(b4); //insert data
                    break;
                }
                
                case 2: {
                    System.out.println("How many record do you want to insert? : ");
                    int n = s.nextInt();
                    Batch4 list[] = new Batch4[n];
                    ArrayList al = new ArrayList();

                    for(int i=0; i<list.length; i++){
                        list[i] = inputData();
                        al.add(list[i]);
                    }
                   insertMultiple(al); //insert multiple
                   break;
                }
                
                case 3: {
                    int id = inputId();
                    viewOneRecord(id);
                    break;
                }
                
                case 4: {
                    ArrayList data = viewAllRecord();
                    for(int i=0; i<data.size();i++){
                        System.out.println(data.get(i)+"\n");
                    }
                    break;
                }
                
                case 5: {
                    InsertUpdate iu = insertUpdate();
                    updateOneRecord(iu);
                    break;
                }                
                case 6: {
                    int id = inputId();
                    DeleteOneRecord(id);
                    break;
                }
                
                default: {
                    System.out.println("Invalid choice!");
                    break;
                }
            }
    }
}
