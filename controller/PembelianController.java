package controller;

import java.util.List;
import DAO.PembelianDAO;
import model.PembelianModel;
import frame.PembelianFrame;
import frame.DetailPembelianFrame;
import interface_DAO.PembelianInterface;

public class PembelianController {
    private final PembelianFrame frame;
    private final PembelianInterface pembelianDAO;
    private List<PembelianModel> pembelianList;

    public PembelianController(PembelianFrame frame) {
        this.frame = frame;
        this.pembelianDAO = new PembelianDAO();
        this.pembelianList = pembelianDAO.getAll();
        frame.displayPembelianData(pembelianList);

        frame.getTambahPesananButton().addActionListener(e -> {
            DetailPembelianFrame detailFrame = new DetailPembelianFrame();
            new DetailPembelianController(detailFrame, this);
            detailFrame.setVisible(true);
            frame.dispose();
        });

        frame.getOkButton().addActionListener(e -> {
            // Action when OK button is clicked
        });
    }

    public void insertPembelian(PembelianModel pembelian) {
        pembelianDAO.insert(pembelian);
        pembelianList = pembelianDAO.getAll();
        frame.displayPembelianData(pembelianList);
    }

    public void updatePembelian(PembelianModel pembelian) {
        pembelianDAO.update(pembelian);
        pembelianList = pembelianDAO.getAll();
        frame.displayPembelianData(pembelianList);
    }

    public void deletePembelian(String id) {
        pembelianDAO.delete(id);
        pembelianList = pembelianDAO.getAll();
        frame.displayPembelianData(pembelianList);
    }
}
