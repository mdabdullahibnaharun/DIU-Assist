/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.assist.pkg1.pkg0;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class UpdateStudentLayoutController implements Initializable {

    @FXML
    private Label notification;
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

    private Student student2;
    @FXML
    private TextField batchField;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOS
        notification.setText("");
        student2 = ShowAllStudentsController.student1;
        int x = student2.getSlno();
        slnoField.setText("" + x);
        slnoField.setEditable(false);
        nameField.setText(student2.getName());
        idField.setText(student2.getId());
        emailField.setText(student2.getEmail());
        mobileField.setText(student2.getMobile());
        sectionField.setText(student2.getSection());
        batchField.setText(student2.getBatch());
        departmentField.setText(student2.getDepartment());

    }

    @FXML
    private void reset(ActionEvent event) {
        slnoField.clear();
        nameField.clear();
        idField.clear();
        emailField.clear();
        mobileField.clear();
        sectionField.clear();
        batchField.clear();
        departmentField.clear();
        notification.setText("");
    }

    @FXML
    private void update(ActionEvent event) throws SQLException {

        try {
            SDatabaseAction sdbAction = new SDatabaseAction();
            if (slnoField.getText().equals("")) {
                notification.setText("Please Enter Serial. No For Update..");
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

            Student std = new Student(slno, id, batch, name, mobile, email, section, department);
            sdbAction.updateStudent(std);
            notification.setText("Data Updated Successfully...");
            slnoField.clear();
            nameField.clear();
            idField.clear();
            emailField.clear();
            mobileField.clear();
            sectionField.clear();
            batchField.clear();
            departmentField.clear();
            notification.setText("");
        } catch (NumberFormatException e) {
            notification.setText("Sorry Can't Update Data to DataBase");
        }
    }

}
