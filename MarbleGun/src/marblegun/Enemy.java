package marblegun;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends Sub implements Aktor{
    //fields 
    
    private int health ;
    private final int type ;
    private final int rank ;

    private Color color1 ;

    private boolean ready ;
    private boolean dead ;
    
    private BufferedImage image ;

    //constructor 
    public Enemy (int type , int rank) {
        this.type = type ;
        this.rank = rank ;
        
        image = Gambar.getResourceImage("musuh.png");

        //default enemy
        if (type==1){
            color1 = Color.BLUE ;
            if (rank == 1){
                speed = 1 ;
                r = 5 ;
                health = 1 ;
            }

        }
        else if (type==2){
            color1 = Color.YELLOW ;
            if (rank == 1){
                speed = 3 ;
                r = 5 ;
                health = 3 ;
            }

        }
        else if (type==3){
            color1 = Color.GREEN ;
            if (rank == 1){
                speed = 7 ;
                r = 5 ;
                health = 5 ;
            }
        }
        

        x = Math.random() * GamePanel.WIDTH / 2 + GamePanel.WIDTH / 4 ;
        y = -r ;

        double angle = Math.random() * 140 + 20 ;
        rad = Math.toRadians(angle) ;

        dx = Math.cos(rad) * speed ;
        dy = Math.sin(rad) * speed ;

        ready = false ;
        dead = false ;
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
    @Override
        public double getr() {
            return r;
        }

        public int getType(){
            return type ;
        }
        public int getRank(){
            return rank ;
        }

    @Override
        public boolean isDead() {
            return dead ;
        }
    
        public void hit(){
            health -- ;
            if (health <= 0){
                dead = true ;

            }
        }

    @Override
        public void update (){
            x += dx ;
            y += dy ;

            if (!ready){
                if (x > r && x < GamePanel.WIDTH - r &&
                    y > r && y < GamePanel.HEIGHT -r ){
                        ready = true ;
                    }
            }

            if (x < r && dx < 0) dx = -dx ;
            if (y < r && dy < 0) dy = -dy ;
            if (x > GamePanel.WIDTH - r && dx > 0) dx = -dx ;
            if (y > GamePanel.HEIGHT - r && dy > 0) dy = -dy ;
        }

    @Override
        public void draw (Graphics2D g){
            g.setColor(color1) ;
            g.fillOval((int) (x - r), (int) (y - r),  2 * r , 2 * r);

            g.setStroke(new BasicStroke(3));
            g.setColor(color1.darker());
            g.drawImage(image, (int)(x - r), (int)(y - r), null) ;
            g.setStroke(new BasicStroke(1));

        }
}