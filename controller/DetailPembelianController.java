package controller;

import DAO.DetailPembelianDAO;
import frame.DetailPembelianFrame;
import interface_DAO.DetailPembelianInterface;

public class DetailPembelianController {
    private final DetailPembelianFrame frame;
    private final DetailPembelianInterface detailPembelianInterface;

    public DetailPembelianController(DetailPembelianFrame frame) {
        this.frame = frame;
        detailPembelianInterface = new DetailPembelianDAO();
        // Set up any necessary listeners or initialization here
    }

    // Add more methods as needed for handling detail pembelian actions
}
