package dbprocesstest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DBProcessInterface {
    abstract public Connection getCon() throws ClassNotFoundException, SQLException;
    abstract public int userChoice();
    abstract public void insert(Batch4 b4) throws SQLException;
    abstract public void insertMultiple(ArrayList<Batch4> list) throws SQLException;
    abstract public Batch4 inputData();
    abstract public int inputId();
    abstract public InsertUpdate insertUpdate();
    abstract public void DeleteOneRecord(int id) throws SQLException;
    abstract public void printAllRecord() throws SQLException;
    abstract public void updateOneRecord(InsertUpdate iu) throws SQLException;
    abstract public ArrayList<Batch4> viewAllRecord() throws SQLException;
    abstract public Batch4 viewOneRecord(int id) throws SQLException;
    abstract public void operateChoice() throws SQLException;
}
