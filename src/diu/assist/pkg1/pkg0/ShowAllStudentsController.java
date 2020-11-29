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
public class ShowAllStudentsController implements Initializable {



    public ShowAllStudentsController() {
    }

    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Integer> slnoColl;
    @FXML
    private TableColumn<Student, String> idColl;
    @FXML
    private TableColumn<Student, String> batchColl;
    @FXML
    private TableColumn<Student, String> nameColl;
    @FXML
    private TableColumn<Student, String> mobileColl;
    @FXML
    private TableColumn<Student, String> emailColl;
    @FXML
    private TableColumn<Student, String> sectionColl;
    @FXML
    private TableColumn<Student, String> departmentColl;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        studentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        AddStudentLayoutController.stdList.clear();

        SDatabaseAction sdbAction = new SDatabaseAction();
        try {
            AddStudentLayoutController.stdList = sdbAction.getAllStudents();
        } catch (SQLException ex) {
            Logger.getLogger(ShowAllStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        slnoColl.setCellValueFactory(new PropertyValueFactory<Student, Integer>("slno"));
        idColl.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        batchColl.setCellValueFactory(new PropertyValueFactory<Student, String>("batch"));
        nameColl.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        mobileColl.setCellValueFactory(new PropertyValueFactory<Student, String>("mobile"));
        emailColl.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        sectionColl.setCellValueFactory(new PropertyValueFactory<Student, String>("section"));
        departmentColl.setCellValueFactory(new PropertyValueFactory<Student, String>("department"));

        studentTable.setItems(AddStudentLayoutController.stdList);
        
    }

    @FXML
    private void deleteRecords(ActionEvent event) throws SQLException {
        try{
        ObservableList<Student> selectedStudents = FXCollections.observableArrayList();
        selectedStudents = studentTable.getSelectionModel().getSelectedItems();

        SDatabaseAction sdbAction = new SDatabaseAction();
        sdbAction.deletStudents(selectedStudents);
        AddStudentLayoutController.stdList.removeAll(selectedStudents);
          }catch(EnumConstantNotPresentException w){
            
        }

    }


}
