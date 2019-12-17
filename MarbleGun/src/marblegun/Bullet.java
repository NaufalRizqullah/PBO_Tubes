package marblegun;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends Sub{
    

    //fields

    private Color color1 ;
    private BufferedImage image ;

    //constructor
    public Bullet (double angle, double x, double y) {
        this.x = x;
        this.y = y;
        r = 2 ;
        
        image = Gambar.getResourceImage("peluru.png");
        rad = Math.toRadians(angle) ;
        speed = 10 ;
        dx = Math.cos(rad) * speed ;
        dy = Math.sin(rad) * speed;
        

        color1 = Color.YELLOW ;
    }

    //functions

    @Override
    public double getx() {
        return x;
    }
    @Override
    public double gety() {
        return y;
    }

    /**
     *
     * @return
     */
    @Override
    public double getr() {
        return r;
    }

    public boolean update (){
        x += dx ;
        y += dy ;

        return x < -r || x > GamePanel.WIDTH + r ||
                y < -r || y > GamePanel.HEIGHT + r ;
    } 
    @Override
    public void  draw (Graphics2D g){
        g.setColor(color1) ;
        g.drawImage(image, (int)(x - r), (int)(y - r), null) ;

    }


}