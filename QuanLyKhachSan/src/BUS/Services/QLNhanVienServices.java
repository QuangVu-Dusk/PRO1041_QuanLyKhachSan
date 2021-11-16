package BUS.Services;

import BUS.IServices.IQLNhanVienServices;
import DAL.Entities.KhachHang;
import DAL.Entities.NhanVien;
import DAL.Entities.Quyen;
import DAL.IServices.INhanVienServices;
import DAL.IServices.IQuyenServices;
import DAL.Services.KhachHangServices;
import DAL.Services.NhanVienServices;
import DAL.Services.QuyenServices;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QLNhanVienServices implements IQLNhanVienServices {

    INhanVienServices _listNhanVien = new NhanVienServices();
    IQuyenServices _iQuyen = new QuyenServices();
    @Override
    public void fillToTable(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = _listNhanVien.getListNhanVien();
            for (NhanVien nv : list) {
                Object[] row = {nv.getMaNhanVien(), nv.getMaKhau(), nv.getMaQuyen()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void add(JTextField maNhanVien, JPasswordField matKhau, JComboBox quyen) {
        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(maNhanVien.getText().toString());
        nv.setMaKhau(matKhau.getText().toString());
        nv.setMaQuyen(quyen.getSelectedItem().toString());
        _listNhanVien.addNhanVien(nv);
    }
    
    @Override
    public void edit(JTextField maNhanVien, JPasswordField matKhau, JComboBox quyen) {
        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(maNhanVien.getText().toString());
        nv.setMaKhau(matKhau.getText().toString());
        nv.setMaQuyen(quyen.getSelectedItem().toString());
        _listNhanVien.updateNhanVien(nv);
    }
    
    @Override
    public void delete(JTextField maNhanVien) {
        _listNhanVien.deleteNhanVien(maNhanVien.getText().toString());
    }

    @Override
    public void fillToCombo(JComboBox quyen) {
       DefaultComboBoxModel model = (DefaultComboBoxModel) quyen.getModel();
        model.removeAllElements();
        List<Quyen> list = _iQuyen.getListQuyen();
        for (Quyen q : list) {
            model.addElement(q);
        }
    }
    
}
