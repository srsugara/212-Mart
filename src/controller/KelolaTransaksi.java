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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pesanan;

/**
 *
 * @author Syauqi Rahmat Sugara
 */
public class KelolaTransaksi {

    public List<Pesanan> getListPesanan(int idPesan) throws SQLException {
        List<Pesanan> pesList;
        Connection con = KoneksiDB.connectDB();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT b.id_barang,b.nama_barang,b.harga,p.jumlah_barang,p.total "
                    + "FROM barang as b inner join pesan_barang as p "
                    + "on b.id_barang=p.id_barang where p.id_pesanan='" + idPesan + "'");
            pesList = new ArrayList<>();
            while (rs.next()) {
                Pesanan pes = new Pesanan();
                pes.setIdBarang(rs.getString("id_barang"));
                pes.setNama(rs.getString("nama_barang"));
                pes.setHarga(rs.getInt("harga"));
                pes.setJumlah(rs.getInt("jumlah_barang"));
                pes.setTotalHarga(rs.getInt("total"));

                pesList.add(pes);
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return pesList;
    }

    public int getTagihan(int id) {
        Connection con = KoneksiDB.connectDB();
        Statement st;
        int tagihan = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(total) as tagihan FROM pesan_barang where id_pesanan='" + id + "'");

            while (rs.next()) {
                tagihan = rs.getInt("tagihan");
                // Get data from the current row and use it
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelolaTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tagihan;
    }

    public int getMaxId() {
        Connection con = KoneksiDB.connectDB();
        Statement st;
        int akhir = 0;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(no) as akhir FROM pesan_barang");

            while (rs.next()) {
                akhir = rs.getInt("akhir");
                // Get data from the current row and use it
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelolaTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return akhir;
    }

    public int getMaxIdPesanan() throws SQLException {
        Connection con = KoneksiDB.connectDB();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT MAX(id_pesanan) as akhir FROM pesan_barang");
        int akhir = 0;
        while (rs.next()) {
            akhir = rs.getInt("akhir");
            // Get data from the current row and use it
        }
        return akhir;
    }

    public void tambahPesanan(Pesanan pes) throws SQLException {
        Connection con = KoneksiDB.connectDB();
        try {
            PreparedStatement stat = con.prepareStatement("INSERT INTO pesan_barang values(?,?,?,?,?)");
            stat.setInt(1, pes.getNo());
            stat.setInt(2, pes.getIdPesan());
            stat.setString(3, pes.getIdBarang());
            stat.setInt(4, pes.getJumlah());
            stat.setInt(5, pes.getTotalHarga());
            stat.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void hapusPesanan(String id, int idPesan) {
        Connection con = KoneksiDB.connectDB();
        try {
            Statement st = con.createStatement();
            int result = st.executeUpdate("DELETE FROM pesan_barang WHERE id_barang='" + id + "' && id_pesanan=" + idPesan);
            if (result >= 1) {
                JOptionPane.showMessageDialog(null, "Data telah terhapus");
            } else {
                JOptionPane.showMessageDialog(null, "Data gagal terhapus");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void ubahPesanan(int idPesan, String id, int jumlah, int total) {
        if (id == null || idPesan <= 0 || jumlah <= 0 || total <= 0) {
            JOptionPane.showMessageDialog(null, "Parameter method ubahPesanan() tidak valid");
        }
        Connection con = KoneksiDB.connectDB();
        try {
            Statement st = con.createStatement();
            int result = st.executeUpdate("UPDATE pesan_barang SET jumlah_barang=jumlah_barang+'" + jumlah + "',total=total+'" + total + "'"
                    + "WHERE id_barang='" + id + "' && id_pesanan='" + idPesan + "'");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public int getCountPesan(String id, int idPesan) throws SQLException {
        if (id == null || idPesan <= 0) {
            JOptionPane.showMessageDialog(null, "Parameter method getCountPesanan() tidak valid");
        }

        Connection con = KoneksiDB.connectDB();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM pesan_barang "
                + "where id_barang='" + id + "' && id_pesanan=" + idPesan);
        int count = 0;
        while (rs.next()) {
            ++count;
            // Get data from the current row and use it
        }
        return count;
    }
}
