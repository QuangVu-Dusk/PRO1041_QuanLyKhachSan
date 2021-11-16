package DAL.Entities;

public class NhanVien {

    private String _maNhanVien, _maKhau, _maQuyen;

    public NhanVien() {
    }

    public NhanVien(String _maNhanVien, String _maKhau, String _maQuyen) {
        this._maNhanVien = _maNhanVien;
        this._maKhau = _maKhau;
        this._maQuyen = _maQuyen;
    }

    public String getMaNhanVien() {
        return _maNhanVien;
    }

    public void setMaNhanVien(String _maNhanVien) {
        this._maNhanVien = _maNhanVien;
    }

    public String getMaKhau() {
        return _maKhau;
    }

    public void setMaKhau(String _maKhau) {
        this._maKhau = _maKhau;
    }

    public String getMaQuyen() {
        return _maQuyen;
    }

    public void setMaQuyen(String _maQuyen) {
        this._maQuyen = _maQuyen;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "_maNhanVien=" + _maNhanVien + ", _maKhau=" + _maKhau + ", _maQuyen=" + _maQuyen + '}';
    }

}
