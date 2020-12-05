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
public class ShowAllTeachersController implements Initializable {
    
    public static Teacher teacher1;
    public static Stage stage4;

    
    public ShowAllTeachersController() {
    }
    @FXML
    private TextField tsearchField;
    @FXML
    private Text searchresultlable;
    @FXML
    private Label teachercount;
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
        searchresultlable.setText("");
        
        TDatabaseAction tdbAction = new TDatabaseAction();
        
        try {
            AddTeacherLayoutController.teachList = tdbAction.getAllTeachers();
        } catch (SQLException ex) {
            Logger.getLogger(ShowAllTeachersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        teachercount.setText(" Total Techers : "+AddTeacherLayoutController.teachList.size());
        teachercount.setAlignment(Pos.CENTER);
        
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
    
    //delete button action
    @FXML
    private void tdeleteBtn(ActionEvent event) throws SQLException {
        try {
            ObservableList<Teacher> selectedTeachers = FXCollections.observableArrayList();
            selectedTeachers = teacherTable.getSelectionModel().getSelectedItems();
            if(selectedTeachers==null){
                return;
            }
            TDatabaseAction tdbAction = new TDatabaseAction();
            tdbAction.deletTeachers(selectedTeachers);
           if( AddTeacherLayoutController.teachList.removeAll(selectedTeachers)){
                      searchresultlable.setText("Data Deleted Successfully");
           }
        } catch (SQLException e) {
            searchresultlable.setText("Sorry Cannot Delete Those Data");
        }
    }
    
    //search button action
    @FXML
    private void searchBtn(ActionEvent event) {
        String id = tsearchField.getText();
        if (id.equals("")) {
            searchresultlable.setText("");
            return;
        }
        ObservableList<Teacher> teachers = AddTeacherLayoutController.teachList;
        for (Teacher teach : teachers) {
            if (teach.getTid().contains(id)) {
                searchresultlable.setText(teach.toString());
                break;
            } else {
                searchresultlable.setText("Sorry Data Not Found");
            }
        }
    }

    //update button action
    @FXML
    private void tupdateRecord(ActionEvent event) throws IOException {
        teacherTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        teacher1 = teacherTable.getSelectionModel().getSelectedItem();
        if(teacher1==null){
            return ;
        }
        try{
            Parent pane4 = FXMLLoader.load(getClass().getResource("UpdateteacherLayout.fxml"));
            Scene scene4 = new Scene(pane4);
            Image ico4 = new Image("/icons/mainicon.png");
            stage4 = new Stage();
            stage4.setScene(scene4);
            stage4.setTitle("DIU Assist v1.5");
            stage4.getIcons().add(ico4);
            stage4.resizableProperty().set(false);
            stage4.show();
        }catch(IOException e){
        }
    }
    
}
