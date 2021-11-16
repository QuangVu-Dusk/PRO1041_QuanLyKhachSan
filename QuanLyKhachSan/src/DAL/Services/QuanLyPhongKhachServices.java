package DAL.Services;

import BUS.Model.QuanLyPhongKhachSan;
import DAL.DatabaseContext.Connection;
import DAL.IServices.IQuanLyPhongKhachSanServices;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuanLyPhongKhachServices implements IQuanLyPhongKhachSanServices {

    String selectAll_Sql = "Select MaPhong, TenLoaiPhong, SoTang, GiaTheoGio, GiaTheoNgay, GhiChu, TrangThai from LoaiPhong Join Phong on LoaiPhong.MaLoaiPhong = Phong.MaLoaiPhong Join Tang on Phong.MaTang = Tang.MaTang";
    String selectById_Sql = "Select MaPhong, TenLoaiPhong, SoTang, GiaTheoGio, GiaTheoNgay, GhiChu, TrangThai from LoaiPhong Join Phong on LoaiPhong.MaLoaiPhong = Phong.MaLoaiPhong Join Tang on Phong.MaTang = Tang.MaTang WHERE MaPhong = ?";

    @Override
    public QuanLyPhongKhachSan getListPhongByID(String key) {
        List<QuanLyPhongKhachSan> list = this.getListPhongBySql(selectById_Sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QuanLyPhongKhachSan> getListPhong() {
        return this.getListPhongBySql(selectAll_Sql);
    }

    @Override
    public List<QuanLyPhongKhachSan> getListPhongBySql(String sql, Object... args) {
        List<QuanLyPhongKhachSan> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while (rs.next()) {
                QuanLyPhongKhachSan p = new QuanLyPhongKhachSan();
                p.setMaPhong(rs.getString("MaPhong"));
                p.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
                p.setSoTang(rs.getInt("SoTang"));
                p.setGiaTheoGio(rs.getInt("GiaTheoGio"));
                p.setGiaTheoNgay(rs.getInt("GiaTheoNgay"));
                p.setGhiChu(rs.getString("GhiChu"));
                p.setTrangThai(rs.getInt("TrangThai"));
                list.add(p);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
