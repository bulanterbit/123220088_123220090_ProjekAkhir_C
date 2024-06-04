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
public interface Dataimplements {
    public void insert (databarang p);
    public void update (databarang p);
    public void delete (String id);
    public List<databarang> getAll();
}
