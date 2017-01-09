/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Syauqi Rahmat Sugara
 */
public class PesananTableModel extends AbstractTableModel {
    private List<Pesanan> pesanList;

    public PesananTableModel(List<Pesanan> pesanList) {
        this.pesanList = pesanList;
    }
    
    private String[] header={"Kode","Nama","Harga Satuan","Jumlah","Total"};

    public List<Pesanan> getPesanList() {
        return pesanList;
    }

    public void setPesanList(List<Pesanan> pesanList) {
        this.pesanList = pesanList;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    @Override
    public int getRowCount() {
        return pesanList.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return pesanList.get(rowIndex).getIdBarang();
            case 1:
                return pesanList.get(rowIndex).getNama();
            case 2:
                return pesanList.get(rowIndex).getHarga();
            case 3:
                return pesanList.get(rowIndex).getJumlah();
            case 4:
                return pesanList.get(rowIndex).getTotalHarga();
            default:
                break;
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return header[column];
    }
}
