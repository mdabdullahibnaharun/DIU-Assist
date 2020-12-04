/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.assist.pkg1.pkg0;

//imports 

import static diu.assist.pkg1.pkg0.FXMLDocumentController.stage1;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class MainStage1Controller extends Thread implements Initializable {

    public MainStage1Controller() {
    }

    public static Thread clock;
    @FXML
    private Text userMail;
    @FXML
    private BorderPane mainContant;
    @FXML
    private Text dateField;
    @FXML
    private Text timeField;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userMail.setText(FXMLDocumentController.mail);
        try {
            timedate(true);
            Parent child = FXMLLoader.load(getClass().getResource("Webviewproject.fxml"));
            mainContant.setCenter(child);
        } catch (IOException ex) {
            Logger.getLogger(MainStage1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            stage1.setOnCloseRequest((WindowEvent e) -> {
                stage1.close();
                WebviewprojectController.webengine.load("");

                if (!clock.isAlive()) {
                    System.exit(0);
                    return;
                } else {
                    clock.stop();
                    System.exit(0);
                }
                System.exit(0);
            });
        } catch (Exception e) {
        }

    }
    
    //aboutus button action
    @FXML
    private void aboutUs(ActionEvent event) {
        try {
            Parent child = FXMLLoader.load(getClass().getResource("Webviewproject.fxml"));
            String url = "https://sites.google.com/diu.edu.bd/fantasticfour/about-fantastic-four?authuser=0";
            WebviewprojectController.webengine.load(url);
            mainContant.setCenter(child);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //quick assist button action
    @FXML
    private void quickAssist(ActionEvent event) throws IOException {
        try {
            Parent child = FXMLLoader.load(getClass().getResource("Webviewproject.fxml"));
            mainContant.setCenter(child);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //add student action
    @FXML
    private void addStdData(ActionEvent event) {
        try {
            Parent child = FXMLLoader.load(getClass().getResource("AddStudentLayout.fxml"));
            mainContant.setCenter(child);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //add teacher action
    @FXML
    private void addTecData(ActionEvent event) {
        try {
            Parent child = FXMLLoader.load(getClass().getResource("AddTeacherLayout.fxml"));
            mainContant.setCenter(child);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //show students action
    @FXML
    private void showSudents(ActionEvent event) {
        try {
            Parent child = FXMLLoader.load(getClass().getResource("ShowAllStudents.fxml"));
            mainContant.setCenter(child);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //show teachers acton
    @FXML
    private void showTeachers(ActionEvent event) {
        try {
            Parent child = FXMLLoader.load(getClass().getResource("ShowAllTeachers.fxml"));
            mainContant.setCenter(child);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //logout action
    @FXML
    private void logout(ActionEvent event) {
        DIUAssist10.stage.show();
        FXMLDocumentController.stage1.close();

        if (clock.isAlive()) {
            clock.stop();
        }
        if (ShowAllStudentsController.stage3 != null) {
            ShowAllStudentsController.stage3.close();
        }
        if (ShowAllTeachersController.stage4 != null) {
            ShowAllTeachersController.stage4.close();
        }

    }

    //live time & date by using thread handeling
    private void timedate(boolean valu) {
        if (valu) {
            clock = new Thread() {
                @Override
                public void run() {
                    while (!FXMLDocumentController.stage1.isShowing()) {
                        while (!FXMLDocumentController.stage1.hasProperties()) {
                            Date thisDate = new Date();
                            SimpleDateFormat dateFrom = new SimpleDateFormat("dd/MM/y");
                            dateField.setText(dateFrom.format(thisDate));
                            Date thisTime = new Date();
                            SimpleDateFormat timeFrom = new SimpleDateFormat("hh:mm a");
                            timeField.setText(timeFrom.format(thisTime));
                            //sleep(1000);
                        }
                    }
                }
            };
            clock.start();
        }
    }

}
