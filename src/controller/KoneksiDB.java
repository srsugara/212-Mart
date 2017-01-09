/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Syauqi Rahmat Sugara
 */
public class KoneksiDB {
    
    public static Connection connectDB() {
        // melakukan koneksi database
        return connectDB("jdbc:mysql://localhost:3306/212_mart", "root", ""); 
    }
    
    public static Connection connectDB(String url, String user, String pass){
        java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Untuk memanggil driver mysql
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e ) {
            System.err.println(e.getMessage());
        }
        return con;
    }
    
//    public static void main(String[] args) {
//        KoneksiDB con=new KoneksiDB();
//        con.connectDB();
//        if(con!=null){
//            System.out.println("berhasil");
//        }else{
//            System.out.println("gagal");
//        }
//    }
}
