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
import interface_DAO.PembelianInterface;
import model.PembelianModel;
import koneksi.connector;

public class PembelianDAO implements PembelianInterface {
    Connection connection;
    
    final String select = "SELECT * FROM pembelian";
    final String insert = "INSERT INTO pembelian (id_pembelian, id_member, total_harga) VALUES (?,?,?)";
    final String update = "UPDATE pembelian SET id_member=?, total_harga=? WHERE id_pembelian=?";
    final String delete = "DELETE FROM pembelian WHERE id_pembelian=?";
    
    public PembelianDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(PembelianModel p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getId_pembelian());
            statement.setString(2, p.getId_member());
            statement.setDouble(3, p.getTotal_harga());
            statement.executeUpdate();
            throw new SQLException("Data Pembelian Berhasil Ditambahkan");
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
    public void update(PembelianModel p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getId_member());
            statement.setDouble(2, p.getTotal_harga());
            statement.setString(3, p.getId_pembelian());
            statement.executeUpdate();
            throw new SQLException("Data Pembelian Berhasil Diupdate");
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
    public void delete(String id_pembelian) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, id_pembelian);
            statement.executeUpdate();
            throw new SQLException("Data Pembelian Berhasil Di Delete");
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
    public List<PembelianModel> getAll() {
        List<PembelianModel> pembelianList = null;
        try{
            pembelianList = new ArrayList<PembelianModel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                PembelianModel pembelian = new PembelianModel();
                pembelian.setId_pembelian(rs.getString("id_pembelian"));
                pembelian.setId_member(rs.getString("id_member"));
                pembelian.setTotal_harga(rs.getDouble("total_harga"));
                pembelianList.add(pembelian);
            }
        }catch(SQLException ex){
            Logger.getLogger(PembelianDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pembelianList;
    }
}
