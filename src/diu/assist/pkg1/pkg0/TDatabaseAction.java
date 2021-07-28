/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.assist.pkg1.pkg0;

//imports
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
public class TDatabaseAction implements Initializable{
    
    //constructor    
    public TDatabaseAction(){
        
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //get connection from database
    public Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/diuassist_dbms","root","");
        Statement statement = conn.createStatement();
        statement.close();
        return conn;
    }
    
    //get teachers data from database
    public ObservableList<Teacher> getAllTeachers() throws SQLException{
        ObservableList<Teacher> teachList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        try (Statement statement = conn.createStatement()) {
            String query = "select * from teacher";
            
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                int tslno = rs.getInt("tslno");
                String tid = rs.getString("tid");
                String tteacherinitial = rs.getString("tteacherinitial");
                String tname = rs.getString("tname");
                String tmobile = rs.getString("tmobile");
                String temail = rs.getString("temail");
                String tcoursecode = rs.getString("tcoursecode");
                String tcoursename = rs.getString("tcoursename");
                String tdepartment = rs.getString("tdepartment");
                String tfaculty = rs.getString("tfaculty");
                
                Teacher teacher = new Teacher(tslno, tid, tteacherinitial, tname, tmobile, temail, tcoursecode, tcoursename, tdepartment, tfaculty);
                teachList.add(teacher);
            }
        }
        return teachList;
    }
    
    //insert teachers data in database
    public String insertTeacher(Teacher teacher) throws SQLException{
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "insert into teacher "+"values("+teacher.getTslno()+",'"+teacher.getTid()+"','"+teacher.getTteacherinitial()+"','"+teacher.getTname()+"','"+teacher.getTmobile()+"','"+teacher.getTemail()+"','"+teacher.getTcoursecode()+"','"+teacher.getTcoursename()+"','"+teacher.getTdepartment()+"','"+teacher.getTfaculty()+"')" ;
        
        if(statement.executeUpdate(query)>0){
            statement.close();
            return "Teaher added Successfully";
        }
        else{
            statement.close();
            return "Failed";
        }
    }
    
    //delete teachers data in database
    void deletTeachers(ObservableList<Teacher> selectedteachers) throws SQLException{
        Connection conn = getConnection();
        try (Statement statement = conn.createStatement()) {
            for(Teacher teachers : selectedteachers){
                String query = "delete from teacher where tslno = " +teachers.getTslno();
                int executeUpade = statement.executeUpdate(query);
            }
        }
    }
    
    //update teachers data in database
    public void updateTeacher(Teacher teach)throws SQLException{
        Teacher teacher = teach;
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        try{
            String query  = " UPDATE teacher SET tid = '"+teacher.getTid()+"', tteacherinitial = '"+teacher.getTteacherinitial()+"', tname = '"+teacher.getTname()+"', tmobile = '"+teacher.getTmobile()+"', temail = '"+teacher.getTemail()+"', tcoursecode = '"+teacher.getTcoursecode()+"', tcoursename ='"+teacher.getTcoursename()+"', tdepartment = '"+teacher.getTdepartment()+"', tfaculty = '"+teacher.getTfaculty()+"' WHERE tslno = "+teacher.getTslno()+";";
            statement.executeUpdate(query);
            statement.close();
        }catch(SQLException e){
            
        }
    }


}
