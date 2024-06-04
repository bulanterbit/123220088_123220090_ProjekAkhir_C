/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jaconiah
 */
public class DetailPembelianModel {
    private String id_pembelian;
    private String id_product;
    private double jumlah_pembelian;
    private double total_harga_produk;

    // Getter and Setter methods
    public String getId_pembelian() {
        return id_pembelian;
    }

    public void setId_pembelian(String id_pembelian) {
        this.id_pembelian = id_pembelian;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public double getJumlah_pembelian() {
        return jumlah_pembelian;
    }

    public void setJumlah_pembelian(double jumlah_pembelian) {
        this.jumlah_pembelian = jumlah_pembelian;
    }

    public double getTotal_harga_produk() {
        return total_harga_produk;
    }

    public void setTotal_harga_produk(double total_harga_produk) {
        this.total_harga_produk = total_harga_produk;
    }
}

