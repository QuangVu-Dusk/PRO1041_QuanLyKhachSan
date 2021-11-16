package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.ChiTietDichVu;
import DAL.IServices.IChiTietDichVuServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietDichVuServices implements IChiTietDichVuServices {

    String insert_Sql = "INSERT INTO ChiTietDichVu(MaChiTietDichVu, MaHoaDonChiTiet, MaDichVu, DonGia, SoLuong) VALUES(?, ?, ?, ?, ?)";
    String update_Sql = "UPDATE ChiTietDichVu SET MaHoaDonChiTiet = ?, MaDichVu =? , DonGia =? , SoLuong = ? WHERE MaChiTietDichVu = ?";
    String delete_Sql = "DELETE FROM ChiTietDichVu WHERE MaChiTietDichVu = ?";
    String selectAll_Sql = "SELECT * FROM ChiTietDichVu";
    String selectById_Sql = "SELECT * FROM ChiTietDichVu WHERE MaChiTietDichVu = ?";

    @Override
    public void addChiTietDichVu(ChiTietDichVu ctdv) {
        try {
            Connection.update(insert_Sql, ctdv.getMaChiTietDichVu(), ctdv.getMaHoaDonChiTiet(), ctdv.getMaDichVu(), ctdv.getDonGia(), ctdv.getSoLuong());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateChiTietDichVu(ChiTietDichVu ctdv) {
        try {
            Connection.update(insert_Sql, ctdv.getMaHoaDonChiTiet(), ctdv.getMaDichVu(), ctdv.getDonGia(), ctdv.getSoLuong(), ctdv.getMaChiTietDichVu());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteChiTietDichVu(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietDichVuServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ChiTietDichVu getListChiTietDichVuByID(String key) {
        List<ChiTietDichVu> list = this.getListChiTietDichVuBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChiTietDichVu> getListChiTietDichVuByMaHoaDonChiTiet(String key) {
        String selectByMaHoaDonChiTiet_Sql = "SELECT * FROM ChiTietDichVu WHERE MaHoaDonChiTiet = " + key;
        return this.getListChiTietDichVuBySql(selectByMaHoaDonChiTiet_Sql);
    }

    @Override
    public List<ChiTietDichVu> getListChiTietDichVu() {
        return this.getListChiTietDichVuBySql(selectAll_Sql);
    }

    @Override
    public List<ChiTietDichVu> getListChiTietDichVuBySql(String sql, Object... args) {
        List<ChiTietDichVu> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                ChiTietDichVu ctdv = new ChiTietDichVu();
                ctdv.setMaChiTietDichVu(rs.getString("MaChiTietDichVu"));
                ctdv.setMaHoaDonChiTiet(rs.getString("MaHoaDonChitiet"));
                ctdv.setMaDichVu(rs.getString("MaDichVu"));
                ctdv.setDonGia(rs.getInt("DonGia"));
                ctdv.setSoLuong(rs.getInt("SoLuong"));
                list.add(ctdv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
