/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.assist.pkg1.pkg0;

//imports
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ShowAllStudentsController implements Initializable {
    public static Student student1;
    public static  Stage stage3;

    public ShowAllStudentsController() {
    }
    @FXML
    private Label studentcount;
    @FXML
    private TextField ssearchField;
    @FXML
    private Text searchresultlable;
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
        searchresultlable.setText("");
        studentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        AddStudentLayoutController.stdList.clear();

        SDatabaseAction sdbAction = new SDatabaseAction();
        try {
            AddStudentLayoutController.stdList = sdbAction.getAllStudents();
        } catch (SQLException ex) {
            Logger.getLogger(ShowAllStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        studentcount.setText(" Total Students : "+AddStudentLayoutController.stdList.size());
        studentcount.setAlignment(Pos.CENTER);

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

    //delete button action
    @FXML
    private void deleteRecords(ActionEvent event) throws SQLException {
        try {
            ObservableList<Student> selectedStudents = FXCollections.observableArrayList();
            selectedStudents = studentTable.getSelectionModel().getSelectedItems();

            SDatabaseAction sdbAction = new SDatabaseAction();
            sdbAction.deletStudents(selectedStudents);
            if (AddStudentLayoutController.stdList.removeAll(selectedStudents)) {
                searchresultlable.setText("Data Deleted Successfully");
            }
        } catch (SQLException e) {
            searchresultlable.setText("Sorry Cannot Delete Those Data");
        }

    }

    //search button action
    @FXML
    private void searchBtn(ActionEvent event) {
        String id = ssearchField.getText();
        if (id.equals("")) {
            searchresultlable.setText("");
            return;
        }
        ObservableList<Student> Students = AddStudentLayoutController.stdList;
        for (Student std : Students) {
            if (std.getId().contains(id)) {
                searchresultlable.setText(std.toString());
                break;
            } else {
                searchresultlable.setText("Sorry Data Not Found");
            }
        }
    }

    //update button action
    @FXML
    private void updateRecord(ActionEvent event) {
        studentTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        student1 = studentTable.getSelectionModel().getSelectedItem();
        if(student1 == null){
            return;
        }
        try {
            Parent pane3 = FXMLLoader.load(getClass().getResource("UpdateStudentLayout.fxml"));
            Scene scene3 = new Scene(pane3);
            Image ico3 = new Image("/icons/mainicon.png");
            stage3 = new Stage() ;
            stage3.setScene(scene3);
            stage3.setTitle("DIU Assist v1.5");
            stage3.getIcons().add(ico3);
            stage3.resizableProperty().set(false);
            stage3.show();
        } catch (IOException e) {
        }
    }

}
