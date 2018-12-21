package dbprocesstest;

public class InsertUpdate {
    private int id;
    private String newName;
    private int newAge;
    private String newGender;
    private String newProvince;

    public int getNewAge() {
        return newAge;
    }

    public void setNewAge(int newAge) {
        this.newAge = newAge;
    }

    public String getNewGender() {
        return newGender;
    }

    public void setNewGender(String newGender) {
        this.newGender = newGender;
    }

    public String getNewProvince() {
        return newProvince;
    }

    public void setNewProvince(String newProvince) {
        this.newProvince = newProvince;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String NewName) {
        this.newName = NewName;
    }
    
    public String toString(){
        return "You will update a record with id = " + id;
    }
}
