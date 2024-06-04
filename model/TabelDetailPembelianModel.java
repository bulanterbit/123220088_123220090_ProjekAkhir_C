/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Table model for displaying DetailPembelianModel data in a JTable.
 * 
 * @authior Jaconiah
 */
public class TabelDetailPembelianModel extends AbstractTableModel {
    private List<DetailPembelianModel> dp;

    public TabelDetailPembelianModel(List<DetailPembelianModel> dp) {
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
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Pembelian";
            case 1:
                return "Id Produk";
            case 2:
                return "Jumlah Pembelian";
            case 3:
                return "Total Harga Produk";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return dp.get(row).getId_pembelian();
            case 1:
                return dp.get(row).getId_product();
            case 2:
                return dp.get(row).getJumlah_pembelian();
            case 3:
                return dp.get(row).getTotal_harga_produk();
            default:
                return null;
        }
    }
}
