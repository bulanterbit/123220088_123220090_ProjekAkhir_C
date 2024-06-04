/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImpelments;
import java.util.List;
import model.*;
/**
 *
 * @author MSI GF63
 */
public interface PembelianImplement {
    public void insert (PembelianTemp p);
    public void update (PembelianTemp p);
    public void delete (String id_pembelian);
    public List<PembelianTemp> getAll();
}
