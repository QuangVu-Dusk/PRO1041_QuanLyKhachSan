package BUS.IServices;

import javax.swing.JTable;
import javax.swing.JTextField;

public interface IQLLoaiPhongServices {

    public void fillToTable(JTable tb);

    public void add(JTextField maLoaiPhong, JTextField tenLoaiPhong, JTextField giaTheoGio, JTextField giaTheoNgay);

}
