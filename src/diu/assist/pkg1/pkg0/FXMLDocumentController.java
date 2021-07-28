/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/************************imports**********************/
package diu.assist.pkg1.pkg0;
import static diu.assist.pkg1.pkg0.DIUAssist10.stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class FXMLDocumentController implements Initializable {

    public static Stage stage1 = new Stage();

    static String mail;

    @FXML
    private TextField emailField;

    @FXML
    private Label notificationLable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        notificationLable.setText("");
        emailField.clear();
    }

    
    //submit button action
    @FXML
    private void submitBtn(ActionEvent event) throws IOException {
        notificationLable.setText("");
        String substr1 = "@diu.edu.bd";
        //String substr2 = "bd";
        String substr3 = "@daffodilvarsity.edu.bd";
        mail = emailField.getText();

        String toLowerCase = mail.toLowerCase();
        if ("".equals(mail)) {
            return;
        }
        if (isEmailValid(mail) && (toLowerCase.contains(substr1) || toLowerCase.contains(substr3))) {
            emailField.setText("---Login Sucessfull!---");
            emailField.clear();
            stage.close();
            try {
                Parent pane = FXMLLoader.load(getClass().getResource("MainStage1.fxml"));
                Scene scene = new Scene(pane);
                Image ico = new Image("/icons/mainicon.png");
                stage1.setScene(scene);
                stage1.setTitle("DIU Assist v1.5");
                stage1.getIcons().add(ico);
                stage1.resizableProperty().set(false);
                stage1.show();
            } catch (IOException e) {
                System.out.println("Problem on FxmlController");
            }
        } else {
            notificationLable.setText("Invalid Mail, Try Again..");
        }
    }
    
    //email pattern check
    public static boolean isEmailValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 

//abdullah1513426@diu.edu.bd
}
