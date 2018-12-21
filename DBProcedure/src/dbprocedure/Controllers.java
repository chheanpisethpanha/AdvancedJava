package dbprocedure;

import java.util.Scanner;

public class Controllers implements Interface{
    Scanner s = new Scanner(System.in);
    int id;
    String name;
    String gender;
    String province;
    
    @Override
    public Batch4 insertRecord(){
        Batch4 b4 = new Batch4();
        System.out.println("Enter id: ");
        id = s.nextInt();
        System.out.println("Enter name: ");
        name = s.next();
        System.out.println("Enter gender:");
        gender = s.next();
        System.out.println("Enter province: ");
        province = s.next();
        
        b4.setId(id);
        b4.setName(name);
        b4.setGender(gender);
        b4.setProvince(province);
        
        return b4;
    }
}
