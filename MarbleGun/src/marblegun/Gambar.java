/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marblegun;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Gambar{
    public static BufferedImage getResourceImage(String path){
        BufferedImage img=null;
        try {
            img=ImageIO.read(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }return img;
    }
}