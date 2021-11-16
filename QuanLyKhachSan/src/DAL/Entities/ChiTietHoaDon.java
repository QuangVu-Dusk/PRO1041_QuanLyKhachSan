package DAL.Entities;

import java.util.Date;

public class ChiTietHoaDon {

    private String _maHoaDonChiTiet, _maHoaDon, _maPhong;
    private int _soNgayThue, _soGioThue;
    private Date _ngayThanhToan;
    private boolean _trangThai;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String _maHoaDonChiTiet, String _maHoaDon, String _maPhong, int _soNgayThue, int _soGioThue, Date _ngayThanhToan, boolean _trangThai) {
        this._maHoaDonChiTiet = _maHoaDonChiTiet;
        this._maHoaDon = _maHoaDon;
        this._maPhong = _maPhong;
        this._soNgayThue = _soNgayThue;
        this._soGioThue = _soGioThue;
        this._ngayThanhToan = _ngayThanhToan;
        this._trangThai = _trangThai;
    }

    public String getMaHoaDonChiTiet() {
        return _maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String _maHoaDonChiTiet) {
        this._maHoaDonChiTiet = _maHoaDonChiTiet;
    }

    public String getMaHoaDon() {
        return _maHoaDon;
    }

    public void setMaHoaDon(String _maHoaDon) {
        this._maHoaDon = _maHoaDon;
    }

    public String getMaPhong() {
        return _maPhong;
    }

    public void setMaPhong(String _maPhong) {
        this._maPhong = _maPhong;
    }

    public int getSoNgayThue() {
        return _soNgayThue;
    }

    public void setSoNgayThue(int _soNgayThue) {
        this._soNgayThue = _soNgayThue;
    }

    public int getSoGioThue() {
        return _soGioThue;
    }

    public void setSoGioThue(int _soGioThue) {
        this._soGioThue = _soGioThue;
    }

    public Date getNgayThanhToan() {
        return _ngayThanhToan;
    }

    public void setNgayThanhToan(Date _ngayThanhToan) {
        this._ngayThanhToan = _ngayThanhToan;
    }

    public boolean isTrangThai() {
        return _trangThai;
    }

    public void setTrangThai(boolean _trangThai) {
        this._trangThai = _trangThai;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "_maHoaDonChiTiet=" + _maHoaDonChiTiet + ", _maHoaDon=" + _maHoaDon + ", _maPhong=" + _maPhong + ", _soNgayThue=" + _soNgayThue + ", _soGioThue=" + _soGioThue + ", _ngayThanhToan=" + _ngayThanhToan + ", _trangThai=" + _trangThai + '}';
    }

}
