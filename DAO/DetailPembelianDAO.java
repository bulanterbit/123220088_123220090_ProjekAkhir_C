package DAO;

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
import interface_DAO.DetailPembelianInterface;
import model.DetailPembelianModel;
import koneksi.connector;

public class DetailPembelianDAO implements DetailPembelianInterface {
    Connection connection;
    
    final String select = "SELECT * FROM detail_pembelian";
    final String insert = "INSERT INTO detail_pembelian (id_pembelian, id_product, jumlah_pembelian, total_harga_produk) VALUES (?,?,?,?)";
    final String update = "UPDATE detail_pembelian SET id_product=?, jumlah_pembelian=?, total_harga_produk=? WHERE id_pembelian=?";
    final String delete = "DELETE FROM detail_pembelian WHERE id_pembelian=? AND id_product=?";
    
    public DetailPembelianDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(DetailPembelianModel dp) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, dp.getId_pembelian());
            statement.setString(2, dp.getId_product());
            statement.setDouble(3, dp.getJumlah_pembelian());
            statement.setDouble(4, dp.getTotal_harga_produk());
            statement.executeUpdate();
            throw new SQLException("Data Detail Pembelian Berhasil Ditambahkan");
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
    public void update(DetailPembelianModel dp) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, dp.getId_product());
            statement.setDouble(2, dp.getJumlah_pembelian());
            statement.setDouble(3, dp.getTotal_harga_produk());
            statement.setString(4, dp.getId_pembelian());
            statement.executeUpdate();
            throw new SQLException("Data Detail Pembelian Berhasil Diupdate");
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
    public void delete(String id_pembelian, String id_product) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, id_pembelian);
            statement.setString(2, id_product);
            statement.executeUpdate();
            throw new SQLException("Data Detail Pembelian Berhasil Di Delete");
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
    public List<DetailPembelianModel> getAll() {
        List<DetailPembelianModel> detailPembelianList = null;
        try{
            detailPembelianList = new ArrayList<DetailPembelianModel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                DetailPembelianModel dp = new DetailPembelianModel();
                dp.setId_pembelian(rs.getString("id_pembelian"));
                dp.setId_product(rs.getString("id_product"));
                dp.setJumlah_pembelian(rs.getDouble("jumlah_pembelian"));
                dp.setTotal_harga_produk(rs.getDouble("total_harga_produk"));
                detailPembelianList.add(dp);
            }
        }catch(SQLException ex){
            Logger.getLogger(DetailPembelianDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detailPembelianList;
    }
}
