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
import java.util.List;
import javax.swing.JOptionPane;
import model.Barang;

/**
 *
 * @author Syauqi Rahmat Sugara
 */
public class KelolaBarang {

    public List<Barang> getListBarang() throws SQLException {
        List<Barang> brgList;
        Connection con = KoneksiDB.connectDB();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM barang");
            brgList = new ArrayList<>();
            while (rs.next()) {
                Barang brg = new Barang();
                brg.setId(rs.getString("id_barang"));
                brg.setNama(rs.getString("nama_barang"));
                brg.setHarga(rs.getInt("harga"));
                brg.setStok(rs.getInt("stok"));

                brgList.add(brg);
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return brgList;
    }

    public List<Barang> getListBarang(String nama) throws SQLException {
        List<Barang> brgList;
        Connection con = KoneksiDB.connectDB();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM barang where nama_barang='" + nama + "'");
            brgList = new ArrayList<>();
            while (rs.next()) {
                Barang brg = new Barang();
                brg.setId(rs.getString("id_barang"));
                brg.setNama(rs.getString("nama_barang"));
                brg.setHarga(rs.getInt("harga"));
                brg.setStok(rs.getInt("stok"));

                brgList.add(brg);
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return brgList;
    }

    public int getCountBarang(String id) throws SQLException {
        Connection con = KoneksiDB.connectDB();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM barang where id_barang='" + id + "'");
        int count = 0;

        while (rs.next()) {
            ++count;
            // Get data from the current row and use it
        }
        return count;
    }

    public void hapusBarang(String id) {
        Connection con = KoneksiDB.connectDB();
        try {
            Statement st = con.createStatement();
            int result = st.executeUpdate("DELETE FROM barang WHERE id_barang='" + id + "'");
            if (result >= 1) {
                JOptionPane.showMessageDialog(null, "Data telah terhapus");
            } else {
                JOptionPane.showMessageDialog(null, "Data gagal terhapus");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //function untuk menambahkan data yang ada ke database tabel mahasiswa
    public void tambahBarang(Barang brg) throws SQLException {
        Connection con = KoneksiDB.connectDB();
        try {
            PreparedStatement stat = con.prepareStatement("INSERT INTO barang values(?,?,?,?)");
            stat.setString(1, brg.getId());
            stat.setString(2, brg.getNama());
            stat.setInt(4, brg.getHarga());
            stat.setInt(3, brg.getStok());
            int result = stat.executeUpdate();
            if (result >= 1) {
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(null, "Data gagal ditambahkan");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //function untuk mengubah data yang ada di database tabel mahasiswa
    public void ubahBarang(String idLama, String id, String nama, int harga, int stok) {
        Connection con = KoneksiDB.connectDB();
        try {
            Statement st = con.createStatement();
            int result = st.executeUpdate("UPDATE barang SET id_barang='" + id + "', nama_barang='" + nama + "', harga='" + harga + "' , stok='" + stok + "' WHERE id_barang='" + idLama + "'");
            if (result >= 1) {
                JOptionPane.showMessageDialog(null, "Berhasil mengupdate data");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal mengupdate data");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public int getStok(String id) throws SQLException {
        Connection con = KoneksiDB.connectDB();
        int stok = 0;
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT stok FROM barang where id_barang='" + id + "'");
            while (rs.next()) {
                stok = rs.getInt("stok");
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return stok;
    }

    public void ubahStok(String id, int jumlah, Boolean tipe) {
        Connection con = KoneksiDB.connectDB();
        String query = null;
        try {
            Statement st = con.createStatement();
            if (tipe == true) {
                query="UPDATE barang SET stok=stok-" + jumlah + " WHERE id_barang='" + id + "'";
            } else if (tipe == false) {
                query="UPDATE barang SET stok=stok+" + jumlah + " WHERE id_barang='" + id + "'";
            }
            st.executeUpdate(query);
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
