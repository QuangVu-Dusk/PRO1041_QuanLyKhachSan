package BUS.IServices;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public interface IQLKhachSanServices {

    public void fillTang(JPanel pn, JPanel pn1,  JLabel lbl1, JLabel lbl2, JLabel lbl3, JFrame frm);
    public void fillPhong(JPanel pn, int soTang, JLabel lbl1, JLabel lbl2, JLabel lbl3, JFrame frm);
}
