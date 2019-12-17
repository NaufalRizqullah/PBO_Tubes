package marblegun;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;

/**
 *
 * @author CATUR WARGA COMPUTER
 */
public class Player implements Aktor  {
    
    //fields
    private int x;
    private int y;
    private final int r ;

    private double dx ;
    private double dy ;
    private final double speed ;

    private boolean left ;
    private boolean right ;
    private boolean up ;
    private boolean down ;

    private boolean firing ;
    private long firingTimer ;
    private final long firingDelay ;

    private boolean recovering ;
    private long recoveryTimer ;

    private int lives ;
    private final Color color1 ;
    private final Color color2 ;

    private int score ;
    private BufferedImage image ;
    
    public static BufferedImage getResourceImage(String path){
        BufferedImage img=null;
        try {
            img=ImageIO.read(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }return img;
    }
 
    

    //constructor
    
    public Player() {
  

    image = getResourceImage("karakter.png");   
 


    x = GamePanel.WIDTH / 2 ;
    y = GamePanel.HEIGHT / 2 ;
    r = 5 ;

    dx = 10;
    dy = 5 ;
    speed = 3;

    lives = 3 ;
    color1 = Color.WHITE ;
    color2 = Color.RED ;
    
    firing = false ;
    firingTimer = System.nanoTime() ;
    firingDelay = 200 ;

    recovering = false ;
    recoveryTimer = 0 ;

    score = 0 ; 

}  

    //functions
    public int getx() {
        return x ;
    }
    public int gety() {
        return y ;
    }
    public int getr() {
        return r ;
    }
    public int getScore(){
        return score ;
    }
    public int getLives(){
        return lives ;
    }

    @Override
    public boolean isDead(){
        return lives <= 0  ;
    }
    public boolean isRecovering(){
        return recovering ;
    }


    public void setLeft(boolean b) { 
        left = b; 
    }
    public void setRight(boolean b) {
         right = b; 
        }
    public void setUp(boolean b) {
         up = b; 
        }
    public void setDown(boolean b) { 
        down = b; 
    }

    public void setFiring(boolean b){
        firing = b ;
    }
    public void addScore(int i){
        score += i ;
    }


    public void loseLife(){
        lives --;
        recovering = true ;
        recoveryTimer = System.nanoTime() ;
    }


    @Override
    public void update() {

        if (left){
            dx = -speed ;
        }
        if (right){
            dx = speed ;
        }
        if (up){
            dy = -speed ;
        }
        if (down){
            dy = speed ;
        }

        x += dx ;
        y += dy ;

        if (x < r) x = r ;
        if (y < r) y = r ;
        if (x > GamePanel.WIDTH - r) x = GamePanel.WIDTH - r ;
        if (x > GamePanel.HEIGHT - r) y = GamePanel.WIDTH - r ;

        dx = 0 ;
        dy = 0 ;

        if(firing){
            long elapsed = (System.nanoTime()-firingTimer)/1000000 ;
            if(elapsed > firingDelay) {
                GamePanel.bullets.add(new Bullet (270, x, y)) ;
                firingTimer = System.nanoTime() ;
            }
        }

        long elapsed = (System.nanoTime() - recoveryTimer) / 1000000 ;
        if(elapsed > 2000){
            recovering = false ;
            recoveryTimer = 0 ;
        }
    }

    @Override
    public void draw (Graphics2D g) {
        if (recovering){
            g.setColor(color2) ;
            g.fillOval(x - r, y - r, 2 * r, 2 * r) ;
        
            g.setStroke(new BasicStroke(3));
            g.setColor(color2.darker()) ;
            g.drawOval(x - r, y - r, 2 * r, 2 * r) ;
         
            g.setStroke(new BasicStroke(1)) ;
        }
        else {
           
            g.setColor(color1) ;
            g.fillOval(x - r, y - r, 2 * r, 2 * r) ;
        
            g.setStroke(new BasicStroke(3));
            g.setColor(color1.darker()) ;
           
 
            g.drawOval(x - r, y - r, 2 * r, 2 * r) ;
            g.setStroke(new BasicStroke(1)) ;
        }
    }
}