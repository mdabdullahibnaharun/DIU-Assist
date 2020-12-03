/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.assist.pkg1.pkg0;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AddStudentLayoutController implements Initializable {


    public AddStudentLayoutController() {
    }
    

    public static ObservableList<Student> stdList = FXCollections.observableArrayList();
    @FXML
    private TextField slnoField;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField mobileField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField sectionField;
    @FXML
    private TextArea departmentField;
    @FXML
    private Label notification;
    @FXML
    private TextField batchField;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SDatabaseAction sdbAction = new SDatabaseAction();
        try {
            stdList = sdbAction.getAllStudents();
        } catch (SQLException ex) {
            Logger.getLogger(AddStudentLayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void slFieldAction(KeyEvent event) {
        notification.setText("");
        String slno = slnoField.getText();
        if (slno.equals("")) {
            return;
        }
        for (Student std : stdList) {
            if (std.getSlno() == Integer.parseInt(slno)) {
                notification.setText("This SL no is already exist!! Please Try Another");
                break;
            }
        }

    }

    @FXML
    private void reset(ActionEvent event) {
        slnoField.clear();
        idField.clear();
        batchField.clear();
        nameField.clear();
        mobileField.clear();
        emailField.clear();
        sectionField.clear();
        departmentField.clear();
        notification.setText("");
    }

    @FXML
    private void save(ActionEvent event) throws SQLException{
           
        if(slnoField.getText().equals("")){
            return;
        }
        
        int slno = Integer.parseInt(slnoField.getText());
        String id = idField.getText();
        String batch = batchField.getText();
        String name = nameField.getText();
        String mobile = mobileField.getText();
        String email = emailField.getText();
        String section = sectionField.getText();
        String department = departmentField.getText();

        if (name.equals("") || batch.equals("") || id.equals("")) {
            notification.setText("Please Enter NAME , Id & BATCH");
            return;
        }
        
        for (Student std : stdList) {
            if (std.getId().equals(id)) {
                notification.setText("This ID no is already exist!! Please Try Another");
                return;
            }
        }

        Student std = new Student(slno, id, batch, name, mobile, email, section, department);
        stdList.add(std);

        try {
            SDatabaseAction dbAction = new SDatabaseAction();
            String r = dbAction.insertStudent(std);
            idField.clear();
            slnoField.clear();
            batchField.clear();
            nameField.clear();
            mobileField.clear();
            emailField.clear();
            sectionField.clear();
            departmentField.clear();
            notification.setText(r);
        } catch (SQLException e) {
            notification.setText("Cannot insert To DBMS");
            //e.printStackTrace();
        }
    }

    @FXML
    private void saveBtn(MouseEvent event) throws SQLException{
              if(slnoField.getText().equals("")){
            return;
        }
        
        int slno = Integer.parseInt(slnoField.getText());
        String id = idField.getText();
        String batch = batchField.getText();
        String name = nameField.getText();
        String mobile = mobileField.getText();
        String email = emailField.getText();
        String section = sectionField.getText();
        String department = departmentField.getText();

        if (name.equals("") && batch.equals("")&& id.equals("")) {
            notification.setText("Please Enter NAME , Id & BATCH");
            return;
        }
        
        for (Student std : stdList) {
            if (std.getId().equals(id)) {
                notification.setText("This ID no is already exist!! Please Try Another");
                return;
            }
        }

        Student std = new Student(slno, id, batch, name, mobile, email, section, department);
        stdList.add(std);

        try {
            SDatabaseAction dbAction = new SDatabaseAction();
            String r = dbAction.insertStudent(std);
            idField.clear();
            slnoField.clear();
            batchField.clear();
            nameField.clear();
            mobileField.clear();
            emailField.clear();
            sectionField.clear();
            departmentField.clear();
            notification.setText(r);
        } catch (SQLException e) {
            notification.setText("Cannot insert To Database");
            //e.printStackTrace();
        }
    }
}
