package DAL.IServices;

import BUS.Model.QuanLyPhongKhachSan;
import java.util.List;

public interface IQuanLyPhongKhachSanServices {

    public QuanLyPhongKhachSan getListPhongByID(String key);

    public List<QuanLyPhongKhachSan> getListPhong();

    public List<QuanLyPhongKhachSan> getListPhongBySql(String sql, Object... args);
}
