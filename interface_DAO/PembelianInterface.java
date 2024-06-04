/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_DAO;

import java.util.List;
import model.PembelianModel;

/**
 *
 * @author Jaconiah
 */
public interface PembelianInterface {
    public void insert(PembelianModel p);
    public void update(PembelianModel p);
    public void delete(String id_pembelian);
    public List<PembelianModel> getAll();
}
