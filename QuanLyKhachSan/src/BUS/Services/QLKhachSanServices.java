package BUS.Services;

import BUS.IServices.IQLKhachSanServices;
import BUS.Model.QuanLyPhongKhachSan;
import DAL.Entities.ChiTietHoaDon;
import DAL.Entities.Phong;
import DAL.Entities.Tang;
import DAL.IServices.IChiTietHoaDonServices;
import DAL.IServices.IPhongServices;
import DAL.IServices.IQuanLyPhongKhachSanServices;
import DAL.IServices.ITangServices;
import DAL.Services.ChiTietHoaDonServices;
import DAL.Services.PhongServices;
import DAL.Services.QuanLyPhongKhachServices;
import DAL.Services.TangServices;
import PL.GUI.Frm_CheckIn;
import PL.GUI.Frm_CheckOut;
import PL.GUI.Frm_ChuyenPhong;
import PL.GUI.Frm_DichVu;
import PL.GUI.Frm_DichVu_PhongDangSuDung;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class QLKhachSanServices implements IQLKhachSanServices {

    ITangServices _iTang = new TangServices();
    IPhongServices _iPhong = new PhongServices();
    IQuanLyPhongKhachSanServices _iQuanLyPhongKhachSan = new QuanLyPhongKhachServices();
    IChiTietHoaDonServices _iChiTietHoaDon = new ChiTietHoaDonServices();

    @Override
    public void fillTang(JPanel pn, JPanel pn1, JLabel lbl1, JLabel lbl2, JLabel lbl3, JFrame frm) {
        List<Tang> _listTang = _iTang.getListTang();
        int _soLuong = _listTang.size();
        pn.setLayout(new GridLayout(_soLuong, 1, 10, 10));
        JButton[] btn = new JButton[_soLuong];
        for (Tang list : _listTang) {
            int i = 0;
            btn[i] = new javax.swing.JButton("Tầng " + list.getSoTang());
            btn[i].setFont(new java.awt.Font("Times New Roman", 1, 20));
            Insets is = new Insets(10, 10, 10, 10);
            btn[i].setMargin(is);
            pn.add(btn[i]);
            pn.updateUI();
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    fillPhong(pn1, list.getSoTang(), lbl1, lbl2, lbl3, frm);
                }
            });
        }
    }

    @Override
    public void fillPhong(JPanel pn, int soTang, JLabel lbl1, JLabel lbl2, JLabel lbl3, JFrame frm) {
        List<QuanLyPhongKhachSan> _listPhong = _iQuanLyPhongKhachSan.getListPhong();
        pn.removeAll();
        pn.updateUI();
        int _soLuong = 0;
        for (QuanLyPhongKhachSan list : _listPhong) {
            if (list.getSoTang() == soTang) {
                _soLuong++;
            }
        }
        if (_soLuong % 5 == 0) {
            pn.setLayout(new GridLayout(_soLuong / 5, 4, 5, 5));
        } else {
            pn.setLayout(new GridLayout(_soLuong / 5 + 1, 4, 5, 5));
        }
        JButton[] btn = new JButton[_soLuong];
        int trangThai1 = 0;
        int trangThai2 = 0;
        int trangThai3 = 0;
        for (QuanLyPhongKhachSan lst : _listPhong) {
            int i = 0;
            
            if (lst.getSoTang() == soTang) {
                btn[i] = new javax.swing.JButton();
                btn[i].setFont(new java.awt.Font("Times New Roman", 1, 20));
                Insets is = new Insets(100, 5, 100, 5);
                btn[i].setMargin(is);

                Insets is1 = new Insets(10, 10, 10, 10);
                JPopupMenu pm = new JPopupMenu();
                JMenuItem mi1 = new JMenuItem("Check In!");
                mi1.setFont(new Font("Tahoma", Font.PLAIN, 16));
                mi1.setMargin(is1);
                JMenuItem mi2 = new JMenuItem("Check Out!");
                mi2.setFont(new Font("Tahoma", Font.PLAIN, 16));
                mi2.setMargin(is1);
                JMenuItem mi3 = new JMenuItem("Dịch Vụ!");
                mi3.setFont(new Font("Tahoma", Font.PLAIN, 16));
                mi3.setMargin(is1);
                JMenuItem mi4 = new JMenuItem("Chuyển Phòng!");
                mi4.setFont(new Font("Tahoma", Font.PLAIN, 16));
                mi4.setMargin(is1);
                JMenuItem mi5 = new JMenuItem("Dọn Phòng!");
                mi5.setFont(new Font("Tahoma", Font.PLAIN, 16));
                mi5.setMargin(is1);
                pm.add(mi1);
                pm.add(mi2);
                pm.add(mi3);
                pm.add(mi4);
                pm.add(mi5);

                if (lst.getTrangThai() == 1) {
                    btn[i].setBackground(new Color(29, 209, 161));
                    btn[i].setText("<html><div style=\"text-align: center;\">Phòng " + lst.getMaPhong() + "<bt> <br>" + "<br>(" + lst.getTenLoaiPhong() + ")<br>" + "<bt> <br>" + "Đang trống</div></html>");
                    trangThai1++;
                    mi1.setEnabled(true);
                    mi2.setEnabled(false);
                    mi3.setEnabled(false);
                    mi4.setEnabled(false);
                    mi5.setEnabled(false);
                }
                if (lst.getTrangThai() == 2) {
                    btn[i].setBackground(new Color(255, 107, 107));
                    btn[i].setText("<html><div style=\"text-align: center;\">Phòng " + lst.getMaPhong() + "<bt> <br>" + "<br>(" + lst.getTenLoaiPhong() + ")<br>" + "<bt> <br>" + "Đã có người ở</div></html>");
                    trangThai2++;
                    mi1.setEnabled(false);
                    mi2.setEnabled(true);
                    mi3.setEnabled(true);
                    mi4.setEnabled(true);
                    mi5.setEnabled(false);
                }
                if (lst.getTrangThai() == 3) {
                    btn[i].setBackground(new Color(72, 219, 251));
                    btn[i].setText("<html><div style=\"text-align: center;\">Phòng " + lst.getMaPhong() + "<bt> <br>" + "<br>(" + lst.getTenLoaiPhong() + ")<br>" + "<bt> <br>" + "Đang được dọn dẹp</div></html>");
                    trangThai3++;
                    mi1.setEnabled(false);
                    mi2.setEnabled(false);
                    mi3.setEnabled(false);
                    mi4.setEnabled(false);
                    mi5.setEnabled(true);
                }
                pn.add(btn[i]);
                pn.updateUI();
//                btn[i].addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        if (lst.getTrangThai() == 1) {
//                            JOptionPane.showMessageDialog(null, "Phòng trống!");
//                        }
//                        if (lst.getTrangThai() == 2) {
//                            JOptionPane.showMessageDialog(null, "Phòng đã có người ở!");
//                        }
//                        if (lst.getTrangThai() == 3) {
//                            JOptionPane.showMessageDialog(null, "Phòng đang dọn dẹp!");
//                            int check = JOptionPane.showConfirmDialog(null, "Hoàn thành dọn dẹp?");
//                            if (check != JOptionPane.YES_OPTION) {
//                                return;
//                            }
//                            lst.setTrangThai(1);
//                        }
//                        fillPhong(pn, soTang, lbl1, lbl2, lbl3);
//                    }
//                });
                class PopClickListener extends MouseAdapter {

                    public void mousePressed(MouseEvent e) {
                        if (e.isPopupTrigger()) {
                            doPop(e);
                        }
                    }

                    public void mouseReleased(MouseEvent e) {
                        if (e.isPopupTrigger()) {
                            doPop(e);
                        }
                    }

                    private void doPop(MouseEvent e) {
                        pm.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
                btn[i].addMouseListener(new PopClickListener());
                mi1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Frm_CheckIn checkIn = new Frm_CheckIn(frm, true, lst.getMaPhong());
                        checkIn.setVisible(true);
                    }
                });
                mi2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Frm_CheckOut checkOut = new Frm_CheckOut(frm, true);
                        checkOut.setVisible(true);
                    }
                });
                mi3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Frm_DichVu_PhongDangSuDung dichVu = new Frm_DichVu_PhongDangSuDung(frm, true, lst.getMaPhong());
                        dichVu.setVisible(true);
                    }
                });
                mi4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Frm_ChuyenPhong chuyenPhong = new Frm_ChuyenPhong(frm, true);
                        chuyenPhong.setVisible(true);
                    }
                });
            }
            i++;
        }
        lbl1.setText("Phòng trống (" + trangThai1 + ")");
        lbl2.setText("Phòng đã có người ở (" + trangThai2 + ")");
        lbl3.setText("Phòng đang dọn dẹp (" + trangThai3 + ")");
    }
}
