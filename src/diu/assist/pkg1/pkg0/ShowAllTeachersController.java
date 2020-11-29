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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ShowAllTeachersController implements Initializable {

    public ShowAllTeachersController() {
    }

    @FXML
    private TableView<Teacher> teacherTable;
    @FXML
    private TableColumn<Teacher, Integer> slnoColl;
    @FXML
    private TableColumn<Teacher, String> idColl;
    @FXML
    private TableColumn<Teacher, String> tiColl;
    @FXML
    private TableColumn<Teacher, String> nameColl;
    @FXML
    private TableColumn<Teacher, String> mobileColl;
    @FXML
    private TableColumn<Teacher, String> emailCOll;
    @FXML
    private TableColumn<Teacher, String> coursecodeColl;
    @FXML
    private TableColumn<Teacher, String> coursenameColl;
    @FXML
    private TableColumn<Teacher, String> departmentColl;
    @FXML
    private TableColumn<Teacher, String> facultyColl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        teacherTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        AddTeacherLayoutController.teachList.clear();

        TDatabaseAction tdbAction = new TDatabaseAction();

        try {
            AddTeacherLayoutController.teachList = tdbAction.getAllTeachers();
        } catch (SQLException ex) {
            Logger.getLogger(ShowAllTeachersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        slnoColl.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("tslno"));
        idColl.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tid"));
        tiColl.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tteacherinitial"));
        nameColl.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tname"));
        mobileColl.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tmobile"));
        emailCOll.setCellValueFactory(new PropertyValueFactory<Teacher, String>("temail"));
        coursecodeColl.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tcoursecode"));
        coursenameColl.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tcoursename"));
        departmentColl.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tdepartment"));
        facultyColl.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tfaculty"));

        teacherTable.setItems(AddTeacherLayoutController.teachList);

    }

    @FXML
    private void tdeleteBtn(ActionEvent event) throws SQLException {
        try{
        ObservableList<Teacher> selectedTeachers = FXCollections.observableArrayList();
        selectedTeachers = teacherTable.getSelectionModel().getSelectedItems();

        TDatabaseAction tdbAction = new TDatabaseAction();
        tdbAction.deletTeachers(selectedTeachers);
        AddTeacherLayoutController.teachList.removeAll(selectedTeachers);
          }catch(EnumConstantNotPresentException w){
            
        }
    }

}
