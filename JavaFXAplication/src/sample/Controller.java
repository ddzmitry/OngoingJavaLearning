package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Controller {
    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private GridPane gridPane;

    @FXML
    private WebView webView;

    public  void initialize(){
        button4.setEffect(new DropShadow());
    }
    @FXML
    public void handleMouseEnter(){
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }
    @FXML
    public void handleMouseExit(){
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    public void  handleClick(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text","*.txt"),
                new FileChooser.ExtensionFilter("PDF","*.pdf"),
                new FileChooser.ExtensionFilter("All","*.*")
        );

    //    File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
//        DirectoryChooser dirChooser = new DirectoryChooser();
//        File file = dirChooser.showDialog(gridPane.getScene().getWindow());
        // Get list of files
        List<File> files = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());

        if(files != null ){
            Iterator<File> iter = files.iterator();
            while (iter.hasNext()) {
                File item = iter.next();
                System.out.println(item.getPath());


            }

        } else{
            System.out.println("Chooser was canceled ");
        }
    }

    @FXML
    public void handleLinkClick(){
        // OPEN IN BROWSER
//        try {
//            Desktop.getDesktop().browse(new URI("http://wwww.javafx.com"));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();

//        }
        //OPEN IN WEB VIEW
        WebEngine engine = webView.getEngine();
        engine.load("http://www.gwars.ru");

    }

}
