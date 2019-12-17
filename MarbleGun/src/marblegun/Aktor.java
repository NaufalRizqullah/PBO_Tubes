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
public interface Aktor {

    /**
     *
     * @return
     */
    public abstract boolean isDead();
    public abstract void update ();
    public abstract void draw(Graphics2D g);
}
