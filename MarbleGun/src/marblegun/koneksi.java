package marblegun;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class koneksi {

    public static Connection highscore;
    public static Statement query;
    String sql;
    String sql2;
    String sql3;
    static ResultSet rs;
    int id;

    public void push(String nama, int score) {
        sql = "INSERT INTO player (Nama) VALUES ('" + nama + "')";
        sql2 = "SELECT Id_player FROM player WHERE Nama = '" + nama + "'";
        

        try {

            PreparedStatement stmt = highscore.prepareStatement(sql);
            stmt.execute();

            PreparedStatement stmt2 = highscore.prepareStatement(sql2);
            stmt2.execute();
            //ambil data
            rs = query.executeQuery(sql2);
            if (rs.next()) {
                id = rs.getInt(1);
            }
            
            //
            
            sql3 = "INSERT INTO score (Score,Id_player) VALUES (" + score + "," + id + ")";
            PreparedStatement stmt3 = highscore.prepareStatement(sql3);
            stmt3.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
        }
    }

//    public koneksi() {
//
//        try {
//            String DB = "jdbc:mysql://localhost/game"; // delta_db database
//            String user = "root"; // user database
//            String pass = ""; // password database
//            Class.forName("com.mysql.jdbc.Driver");
//            highscore = DriverManager.getConnection(DB, user, pass);
//            query = highscore.createStatement();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, ("gagal koneksi" + e.getMessage()));
//
//        }
//    }

    public void KoneksiDB() {
        try {
            String DB = "jdbc:mysql://localhost/game"; // delta_db database
            String user = "root"; // user database
            String pass = ""; // password database
            Class.forName("com.mysql.jdbc.Driver");
            highscore = DriverManager.getConnection(DB, user, pass);
            query = highscore.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ("gagal koneksi" + e.getMessage()));

        }
    }

}
