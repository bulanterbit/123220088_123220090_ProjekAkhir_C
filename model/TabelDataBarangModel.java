/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author MSI GF63
 */
public class TabelDataBarangModel extends AbstractTableModel{
    List<DataBarangModel> dp;
    public TabelDataBarangModel(List<DataBarangModel>dp){
    this.dp = dp;
    }
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
    switch (column){
        case 0 :
            return "Id Barang";
        case 1 :
            return "Nama Barang";
        case 2 :
            return "Jumlah Barang";
        case 3 : 
            return "Jumlah Stok";
        default : 
            return null;
    }
    
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
        case 0 :
            return dp.get(row).getId_barang();
        case 1 :
            return dp.get(row).getNama_barang();
        case 2 :
            return dp.get(row).getHarga_barang();
        case 3 : 
            return dp.get(row).getJumlah_stok();
        default : 
            return null;
    }}
    
}
