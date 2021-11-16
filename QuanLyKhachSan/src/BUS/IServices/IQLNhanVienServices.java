
package BUS.IServices;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IQLNhanVienServices {
    public void fillToTable(JTable tb);
    public void fillToCombo(JComboBox quyen);
    public void add(JTextField maNhanVien,JPasswordField matKhau, JComboBox quyen);
    public void edit(JTextField maNhanVien,JPasswordField matKhau, JComboBox quyen);
    public void delete(JTextField maNhanVien);
}
