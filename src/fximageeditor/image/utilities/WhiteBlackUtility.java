/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fximageeditor.image.utilities;

import java.awt.Color;
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
public class WhiteBlackUtility {
  public static void whiteBlackImage(File fil, String ext) {
    //Variable definition
    BufferedImage bufImg;
    int width;
    int height;
    int red;
    int green;
    int blue;
    Color c;
    Color newColor;
    
      try {
          bufImg = ImageIO.read(fil);
          height = bufImg.getHeight();
          width  = bufImg.getWidth();
          
          for(int i=0; i<height; i++){
            for(int j = 0; j < width; j++) {
             c        = new Color(bufImg.getRGB(j, i));
             red      = (int)(c.getRed() * 0.299);
             green    = (int)(c.getGreen() * 0.587);
             blue     = (int)(c.getBlue() *0.114);
             newColor = new Color(red+green+blue, red+green+blue, red+green+blue);
             bufImg.setRGB(j,i,newColor.getRGB());
            }
          }
          ImageIO.write(bufImg, ext, fil);
      } catch (IOException ex) {
          Logger.getLogger(WhiteBlackUtility.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
