package DAL.Entities;

import java.util.Date;

public class HoaDon {

    private String _maHoaDon, _maKhachHang, _maLoaiHinhThue, _maNhanVien;
    private Date _ngayThue, _ngayDuKienTra;
    private int _soNguoi;
    private boolean _trangThai;

    public HoaDon() {
    }

    public HoaDon(String _maHoaDon, String _maKhachHang, String _maLoaiHinhThue, String _maNhanVien, Date _ngayThue, Date _ngayDuKienTra, int _soNguoi, boolean _trangThai) {
        this._maHoaDon = _maHoaDon;
        this._maKhachHang = _maKhachHang;
        this._maLoaiHinhThue = _maLoaiHinhThue;
        this._maNhanVien = _maNhanVien;
        this._ngayThue = _ngayThue;
        this._ngayDuKienTra = _ngayDuKienTra;
        this._soNguoi = _soNguoi;
        this._trangThai = _trangThai;
    }

    public String getMaHoaDon() {
        return _maHoaDon;
    }

    public void setMaHoaDon(String _maHoaDon) {
        this._maHoaDon = _maHoaDon;
    }

    public String getMaKhachHang() {
        return _maKhachHang;
    }

    public void setMaKhachHang(String _maKhachHang) {
        this._maKhachHang = _maKhachHang;
    }

    public String getMaLoaiHinhThue() {
        return _maLoaiHinhThue;
    }

    public void setMaLoaiHinhThue(String _maLoaiHinhThue) {
        this._maLoaiHinhThue = _maLoaiHinhThue;
    }

    public String getMaNhanVien() {
        return _maNhanVien;
    }

    public void setMaNhanVien(String _maNhanVien) {
        this._maNhanVien = _maNhanVien;
    }

    public Date getNgayThue() {
        return _ngayThue;
    }

    public void setNgayThue(Date _ngayThue) {
        this._ngayThue = _ngayThue;
    }

    public Date getNgayDuKienTra() {
        return _ngayDuKienTra;
    }

    public void setNgayDuKienTra(Date _ngayDuKienTra) {
        this._ngayDuKienTra = _ngayDuKienTra;
    }

    public int getSoNguoi() {
        return _soNguoi;
    }

    public void setSoNguoi(int _soNguoi) {
        this._soNguoi = _soNguoi;
    }

    public boolean isTrangThai() {
        return _trangThai;
    }

    public void setTrangThai(boolean _trangThai) {
        this._trangThai = _trangThai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "_maHoaDon=" + _maHoaDon + ", _maKhachHang=" + _maKhachHang + ", _maLoaiHinhThue=" + _maLoaiHinhThue + ", _maNhanVien=" + _maNhanVien + ", _ngayThue=" + _ngayThue + ", _ngayDuKienTra=" + _ngayDuKienTra + ", _soNguoi=" + _soNguoi + ", _trangThai=" + _trangThai + '}';
    }

}
