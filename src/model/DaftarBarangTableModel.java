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
public class DaftarBarangTableModel extends AbstractTableModel {

    private List<Barang> brgList;
    
    private String[] header={"Kode","Nama","Harga","Stok"};

    public DaftarBarangTableModel(List<Barang> brgList) {
        this.brgList = brgList;
    }

    public List<Barang> getBrgList() {
        return brgList;
    }

    public void setBrgList(List<Barang> brgList) {
        this.brgList = brgList;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }
    
    
    @Override
    public int getRowCount() {
        return brgList.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex==0){
            return brgList.get(rowIndex).getId();
        }
        else if(columnIndex==1){
            return brgList.get(rowIndex).getNama();
        }
        else if(columnIndex==2){
            return brgList.get(rowIndex).getHarga();
        }
        else if(columnIndex==3){
            return brgList.get(rowIndex).getStok();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return header[column];
    }
    
}
