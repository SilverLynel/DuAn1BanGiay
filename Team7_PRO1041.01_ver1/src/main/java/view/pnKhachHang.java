/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domain_model.KhachHang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import service.KhachHangService;
import service.impl.KhachHangServiceImpl;

/**
 * @author BXT
 */
public class pnKhachHang extends javax.swing.JPanel {
    private KhachHangService ms = new KhachHangServiceImpl();
    private DefaultTableModel model;

    /**
     * Creates new form pnKhachHang
     */
    public pnKhachHang() {
        initComponents();
        loadTable(ms.getList());
    }

    public void loadTable(List<KhachHang> listH) {
        model = (DefaultTableModel) tbl_table.getModel();
        model.setRowCount(0);

        for (KhachHang p : listH) {
            model.addRow(new Object[]{
                    p.getMaKH(),
                    p.getHoTen(),
                    p.isGioiTinh() == true ? "nam" : "nữ",
                    p.getDiaChi(),
                    p.getSdt(),
                    p.getEmail(),
                    p.isTrangThai() == true ? "đang hoạt động" : "ngừng hoạt động",
                    p.getGhiChu()
            });

        }
    }

    public KhachHang getData() {
        KhachHang h = new KhachHang();

        h.setMaKH(txt_ma.getText().trim());
        h.setHoTen(txt_hoTen.getText().trim());
        boolean gioiTinh;
        if (rdo_nam.isSelected()) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }
        h.setGioiTinh(gioiTinh);


        h.setDiaChi(txt_dChi.getText().trim());
        h.setSdt(txt_sdt.getText().trim());
        h.setEmail(txt_email.getText().trim());
        boolean trangThai;
        if (rdo_dhd.isSelected()) {
            trangThai = true;
        } else {
            trangThai = false;
        }
        h.setTrangThai(trangThai);
        h.setGhiChu(txt_ghichu.getText().trim());

        return h;
    }

    public void reset() {
        txt_ma.setText("");
        txt_hoTen.setText("");
        txt_dChi.setText("");
        txt_sdt.setText("");
        txt_email.setText("");
        txt_ghichu.setText("");
    }

    public boolean checkValidate() {
        String dateStr = null;
        if (txt_ma.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
            return false;
        }
        if (txt_hoTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            return false;
        }
        if (rdo_nam.isSelected() == false && rdo_nu.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn giới tính");
            return false;
        }

        if (txt_dChi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "địa chỉ không được để trống");
            return false;
        }
        if (txt_sdt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "số điẹn thoại không được để trống");
            return false;
        }
        try {
            String sdt = txt_sdt.getText();
            Pattern p1 = Pattern.compile("^0\\d{9}$");
            Matcher matcher1 = p1.matcher(sdt);
            if (matcher1.matches() == false) {
                JOptionPane.showMessageDialog(this, "sdt gồm 10 số bắt đầu bằng số 0");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (txt_email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "email không được để trống");
            return false;
        }
        if (rdo_dhd.isSelected() == false && rdo_nhd.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn trang thai");
            return false;
        }

        if (txt_ghichu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ghi chú không được để trống");
            return false;
        }


        return true;
    }

    public boolean checkTrungMa() {
        List<KhachHang> p = ms.getList();
        String ma = txt_ma.getText();
        String sdt = txt_sdt.getText();
        for (KhachHang u : p) {
            if (u.getMaKH().equals(ma)) {
                JOptionPane.showMessageDialog(this, "mã không được trùng");
                return false;
            }
        }
        return true;
    }

    public boolean checkTrungSdt() {
        List<KhachHang> p = ms.getList();
        String sdt = txt_sdt.getText();
        for (KhachHang u : p) {
            if (u.getSdt().equals(sdt)) {
                JOptionPane.showMessageDialog(this, "sdt không được trùng");
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_hoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdo_nam = new javax.swing.JRadioButton();
        rdo_nu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_dChi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ghichu = new javax.swing.JTextArea();
        btn_clear = new javax.swing.JButton();
        rdo_dhd = new javax.swing.JRadioButton();
        rdo_nhd = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Mã");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, -1, -1));
        jPanel2.add(txt_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 50, 300, 30));

        jLabel4.setText("Họ và tên");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, -1, -1));

        txt_hoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hoTenActionPerformed(evt);
            }
        });
        jPanel2.add(txt_hoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 90, 300, 30));

        jLabel5.setText("Giới tính");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 130, -1, -1));

        buttonGroup1.add(rdo_nam);
        rdo_nam.setText("nam");
        rdo_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_namActionPerformed(evt);
            }
        });
        jPanel2.add(rdo_nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 130, -1, -1));

        buttonGroup1.add(rdo_nu);
        rdo_nu.setText("nữ");
        jPanel2.add(rdo_nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 130, -1, -1));

        jLabel7.setText("Địa chỉ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, -1, -1));
        jPanel2.add(txt_sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 230, 300, 30));

        jLabel8.setText("SDT");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 230, -1, 20));

        txt_dChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dChiActionPerformed(evt);
            }
        });
        jPanel2.add(txt_dChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 180, 300, 30));

        jLabel9.setText("Email");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, 60, 20));
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 280, 300, 30));

        jLabel10.setText("Trạng thái");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 340, 62, 20));

        jLabel11.setText("Ghi chú");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 390, 43, 20));

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 580, -1, -1));

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel2.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 580, -1, -1));

        tbl_table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null}
                },
                new String[]{
                        "Mã", "Tên", "Giới tính", "Địa chỉ", "SDT", "Email", "Trạng thái", "Ghi chú"
                }
        ));
        tbl_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_table);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 33, 920, 404));

        txt_ghichu.setColumns(20);
        txt_ghichu.setRows(5);
        jScrollPane2.setViewportView(txt_ghichu);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 390, 300, 90));

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel2.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 580, -1, -1));

        buttonGroup2.add(rdo_dhd);
        rdo_dhd.setText("dhd");
        jPanel2.add(rdo_dhd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 340, -1, 20));

        buttonGroup2.add(rdo_nhd);
        rdo_nhd.setText("nhd");
        rdo_nhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_nhdActionPerformed(evt);
            }
        });
        jPanel2.add(rdo_nhd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 340, -1, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("khách hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(698, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(689, 689, 689))
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdo_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_namActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_namActionPerformed

    private void txt_dChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dChiActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (checkValidate()) {
            if (checkTrungMa()) {
                if (checkTrungSdt()) {
                    KhachHang p = getData();
                    String query = ms.addKhachHang(p);
                    JOptionPane.showMessageDialog(this, query);
                    loadTable(ms.getList());
                    reset();
                }
            }
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed

        Integer row = tbl_table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn dòng trên table");
            return;

        }

        KhachHang h = getData();
        h.setIdKhachHang(ms.getList().get(row).getIdKhachHang());
        String query = ms.updateKhachHang(h);
        JOptionPane.showMessageDialog(this, query);
        loadTable(ms.getList());
    }//GEN-LAST:event_btn_updateActionPerformed

    private void tbl_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tableMouseClicked

        Integer row = tbl_table.getSelectedRow();
        txt_ma.setText(tbl_table.getValueAt(row, 0) + "");
        txt_hoTen.setText(tbl_table.getValueAt(row, 1) + "");
        if (tbl_table.getValueAt(row, 2).equals("nam")) {
            rdo_nam.setSelected(true);
        } else {
            rdo_nu.setSelected(true);
        }

        txt_dChi.setText(tbl_table.getValueAt(row, 3).toString());
        txt_sdt.setText(tbl_table.getValueAt(row, 4).toString());
        txt_email.setText(tbl_table.getValueAt(row, 5).toString());
        if (tbl_table.getValueAt(row, 6).equals("dhd")) {
            rdo_dhd.setSelected(true);
        } else {
            rdo_nhd.setSelected(true);
        }

        txt_ghichu.setText(tbl_table.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tbl_tableMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void rdo_nhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_nhdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_nhdActionPerformed

    private void txt_hoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hoTenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdo_dhd;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_nhd;
    private javax.swing.JRadioButton rdo_nu;
    private javax.swing.JTable tbl_table;
    private javax.swing.JTextField txt_dChi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextArea txt_ghichu;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_sdt;
    // End of variables declaration//GEN-END:variables
}
