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
public class RgbUtility {
    public static BufferedImage origImg;
    
    public static String changeRgb(String addRest, String color, File fil, String ext, float change) {
    //Variable definition
    BufferedImage bufImg;
    int width;
    int height;
    int red;
    int green;
    int blue;
    Color c;
    Color newColor;
    float redChg = 1, greenChg = 1, blueChg = 1;
    float orig = change;
    
      try {
          if(addRest.equals("+")) change += 0.01;
          else if(change < 0.02) change = 0;
          else change -= 0.01;
          
          bufImg = ImageIO.read(fil);
          height = bufImg.getHeight();
          width  = bufImg.getWidth();
          
          if(color.equalsIgnoreCase("RED")) {
              redChg = change;
              if(change == 0) {
                  restoreRedColor(bufImg, height, width, fil, ext);
                  return Float.toString(change);
              }
          }
          else if(color.equalsIgnoreCase("GREEN")) {
              greenChg = change;
              if(change == 0) {
                  restoreGreenColor(bufImg, height, width, fil, ext);
                  return Float.toString(change);
              }
          }
          else {
              blueChg = change;
              if(change == 0) {
                  restoreBlueColor(bufImg, height, width, fil, ext);
                  return Float.toString(change);
              }
          }
          

          for(int i=0; i<height; i++){
            for(int j = 0; j < width; j++) {
             c        = new Color(bufImg.getRGB(j, i));
             red      = (int)(c.getRed());
             green    = (int)(c.getGreen());
             blue     = (int)(c.getBlue() * blueChg);
             
             if((red * redChg <= 255 && red * redChg >= 0) 
                    && (green * greenChg <= 255 && green * greenChg >= 0) 
                    && (blue * blueChg <= 255 && blue * blueChg >= 0)) {
                red *= redChg;
                green *= greenChg;
                blue *= blueChg;
             }
             else return Float.toString(orig);

             newColor = new Color(red, green, blue);
             bufImg.setRGB(j,i,newColor.getRGB());
            }
          }
          ImageIO.write(bufImg, ext, fil);
      } catch (IOException ex) {
          Logger.getLogger(WhiteBlackUtility.class.getName()).log(Level.SEVERE, null, ex);
      }
      return Float.toString(change);
  }
    private static void restoreRedColor(BufferedImage tmpImg, int height, int width,
                                        File fil, String ext) throws IOException {
        //Variable definition
        Color orig;
        Color temp;
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                orig = new Color(origImg.getRGB(j, i));
                temp = new Color(tmpImg.getRGB(j, i));
                tmpImg.setRGB(j,i,new Color(orig.getRed(),temp.getGreen(), temp.getBlue()).getRGB());
            }
        }
        ImageIO.write(tmpImg, ext, fil);
    }
    private static void restoreGreenColor(BufferedImage tmpImg, int height, int width,
                                          File fil, String ext) throws IOException {
        //Variable definition
        Color orig;
        Color temp;
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                orig = new Color(origImg.getRGB(j, i));
                temp = new Color(tmpImg.getRGB(j, i));
                tmpImg.setRGB(j,i,new Color(temp.getRed(),orig.getGreen(), temp.getBlue()).getRGB());
            }
        }
        ImageIO.write(tmpImg, ext, fil);
        
    }
    private static void restoreBlueColor(BufferedImage tmpImg, int height, int width,
                                         File fil, String ext) throws IOException {
        //Variable definition
        Color orig;
        Color temp;
        
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                orig = new Color(origImg.getRGB(j, i));
                temp = new Color(tmpImg.getRGB(j, i));
                tmpImg.setRGB(j,i,new Color(temp.getRed(),temp.getGreen(), orig.getBlue()).getRGB());
            }
        }
        ImageIO.write(tmpImg, ext, fil);
        
    }
}
