package marblegun;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Game extends javax.swing.JFrame {

    void run() {
        JFrame window = new JFrame("MARBLE GUN");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new GamePanel());
        window.pack();
        window.setLocationRelativeTo(null);// solved by : https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        window.setVisible(true);
        // membuat titik x dan y
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = dim.width / 2 - this.getSize().width / 2;
        int y = dim.height / 2 - this.getSize().height / 2;
        this.setLocation(x,y);

    }

    public static void main(String[] args) {

    }
}
