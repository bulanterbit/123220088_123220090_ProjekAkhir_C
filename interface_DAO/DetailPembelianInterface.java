/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_DAO;

import java.util.List;
import model.DetailPembelianModel;

/**
 *
 * @author Jaconiah
 */
public interface DetailPembelianInterface {
    public void insert(DetailPembelianModel dp);
    public void update(DetailPembelianModel dp);
    public void delete(String id_pembelian, String id_product);
    public List<DetailPembelianModel> getAll();
}

