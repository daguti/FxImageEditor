/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fximageeditor.image.utilities;

import fximageeditor.controller.FXMLImageEditorController;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ESA10969
 */
public class ContrastUtility {
    
    public static String contrast(String sign, File fil, String ext, float bright, float contrast) {
        //Variable definition
        BufferedImage bufImg;
        RescaleOp op;

        try {
            bufImg = ImageIO.read(fil);
            if(sign.equals("+")) {
                contrast += 0.01;
            } else {
                contrast -= 0.01;
            }
            
            op = new RescaleOp(contrast, bright, null);
            bufImg = op.filter(bufImg, bufImg);
            
            ImageIO.write(bufImg, ext, fil);
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLImageEditorController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return Float.toString(contrast);
    }
}
