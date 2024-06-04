/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOtoserba.databarangDAO;
import model.*;
import frame.barangframe;
import DAOImpelments.Dataimplements;
import java.sql.SQLException;
import javax.swing.JOptionPane;
        
/**
 *
 * @author MSI GF63
 */
public class databarangcontroller {
    barangframe frame;
    Dataimplements impldatabarang;
    List <databarang> dp;
    
    public databarangcontroller(barangframe frame){
    this.frame = frame;
    impldatabarang = new databarangDAO();
    dp = impldatabarang.getAll();
    }
    public void isitabel(){
    dp = impldatabarang.getAll();
    modeltabeldatabarang mp = new modeltabeldatabarang(dp);
    frame.getTabeldatabarang().setModel(mp);
    }
    
    public void insert(){
        databarang dp = new databarang();
    int txtharga = Integer.parseInt(frame.getHarga_barangtxt().getText());
    int txtstok = Integer.parseInt(frame.getJumlah_stoktxt().getText());
   if(txtharga<0 || txtstok<0){
   JOptionPane.showMessageDialog(null, "Data Tidak Valid");
   }
   else{
    dp.setId_barang(frame.getId_barangtxt().getText());
    dp.setNama_barang(frame.getNama_barangtxt().getText());
    dp.setHarga_barang(txtharga);
    dp.setJumlah_stok(txtstok);
    impldatabarang.insert(dp);
    }}
    
    public void update(){
     databarang dp = new databarang();
    int txtharga = Integer.parseInt(frame.getHarga_barangtxt().getText());
    int txtstok = Integer.parseInt(frame.getJumlah_stoktxt().getText());
    if(txtharga<0 || txtstok<0){
   JOptionPane.showMessageDialog(null, "Data Tidak Valid");
   }
   else{
    dp.setId_barang(frame.getId_barangtxt().getText());
    dp.setNama_barang(frame.getNama_barangtxt().getText());
    dp.setHarga_barang(txtharga);
    dp.setJumlah_stok(txtstok);
    impldatabarang.update(dp);
    }}
    
    public void delete(){
    String id = frame.getId_barangtxt().getText();
    impldatabarang.delete(id);
    }
    
    public void clear(){
    frame.getId_barangtxt().setText(null);
    frame.getNama_barangtxt().setText(null);
    frame.getHarga_barangtxt().setText(null);
    frame.getJumlah_stoktxt().setText(null);
    }
    
}
