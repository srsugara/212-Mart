/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import view.LoginForm;
import view.MenuUtamaForm;

/**
 *
 * @author Rian Nuryadin
 */
public class CekLogin {

    public void login(String username, String password) {
        username = Normalizer.normalize(username, Form.NFKC);
        password = Normalizer.normalize(password, Form.NFKC);
        if (!username.isEmpty() && !password.isEmpty()) {
            this.getUser(username, password);

        } else {
            JOptionPane.showMessageDialog(null, "username dan password tidak boleh kosong");
        }

    }

    public void getUser(String username, String password) {
        Connection con = KoneksiDB.connectDB();
        MenuUtamaForm m = new MenuUtamaForm();
        LoginForm lf = new LoginForm();

        if (con == null) {
// Handle error
            JOptionPane.showMessageDialog(null, "not connection");
        }
        try {

// Validate username length
            if (username.length() > 8 && password.length() > 8) {
                JOptionPane.showMessageDialog(null, "username tidak valid");
            } else {
                String sqlString = "select * from user where username=? and password=?";
                PreparedStatement stmt;
                try {
                    stmt = con.prepareStatement(sqlString);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    ResultSet rs = stmt.executeQuery();
                    Logger logger = Logger.getLogger("Logger");
                    FileHandler fh;
                    try {
                        fh = new FileHandler("MyLog.log");
                        logger.addHandler(fh);
                        SimpleFormatter formatter = new SimpleFormatter();
                        fh.setFormatter(formatter);
                        if (!rs.next()) {
                            JOptionPane.showMessageDialog(null, "username dan passwrod tidak valid");
                            logger.severe("Login gagal untuk user : " + this.sanitizeUser(username));
                        } else {
                            logger.severe("Login sukses untuk user : " + this.sanitizeUser(username));
                            lf.dispose();
                            m.setVisible(true);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(CekLogin.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SecurityException ex) {
                        Logger.getLogger(CekLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CekLogin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
// Authenticated; proceed
        } finally {
            try {
                con.close();
            } catch (SQLException x) {
// Forward to handler
            }
        }

    }

    public String sanitizeUser(String username) {
        return Pattern.matches("[A-Za-z0-9_]+", username)
                ? username : "unauthorized user";
    }

}
