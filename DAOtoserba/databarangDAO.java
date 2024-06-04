/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOtoserba;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import DAOImpelments.Dataimplements;
/**
 *
 * @author MSI GF63
 */
public class databarangDAO implements Dataimplements{
    Connection connection;
    
    final String select = "SELECT * FROM barang";
    final String insert = "INSERT INTO barang (id_barang, nama_barang, harga_barang, jumlah_stok) VALUES (?,?,?,?)";
    final String update = "Update barang set nama_barang=?, harga_barang=?, jumlah_stok=? where id_barang=?";
    final String delete = "Delete from barang where id_barang=?";
    
    public databarangDAO(){
    connection = connector.connection();
    }

    @Override
    public void insert(databarang p) {
         PreparedStatement statement = null;
        try{
           
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getId_barang());
            statement.setString(2, p.getNama_barang());
            statement.setInt(3, p.getHarga_barang());
            statement.setInt(4, p.getJumlah_stok());
            statement.executeUpdate();
            throw new SQLException("Data Barang Berhasil Ditambahkan");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
  

    @Override
    public void update(databarang p) {
       PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(4, p.getId_barang());
            statement.setString(1, p.getNama_barang());
            statement.setInt(2, p.getHarga_barang());
            statement.setInt(3, p.getJumlah_stok());
            statement.executeUpdate();
            throw new SQLException("Data Barang Berhasil Diupdate");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String id) {
     PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, id);
            statement.executeUpdate();
            throw new SQLException("Data Barang Berhasil Di Delete");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        } 
    }

    @Override
    public List<databarang> getAll() {
    List<databarang> dp = null;
    try{
        dp = new ArrayList<databarang>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()){
        databarang fl = new databarang();
        fl.setId_barang(rs.getString("id_barang"));
        fl.setNama_barang(rs.getString("nama_barang"));
        fl.setHarga_barang(rs.getInt("harga_barang"));
        fl.setJumlah_stok(rs.getInt("jumlah_stok"));
        dp.add(fl);
        }
    }catch(SQLException ex){
    Logger.getLogger(databarangDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return dp;
    }
}
