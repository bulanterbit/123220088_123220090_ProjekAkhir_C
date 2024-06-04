package DAOtoserba;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import DAOImpelments.PembelianImplement;

public class pembeliantempDAO implements PembelianImplement {
    Connection connection;

    public pembeliantempDAO() {
        connection = connector.connection();
    }

    final String select = "SELECT * FROM detail_pembelian";
    final String insert = "INSERT INTO detail_pembelian (id_pembelian, nama_barang, jumlah_beli, harga_barang) VALUES (?,?,?,?)";
    final String update = "Update detail_pembelian set nama_barang=?, jumlah_beli=?, harga_barang=? where id_pembelian=?";
    final String delete = "Delete from detail_pembelian where id_pembelian=?";
    final String updatestok = "Update barang set jumlah_stok = jumlah_stok - ? where nama_barang=?";
    final String selectstock = "SELECT jumlah_stok FROM barang WHERE nama_barang = ?";

    @Override
    public void insert(PembelianTemp p) {
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            // Check stock availability
            st = connection.prepareStatement(selectstock);
            st.setString(1, p.getNama_barang());
            rs = st.executeQuery();

            if (rs.next()) {
                int stok = rs.getInt("jumlah_stok");
                if (stok < p.getJumlah_barang()) {
                    throw new SQLException("Stok tidak cukup");
                }
            } else {
                throw new SQLException("Barang tidak ditemukan");
            }

            // Insert into detail_pembelian
            statement = connection.prepareStatement(insert);
            statement.setString(1, p.getId_pembelian());
            statement.setString(2, p.getNama_barang());
            statement.setInt(3, p.getJumlah_barang());
            statement.setInt(4, p.getHarga_barang());
            statement.executeUpdate();

            // Update stock in barang
            statement2 = connection.prepareStatement(updatestok);
            statement2.setInt(1, p.getJumlah_barang());
            statement2.setString(2, p.getNama_barang());
            statement2.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data pembelian berhasil ditambahkan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (statement != null) statement.close();
                if (statement2 != null) statement2.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(PembelianTemp p) {
        // TODO: Implement this method
        throw new UnsupportedOperationException("Not supported yet.");
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
    public List<PembelianTemp> getAll() {
        List<PembelianTemp> dp = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                PembelianTemp fl = new PembelianTemp();
                fl.setId_pembelian(rs.getString("id_pembelian"));
                fl.setNama_barang(rs.getString("nama_barang"));
                fl.setJumlah_barang(rs.getInt("jumlah_beli"));
                fl.setHarga_barang(rs.getInt("harga_barang"));
                dp.add(fl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pembeliantempDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return dp;
    }
}
