/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fximageeditor.controller;

import fximageeditor.image.utilities.BrightUtility;
import fximageeditor.image.utilities.ContrastUtility;
import fximageeditor.image.utilities.FiltersUtility;
import fximageeditor.image.utilities.RgbUtility;
import fximageeditor.image.utilities.WhiteBlackUtility;
import fximageeditor.utilities.Utilities;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ESA10969
 */
public class FXMLImageEditorController extends Application implements Initializable {
    
    private File writeRead = null;
    
    @FXML
    private Button browseButton, cntrstUp, cntrstDown;
    @FXML
    private TextField browseBar, brightText,contrastText, redText, greenText, blueText;
    @FXML
    private ImageView imageContainer;
    
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void openFileSearch() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file;
        
        fileChooser.setTitle("Open Resource File");
        
        file = fileChooser.showOpenDialog(new Stage());
        
        if(file != null) {
            Utilities.setImageOnDrawer(file.getPath(),imageContainer);
            browseBar.setText(file.getPath());
            writeRead = new File(Utilities.getTempPath(browseBar));
            writeRead.createNewFile();
            BufferedImage img = ImageIO.read(file);
            RgbUtility.origImg = img;
            ImageIO.write(img, Utilities.getImageExtension(browseBar), writeRead);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLImageEditor.fxml"));
        primaryStage.setWidth(500);
        primaryStage.setHeight(450);
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     public static void main(String[] args) {
        Application.launch(args);
    }
     
    @FXML
    private void moreBright() {
        brightText.setText(BrightUtility.bright("+", writeRead, Utilities.getImageExtension(browseBar), 
                                                      Float.valueOf(brightText.getText()),
                                                      Float.valueOf(contrastText.getText())));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);
    }
    @FXML
    private void whiteBlack() {
        WhiteBlackUtility.whiteBlackImage(writeRead, Utilities.getImageExtension(browseBar));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);
    }
    @FXML
    private void filter1() {
        FiltersUtility.filterImage(writeRead, Utilities.getImageExtension(browseBar));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);
    }
    @FXML
    private void lessBright() {
        brightText.setText(BrightUtility.bright("-",  writeRead,
                                                      Utilities.getImageExtension(browseBar), 
                                                      Float.valueOf(brightText.getText()),
                                                      Float.valueOf(contrastText.getText())));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);
    }
    
    @FXML
    private void moreRed() {
        redText.setText(RgbUtility.changeRgb("+","RED", writeRead,
                                                      Utilities.getImageExtension(browseBar), 
                                                      Float.valueOf(redText.getText())));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);
    }
    @FXML
    private void lessRed() {
        redText.setText(RgbUtility.changeRgb("-","RED" , writeRead,
                                                      Utilities.getImageExtension(browseBar), 
                                                      Float.valueOf(redText.getText())));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);
    }
    @FXML
    private void moreGreen() {
        greenText.setText(RgbUtility.changeRgb("+","GREEN" , writeRead,
                                                      Utilities.getImageExtension(browseBar), 
                                                      Float.valueOf(greenText.getText())));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);
    }
    @FXML
    private void lessGreen() {
        greenText.setText(RgbUtility.changeRgb("-","GREEN" , writeRead,
                                                      Utilities.getImageExtension(browseBar), 
                                                      Float.valueOf(greenText.getText())));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);
    }
    @FXML
    private void moreBlue() {
        blueText.setText(RgbUtility.changeRgb("+","BLUE" , writeRead,
                                                      Utilities.getImageExtension(browseBar), 
                                                      Float.valueOf(blueText.getText())));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);
    }
    @FXML
    private void lessBlue() {
        blueText.setText(RgbUtility.changeRgb("-","BLUE" , writeRead,
                                                      Utilities.getImageExtension(browseBar), 
                                                      Float.valueOf(blueText.getText())));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);
    }
    
    @FXML
    private void moreContrast() {
        contrastText.setText(ContrastUtility.contrast("+", writeRead,
                                                      Utilities.getImageExtension(browseBar), Float.valueOf(brightText.getText()),
                                                      Float.valueOf(contrastText.getText())));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);
    }
    @FXML
    private void lessContrast() {
        contrastText.setText(ContrastUtility.contrast("-", writeRead,
                                                      Utilities.getImageExtension(browseBar), 
                                                      Float.valueOf(brightText.getText()),
                                                      Float.valueOf(contrastText.getText())));
        Utilities.setImageOnDrawer(Utilities.getTempPath(browseBar), imageContainer);;
    }
}
