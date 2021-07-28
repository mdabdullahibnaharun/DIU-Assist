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
public class UpdateteacherLayoutController implements Initializable {

    @FXML
    private Label notification;
    @FXML
    private TextField tslnoField;
    @FXML
    private TextField tidField;
    @FXML
    private TextField tnameField;
    @FXML
    private TextField tmobileField;
    @FXML
    private TextField temailField;
    @FXML
    private TextField tcoursecodeField;
    @FXML
    private TextArea tdepartmentField;
    @FXML
    private TextField tteacherinitialField;
    @FXML
    private TextField tcoursenameField;
    @FXML
    private TextField tfacultyField;

    Teacher teacher2;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        notification.setText("");
        teacher2 = ShowAllTeachersController.teacher1;
        int y = teacher2.getTslno();
        tslnoField.setText("" + y);
        tslnoField.setEditable(false);
        tnameField.setText(teacher2.getTname());
        tidField.setText(teacher2.getTid());
        tmobileField.setText(teacher2.getTmobile());
        temailField.setText(teacher2.getTemail());
        tcoursecodeField.setText(teacher2.getTcoursecode());
        tcoursenameField.setText(teacher2.getTcoursename());
        tdepartmentField.setText(teacher2.getTdepartment());
        tteacherinitialField.setText(teacher2.getTteacherinitial());
        tfacultyField.setText(teacher2.getTfaculty());
    }

    //reset button action
    @FXML
    private void treset(ActionEvent event) {
        tslnoField.clear();
        tnameField.clear();
        tidField.clear();
        tmobileField.clear();
        temailField.clear();
        tcoursecodeField.clear();
        tcoursenameField.clear();
        tdepartmentField.clear();
        tfacultyField.clear();
        tteacherinitialField.clear();
        notification.setText("");
    }

    //update button action
    @FXML
    private void tupdateRecord(ActionEvent event) throws SQLException {

        try {
            TDatabaseAction tdbAction = new TDatabaseAction();
            if (tslnoField.getText().equals("")) {
                notification.setText("Please Enter Serial. No For Update..");
                return;
            }

            int tslno = Integer.parseInt(tslnoField.getText());
            String tid = tidField.getText();
            String tteacherinitial = tteacherinitialField.getText();
            String tname = tnameField.getText();
            String tmobile = tmobileField.getText();
            String temail = temailField.getText();
            String tcoursecode = tcoursecodeField.getText();
            String tcoursename = tcoursenameField.getText();
            String tdepartment = tdepartmentField.getText();
            String tfaculty = tfacultyField.getText();

            Teacher teach = new Teacher(tslno, tid, tteacherinitial, tname, tmobile, temail, tcoursecode, tcoursename, tdepartment, tfaculty);
            tdbAction.updateTeacher(teach);

            tslnoField.clear();
            tnameField.clear();
            tidField.clear();
            tmobileField.clear();
            temailField.clear();
            tcoursecodeField.clear();
            tcoursenameField.clear();
            tdepartmentField.clear();
            tfacultyField.clear();
            tteacherinitialField.clear();
            notification.setText("");
            notification.setText("Data Updated Successfully...");
        

        } catch (NumberFormatException e) {
            notification.setText("Sorry Can't Update Data to DataBase");
        }
    }

}
