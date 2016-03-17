/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fximageeditor.image.utilities;

import com.jhlabs.image.MotionBlurFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author ESa10969
 */
public class FiltersUtility {
    public static void filterImage(File fil, String ext) {
        try {
            MotionBlurFilter blurFilter = new MotionBlurFilter();
            blurFilter.setAngle(0.4f);
            BufferedImage destImg = ImageIO.read(fil);
            blurFilter.filter(RgbUtility.origImg , destImg);
            ImageIO.write(destImg, ext, fil);
        } catch (IOException ex) {
            Logger.getLogger(FiltersUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
