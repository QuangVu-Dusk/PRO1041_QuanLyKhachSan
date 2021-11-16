package DAL.Services;

import DAL.DatabaseContext.Connection;
import DAL.Entities.ChiTietHoaDon;
import DAL.IServices.IChiTietHoaDonServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietHoaDonServices implements IChiTietHoaDonServices {

    String insert_Sql = "INSERT INTO HoaDonChiTiet(MaHoaDonChiTiet, MaPhong , MaHoaDon, SoNgayThue, SoGioThue,NgayThanhToan, TrangThai) VALUES(?, ?, ?, ?, ?, ?, ?)";
    String update_Sql = "UPDATE HoaDonChiTiet SET MaPhong = ?, MaHoaDon = ? , SoNgayThue = ? , SoGioThue = ? ,NgayThanhToan = ?, TrangThai = ? WHERE MaHoaDonChiTiet = ?";
    String delete_Sql = "DELETE FROM HoaDonChiTiet WHERE MaHoaDonChiTiet = ?";
    String selectAll_Sql = "SELECT * FROM HoaDonChiTiet";
    String selectById_Sql = "SELECT * FROM HoaDonChiTiet WHERE MaHoaDonChiTiet = ?";
    String selectByMaPhong_Sql = "SELECT * FROM HoaDonChiTiet WHERE TrangThai = 1 and MaPhong = ?";

    @Override
    public void addChiTietHoaDon(ChiTietHoaDon cthd) {
        try {
            Connection.update(insert_Sql, cthd.getMaHoaDonChiTiet(), cthd.getMaPhong(), cthd.getMaHoaDon(), cthd.getSoNgayThue(), cthd.getSoNgayThue(), cthd.getNgayThanhToan(), cthd.isTrangThai());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateChiTietHoaDon(ChiTietHoaDon cthd) {
        try {
            Connection.update(insert_Sql, cthd.getMaPhong(), cthd.getMaHoaDon(), cthd.getSoNgayThue(), cthd.getSoNgayThue(), cthd.getNgayThanhToan(), cthd.isTrangThai(), cthd.getMaHoaDonChiTiet());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteChiTietHoaDon(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ChiTietHoaDon getListChiTietHoaDonByID(String key) {
        List<ChiTietHoaDon> list = this.getListChiTietHoaDonBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    @Override
    public ChiTietHoaDon getListChiTietHoaDonByMaPhong(String key) {
        List<ChiTietHoaDon> list = this.getListChiTietHoaDonBySql(selectByMaPhong_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChiTietHoaDon> getListChiTietHoaDon() {
        return this.getListChiTietHoaDonBySql(selectAll_Sql);
    }

    @Override
    public List<ChiTietHoaDon> getListChiTietHoaDonBySql(String sql, Object... args) {
        List<ChiTietHoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaHoaDonChiTiet(rs.getString("MaHoaDonChiTiet"));
                cthd.setMaPhong(rs.getString("MaPhong"));
                cthd.setMaHoaDon(rs.getString("SoHoaDon"));
                cthd.setSoNgayThue(rs.getInt("SoNgayThue"));
                cthd.setSoGioThue(rs.getInt("SoGioThue"));
                cthd.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                cthd.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(cthd);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMaHDCTAuto() {
        try {
            ResultSet rs = Connection.query("{CALL sp_HoaDonChiTietAuto}");
            String maHD = "";
            while (rs.next()) {
                maHD = rs.getString("HoaDonChiTietAuto");
            }
            rs.getStatement().getConnection().close();
            return maHD;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
