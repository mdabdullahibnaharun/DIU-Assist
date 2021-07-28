/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.assist.pkg1.pkg0;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;




/**
 *
 * @author Dell
 */
public class SDatabaseAction implements Initializable{

    //constructor
    public SDatabaseAction() {
    }
    
      @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
        
    }
    
    //get database connection method
    public Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/diuassist_dbms","root","");
        Statement statement = conn.createStatement();
        statement.close();
        return conn;

        
    }
   
    //get students from database
    public ObservableList<Student> getAllStudents() throws SQLException {

        ObservableList<Student> stdList = FXCollections.observableArrayList();

        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "select * from student";

        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {

            int slno = rs.getInt("sl");
            String id = rs.getString("id");
            String batch = rs.getString("batch");
            String name = rs.getString("name");
            String mobile = rs.getString("mobile");
            String email = rs.getString("email");
            String section = rs.getString("section");
            String department = rs.getString("department");

            Student student = new Student(slno, id, batch, name, mobile, email, section, department);
            stdList.add(student);
        }
        statement.close();
        return stdList;

    }

    //insert students data into database
    public String insertStudent(Student student) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "insert into student "+"values("+student.getSlno()+",'"+student.getId()+"','"+student.getBatch()+"','"+student.getName()+"','"+student.getMobile()+"','"+student.getEmail()+"','"+student.getSection()+"','"+student.getDepartment()+"')";

        if (statement.executeUpdate(query)>0) {
             statement.close();
            return "Student added Successfully";
        } else {
             statement.close();
            return "Failed";
        }
    }

    //delete dada from database
    public void deletStudents(ObservableList<Student> selectedStudents) throws SQLException {
        Connection conn = getConnection();
        try (Statement statement = conn.createStatement()) {
            for (Student students : selectedStudents) {
                String query = "delete from student where sl = " + students.getSlno();
                int executeUpdate = statement.executeUpdate(query);
            }
        }
    }
    
    //update data in database
    public void updateStudent(Student std) throws SQLException{
        Student student = std;
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        try{
            String query  = " UPDATE student SET id = '"+student.getId()+"', batch = '"+student.getBatch()+"', name = '"+student.getName()+"', mobile = '"+student.getMobile()+"',email = '"+student.getEmail()+"', section = '"+student.getSection()+"', department = '"+student.getDepartment()+"' WHERE sl= "+student.getSlno()+";";
            statement.executeUpdate(query);
            statement.close();
        }catch(SQLException e){
            
        }
    }

 
}
