/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.assist.pkg1.pkg0;

//imports
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

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AddTeacherLayoutController implements Initializable {

    public static ObservableList<Teacher> teachList = FXCollections.observableArrayList();
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

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TDatabaseAction tdbAction = new TDatabaseAction();
        try {
            teachList = tdbAction.getAllTeachers();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //serial no field action
    @FXML
    private void slFieldAction(KeyEvent event) {
        notification.setText("");
        String tslno = tslnoField.getText();
        if (tslno.equals("")) {
            return;
        }

        for (Teacher teach : teachList) {
            if (teach.getTslno() == Integer.parseInt(tslno)) {
                notification.setText("This SL no is already exist!! Please Try Another");
                break;
            }
            return;
        }
        
    }

    //save button action
    @FXML
    private void save(ActionEvent event) throws SQLException {
        if (tslnoField.getText().equals("")) {
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

        if (tname.equals("") || tteacherinitial.equals("") || tid.equals("") || tcoursecode.equals("")) {
            notification.setText("Please Enter Name , Id  , TI , Course Code");
            return;
        }

        for (Teacher teach : teachList) {
            if (teach.getTid().equals(tid)) {
                notification.setText("This ID no is already exist!! Please Try Another");
                return;
            }
        }

        Teacher teach = new Teacher(tslno, tid, tteacherinitial, tname, tmobile, temail, tcoursecode, tcoursename, tdepartment, tfaculty);
        teachList.add(teach);

        try {
            TDatabaseAction dbAction = new TDatabaseAction();
            String r = dbAction.insertTeacher(teach);

            tslnoField.clear();
            tidField.clear();
            tnameField.clear();
            temailField.clear();
            tcoursecodeField.clear();
            tcoursenameField.clear();
            tdepartmentField.clear();
            tmobileField.clear();
            tidField.clear();
            tteacherinitialField.clear();
            tfacultyField.clear();

            notification.setText(r);

        } catch (SQLException e) {
            notification.setText("Cannot insert To DBMS");
            //e.printStackTrace();
        }
    }

    //reset button action
    @FXML
    private void reset(ActionEvent event) {
        tslnoField.clear();
        tidField.clear();
        tnameField.clear();
        temailField.clear();
        tcoursecodeField.clear();
        tcoursenameField.clear();
        tdepartmentField.clear();
        tmobileField.clear();
        tidField.clear();
        tteacherinitialField.clear();
        tfacultyField.clear();
    }

}
