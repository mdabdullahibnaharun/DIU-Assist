/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.assist.pkg1.pkg0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import static diu.assist.pkg1.pkg0.WebviewprojectController.webengine;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.web.WebHistory;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class WebviewprojectController implements Initializable {

    @FXML
    private Button reload;
    @FXML
    private Button facebook;

    public static WebEngine webengine;
    @FXML
    private WebView webview;
    @FXML
    private Button linkedin;
    @FXML
    private Button instagram;
    @FXML
    private Button youtube;
    @FXML
    private Button twitter;
    @FXML
    private TextField searchField;

    public static WebHistory webHistory;
    @FXML
    private BorderPane webpane;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        browseNow("https://duckduckgo.com");
        searchField.clear();
    }

    public WebviewprojectController() {
    }

    @FXML
    private void reloadBtn(ActionEvent event) {
        webengine.reload();
    }

    @FXML
    private void facebookBtn(ActionEvent event) {
        String url = "https://www.facebook.com/daffodilvarsity.edu.bd/?_rdc=1&_rdr";
        browseNow(url);
    }

    @FXML
    private void linkedInBtn(ActionEvent event) {
        String url = "https://www.linkedin.com/school/daffodil-international-university/?originalSubdomain=bd";
       browseNow(url);
    }

    @FXML
    private void instagramBtn(ActionEvent event) {
        String url = "https://www.instagram.com/daffodil.university/?hl=en";
        browseNow(url);

    }

    @FXML
    private void studentportaBtn(ActionEvent event) {
        browseNow("http://studentportal.diu.edu.bd");
    }

    @FXML
    private void homeBtn(ActionEvent event) {
        browseNow("https://www.daffodilvarsity.edu.bd/");
    }

    @FXML
    private void youtubeBtn(ActionEvent event) {
        String url = "https://www.youtube.com/channel/UC9PzvD1qa4IPN4sBZ_gMeQQ";
        browseNow(url);
    }

    @FXML
    private void twitterBtn(ActionEvent event) {
        String url = "https://mobile.twitter.com/daffodilvarsity";
        browseNow(url);
    }

    @FXML
    private void blcBtn(ActionEvent event) {
        browseNow("https://elearn.daffodilvarsity.edu.bd/");
    }

    @FXML
    private void iqac(ActionEvent event) {
        browseNow("http://iqac.daffodilvarsity.edu.bd/");
    }

    @FXML
    private void hrdi(ActionEvent event) {
        browseNow("http://hrdinstitute.org/");
    }

    @FXML
    private void calender(ActionEvent event) {
        browseNow("https://daffodilvarsity.edu.bd/department/accounts");
    }

    @FXML
    private void libbrary(ActionEvent event) {
        browseNow("https://library.daffodilvarsity.edu.bd/");
    }

    @FXML
    private void hostel(ActionEvent event) {
        browseNow("https://hostel.daffodilvarsity.edu.bd/");
    }

    @FXML
    private void noticeboard(ActionEvent event) {
        browseNow("https://daffodilvarsity.edu.bd/noticeboard");
    }

    private void sbsfbd(ActionEvent event) {
        browseNow("http://ww1.sbsfbd.com/");
    }

    @FXML
    private void studentapplication(ActionEvent event) {
        browseNow("http://203.190.9.108/diu-sac/");
    }

    @FXML
    private void doierp(ActionEvent event) {
        browseNow("https://daffodilvarsity.edu.bd/article/erp");
    }

    @FXML
    private void projectintern(ActionEvent event) {
        browseNow("https://sites.google.com/daffodilvarsity.edu.bd/picsediu/home?authuser=0");
    }

    @FXML
    private void wikipedia(ActionEvent event) {
        browseNow("https://en.wikipedia.org/wiki/Daffodil_International_University");
    }

    @FXML
    private void Maps(ActionEvent event) {
        browseNow("https://www.google.com/maps/d/u/0/viewer?ie=UTF&msa=0&mid=1DA3oU1bJLKevmpUej54D9NJYOhg&ll=23.752471000000014%2C90.37793399999997&z=17");
    }

    @FXML
    private void pmiscse(ActionEvent event) {
        browseNow("https://pmiscse.daffodilvarsity.edu.bd/");

    }

    @FXML
    private void cpc(ActionEvent event) {
        browseNow("http://cpc.daffodilvarsity.edu.bd/");
    }

    @FXML
    private void gcpc(ActionEvent event) {
        browseNow("https://gcpc.daffodilvarsity.edu.bd/");
    }

    @FXML
    private void campustv(ActionEvent event) {
        browseNow("http://www.campustv.ac/");
    }

    @FXML
    private void campusradio(ActionEvent event) {
        browseNow("http://campusradio.ac/");
    }

    @FXML
    private void more(ActionEvent event) {
        browseNow("http://international.daffodilvarsity.edu.bd/index.php/events/useful-links");
    }

    @FXML
    private void backBtn(ActionEvent event) {
        try{
        webHistory.go(-1);
        }catch(EnumConstantNotPresentException w){
            
        }
    }

    @FXML
    private void forwordBtn(ActionEvent event) {
        try{
        webHistory.go(1);
          }catch(EnumConstantNotPresentException w){
            
        }
    }

    @FXML
    private void searchBtn(ActionEvent event) {
        webengine = webview.getEngine();

        String link = searchField.getText();

        if (link.equals("")) {
            return;
        } else if (link.toLowerCase().contains("https://") || link.toLowerCase().contains("https://www.")) {
            String url = link;
            if (!link.toLowerCase().contains(".com")) {
                url += ".com";
            }
            browseNow(url);
        } else if (link.toLowerCase().contains("www.") || link.toLowerCase().contains("mobile.")) {
            try {
                String url = "https://" + link;
                browseNow(url);
            } catch (Exception e) {

            }
        } else if (!(link.toLowerCase().contains("mobile.")) || !(link.toLowerCase().contains("www."))) {
            try {
                String url = "https://www.google.com/search?q=";
                browseNow(url + link);
            } catch (Exception e) {

            }
        } else {
            try {
                String url = "https://www.google.com/search?q=";
                for (String v : link.split(" ")) {
                    browseNow(url + v);
                    Thread.sleep(1000);
                }

            } catch (Exception e) {

            }
        }
        searchField.clear();
    }

    @FXML
    private void zoomoutBtn(ActionEvent event) {
        double size = 1.0;
        size = webview.getZoom() - 0.1;
        webview.setZoom(size);
    }

    @FXML
    private void zoomInBtn(ActionEvent event) {
        double size = 1.0;
        size = webview.getZoom() + 0.1;
        webview.setZoom(size);
    }

    public void addurl(String url){
        browseNow(url);
    }
    /**
     *
     * @param o
     */
    @SuppressWarnings("empty-statement")
    public void browseNow(Object o) {
        try {
           
            String url = (String) o;
            webengine = webview.getEngine();
            webengine.setUserAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
            webengine.setJavaScriptEnabled(true);
            searchField.setText(url);
            webengine.load(url);
            webHistory = webengine.getHistory();

        } catch (Exception e) {

        }
    }

}
