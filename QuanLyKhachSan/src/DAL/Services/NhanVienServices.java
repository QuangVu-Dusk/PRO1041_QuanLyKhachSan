package DAL.Services;

import DAL.Entities.NhanVien;
import DAL.IServices.INhanVienServices;
import DAL.DatabaseContext.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienServices implements INhanVienServices {

    String insert_Sql = "INSERT INTO NhanVien(MaNhanVien, MatKhau, MaQuyen) VALUES (?,?,?)";
    String update_Sql = "UPDATE NhanVien SET MatKhau = ? , MaQuyen = ? WHERE MaNhanVien = ?";
    String delete_Sql = "DELETE FROM NhanVien WHERE MaNhanVien =?";
    String selectAll_Sql = "SELECT * FROM NhanVien";
    String selectById_Sql = "SELECT * FROM NhanVien WHERE MaNhanVien =?";

    @Override
    public void addNhanVien(NhanVien nv) {
        try {

            Connection.update(insert_Sql, nv.getMaNhanVien(), nv.getMaKhau(), nv.getMaQuyen());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateNhanVien(NhanVien nv) {
        try {
            Connection.update(update_Sql, nv.getMaKhau(), nv.getMaQuyen(), nv.getMaNhanVien());

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienServices.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void deleteNhanVien(String key) {
        try {
            Connection.update(delete_Sql, key);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienServices.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public NhanVien getListNhanVienByID(String key) {
        List<NhanVien> list = this.getListNhanVienBySql(selectById_Sql, key);
        if(list.isEmpty()){
            return null;
        }
        return  list.get(0);
    }

    @Override
    public List<NhanVien> getListNhanVien() {
        return  this.getListNhanVienBySql(selectAll_Sql);
    }

    @Override
    public List<NhanVien> getListNhanVienBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = Connection.query(sql, args);
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(rs.getString("MaNhanVien"));
                nv.setMaKhau(rs.getString("MatKhau"));
                nv.setMaQuyen(rs.getString("MaQuyen"));
                list.add(nv);
                
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
