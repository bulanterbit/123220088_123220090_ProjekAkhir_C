/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import java.util.ArrayList;
import DAOtoserba.*;
import model.*;
import frame.PembelianFrame;
import DAOImpelments.*;
import DAOtoserba.pembeliantempDAO;
/**
 *
 * @author MSI GF63
 */
public class pembeliantempcontroller {
    PembelianFrame frame;
    Dataimplements impldatabarang;
    PembelianImplement implpembelian;
    List <databarang> dp;
    List <PembelianTemp> pt;
    public pembeliantempcontroller(PembelianFrame frame){
        this.frame = frame;
        implpembelian = new pembeliantempDAO();
        impldatabarang = new databarangDAO();}
    public void isitabelbarang(){
        
    dp = impldatabarang.getAll();
    modeltabeldatabarang mp = new modeltabeldatabarang(dp);
    frame.getTabeldatabarang().setModel(mp);
    }
    
    public void isitabelbeli(){
     pt = implpembelian.getAll();
    modeltabeldatapembelian mp = new modeltabeldatapembelian(pt);
    frame.getTabel_pembelian().setModel(mp);
        
    }
     public void insert(){
        PembelianTemp pt = new PembelianTemp();
    int txtharga = Integer.parseInt(frame.harga_barangtxt);
    int txtjumlah = Integer.parseInt(frame.getJumlah_belitxt().getText());
    
    
    
    pt.setId_pembelian(frame.getId_pembeliantxt().getText());
    pt.setNama_barang(frame.getNama_barangtxt().getText());
    pt.setHarga_barang(txtharga*txtjumlah);
    pt.setJumlah_barang(txtjumlah);
    implpembelian.insert(pt);
    }
    
    public void update(){
    PembelianTemp pt = new PembelianTemp();
    int txtharga = Integer.parseInt(frame.harga_barangtxt);
    int txtjumlah = Integer.parseInt(frame.getJumlah_belitxt().getText());
    
    
    
    pt.setId_pembelian(frame.getId_pembeliantxt().getText());
    pt.setNama_barang(frame.getNama_barangtxt().getText());
    pt.setHarga_barang(txtharga*txtjumlah);
    pt.setJumlah_barang(txtjumlah);
    implpembelian.update(pt);
    }
    
    public void delete(){
       String id = frame.id_pembeliantxt1;
    implpembelian.delete(id);
    }
    
    public void clear(){
    frame.getId_pembeliantxt().setText(null);
    frame.getNama_barangtxt().setText(null);
    frame.getJumlah_belitxt().setText(null);
    }
}
