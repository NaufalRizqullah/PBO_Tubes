/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marblegun;

import java.awt.Graphics2D;

/**
 *
 * @author CATUR WARGA COMPUTER
 */
public abstract class Sub {
    public double x ;
    public double y ;
    public int r ;

    public double dx ;
    public double dy ;
    public double rad ;
    public double speed ;
    
    public abstract double gety();
    public abstract double getx();
    public abstract double getr();
    public abstract void draw(Graphics2D g);
}
