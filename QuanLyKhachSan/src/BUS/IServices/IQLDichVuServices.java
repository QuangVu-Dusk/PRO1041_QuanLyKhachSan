
package BUS.IServices;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IQLDichVuServices {
    public void fillToTable(JTable tb);
    public void filltoCombo(JComboBox idloai);
    public void add(JTextField maDichVu,JComboBox maLoaiDichVu, JTextField tenDichVu, JTextField donGia,  JTextArea ghiChu);
    public void edit(JTextField maDichVu,JComboBox maLoaiDichVu, JTextField tenDichVu, JTextField donGia, JTextArea ghiChu);
    public void delete(JTextField maDichVu);
}
