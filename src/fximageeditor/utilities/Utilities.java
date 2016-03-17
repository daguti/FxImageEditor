/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fximageeditor.utilities;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ESA10969
 */
public class Utilities {
    public static void setImageOnDrawer(String path, ImageView imageContainer) {
        //Variable definition
        Image img;
        
        img = new Image("file:////"+ path);
        imageContainer.setImage(img);
        imageContainer.setFitWidth(225);
        imageContainer.setFitHeight(200);
        imageContainer.setPreserveRatio(false);
        imageContainer.setSmooth(true);
        imageContainer.setCache(true);
    }
    
    public static String getTempPath(TextField browseBar) {
        //Variable definition
        String tmpPath;
        
        tmpPath = browseBar.getText();
        tmpPath = tmpPath.substring(0, tmpPath.lastIndexOf(".")) + "TEMP"
                  + tmpPath.substring(tmpPath.lastIndexOf("."));
        
        return tmpPath;
    }
    
    public static String getImageExtension(TextField browseBar) {
        //Variable definition
        String ext;
        
        ext = browseBar.getText();
        ext = ext.substring(ext.lastIndexOf(".") + 1);
        
        return ext;
    }
}
