/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interface_DAO;
import java.util.List;
import model.*;
/**
 *
 * @author MSI GF63
 */
public interface DataBarangInterface {
    public void insert (DataBarangModel p);
    public void update (DataBarangModel p);
    public void delete (String Judul);
    public List<DataBarangModel> getAll();
}
