/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Barang;
import view.LoginForm;
import view.MenuUtamaForm;

/**
 *
 * @author Rian Nuryadin
 */
public class CekLogin {

    public void login(String username, String password) throws SQLException {
        if (!username.isEmpty() && !password.isEmpty()) {
            this.getUser(username, password);

        } else {
            JOptionPane.showMessageDialog(null, "username dan password tidak boleh kosong");
        }

    }

    public void getUser(String username, String password) throws SQLException {
        Connection con = KoneksiDB.connectDB();
        MenuUtamaForm m = new MenuUtamaForm();
        LoginForm lf=new LoginForm();
        if (con == null) {
// Handle error

            JOptionPane.showMessageDialog(null, "not connection");
        }
        try {

// Validate username length
            if (username.length() > 8) {

                JOptionPane.showMessageDialog(null, "username tidak valid");

// Handle error
            } else {
                String sqlString = "select * from user where username=? and password=?";
                PreparedStatement stmt = con.prepareStatement(sqlString);
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();

                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "username dan passwrod tidak valid");
                } else {
                    lf.dispose();
                    m.setVisible(true);                
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

}
