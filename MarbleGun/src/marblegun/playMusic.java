/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marblegun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author mereska
 */
public class playMusic {

    public static void main(String[] args) {

        
    }

    public static void playMusic(String filepath) {
        InputStream music;

        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
