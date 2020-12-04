/**.................................Bismillahir-Rahamanirahim..................................**/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.assist.pkg1.pkg0;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Dell
 * 
 */

/**
*(c) 2020 Team : Fantastic 4
*[1]Md.Mahfuzur Rahman      || Id:193-15-13416 ||
*[2]Md.Abdullah Ibna Harun  || Id:193-15-13426 ||
*[3]Md.Mahade Hassan Forhad || Id:193-15-13355 ||
*[4]Md.Abidur Rahman Khan   || Id:193-15-13374 ||
**/

public class DIUAssist10 extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        
        DIUAssist10.stage = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("DIU Assist");
        Image img = new Image("/icons/mainicon.png");
        stage.getIcons().add(img);
        stage.setScene(scene);
        stage.resizableProperty().set(false);
        stage.show();

        try{
        FXMLDocumentController.stage1.setOnCloseRequest((WindowEvent e) -> {
                FXMLDocumentController.stage1.close();
                if (MainStage1Controller.clock.isAlive()) {
                    MainStage1Controller.clock.stop();
                }
                WebviewprojectController.webengine.load("");
                System.exit(0);
        });
        }catch(EnumConstantNotPresentException e){
            
        }
        
        try {
            stage.setOnCloseRequest((WindowEvent e) -> {
                stage.close();
                System.exit(0);
            });
        } catch (Exception e) {
        }
                
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
