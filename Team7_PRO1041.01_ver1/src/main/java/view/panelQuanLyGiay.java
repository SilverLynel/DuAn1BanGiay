/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domain_model.DeGiay;
import domain_model.GiayCT;
import domain_model.KieuDang;
import domain_model.LoaiGiay;
import domain_model.MauSac;
import domain_model.NhanHieu;
import domain_model.Size;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import service.GiayCTService;
import service.impl.DeGiayService;
import service.impl.GiayCTServiceImpl;
import service.impl.KieuDangService;
import service.impl.LoaiGiayService;
import service.impl.MauSacService;
import service.impl.NhanHieuService;
import service.impl.SizeService;

/**
 * @author Admin
 */
public class panelQuanLyGiay extends javax.swing.JPanel {

    /**
     * Creates new form panelQuanLyGiay
     */
    private List<GiayCT> list;
    private final GiayCTService giayCTService;
    private MauSacService mauSacService = new MauSacService();
    private SizeService service = new SizeService();
    private DeGiayService deGiayService = new DeGiayService();
    private LoaiGiayService giayService = new LoaiGiayService();
    private NhanHieuService hieuService = new NhanHieuService();
    private KieuDangService dangService = new KieuDangService();

    public panelQuanLyGiay() {
        initComponents();

        giayCTService = new GiayCTServiceImpl();

        loadcbbMau(mauSacService.listcbbMau());
        loadcbbSize(service.listcbbSize());
        loadcbbChatLieu(deGiayService.listcbbChatLieu());
        //loadcbbChieuCaoDe(deGiayService.listcbbChieuCaoDe());
        loadcbbLoaiGiay(giayService.listcbbLoaiGiay());
        loadcbbNhanHieu(hieuService.listcbbNhanHieu());
        loadcbbKieuDang(dangService.listcbbKieuDang());
        loadcbbTrangThai();

        loadTable(giayCTService.getAll());
    }

    private void loadcbbTrangThai() {
        cbbTrangThai.removeAllItems();
        cbbTrangThai.addItem("Ngừng sử dụng");
        cbbTrangThai.addItem("Đang sử dụng");
    }

    public void loadcbbMau(List<String> list) {
        DefaultComboBoxModel dcbmch = (DefaultComboBoxModel) cbbMau.getModel();
        cbbMau.removeAllItems();
        for (String string : list) {
            dcbmch.addElement(string);
        }
    }

    public void loadcbbSize(List<Float> list) {
        DefaultComboBoxModel dcbmch = (DefaultComboBoxModel) cbbSize.getModel();
        cbbSize.removeAllItems();
        for (Float f : list) {
            dcbmch.addElement(f);
        }
    }

    public void loadcbbChatLieu(List<Float> list) {
        DefaultComboBoxModel dcbmch = (DefaultComboBoxModel) cbbChieuCaoDe.getModel();
        cbbChieuCaoDe.removeAllItems();
        for (Float string : list) {
            dcbmch.addElement(string);
        }
    }
//    public void loadcbbChieuCaoDe(List<String> list) {
//        DefaultComboBoxModel dcbmch = (DefaultComboBoxModel) cbbChieuCaoDe.getModel();
//        cbbChieuCaoDe.removeAllItems();
//        for (String string : list) {
//            dcbmch.addElement(string);
//        }
//    }

    public void loadcbbLoaiGiay(List<String> list) {
        DefaultComboBoxModel dcbmch = (DefaultComboBoxModel) cbbLoai.getModel();
        cbbLoai.removeAllItems();
        for (String string : list) {
            dcbmch.addElement(string);
        }
    }

    public void loadcbbNhanHieu(List<String> list) {
        DefaultComboBoxModel dcbmch = (DefaultComboBoxModel) cbbNhanHieu.getModel();
        cbbNhanHieu.removeAllItems();
        for (String string : list) {
            dcbmch.addElement(string);
        }
    }

    public void loadcbbKieuDang(List<String> list) {
        DefaultComboBoxModel dcbmch = (DefaultComboBoxModel) cbbKieuDang.getModel();
        cbbKieuDang.removeAllItems();
        for (String string : list) {
            dcbmch.addElement(string);
        }
    }

    private void loadTable(List<GiayCT> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tableGiayCT.getModel();
        dtm.setRowCount(0);
        for (GiayCT ct : list) {
            Object[] rowData = {
                    ct.getIdGiayCT(),
                    ct.getMaGiayCT(),
                    ct.getTenGiay(),
                    ct.getGiaNhap(),
                    ct.getGiaBan(),
                    ct.getSoLuongTon(),
                    ct.getMoTa(),
                    ct.getLoaiGiay().getTenLoai(),
                    ct.getMauSac().getTenMau(),
                    ct.getSize().getSize(),
                    ct.getNhanHieu().getTenNhanHieu(),
                    ct.getKieuDang().getTenKieuDang(),
                    ct.getDeGiay().getChieuCaoDe(),
                    ct.getDeGiay().getChatLieu(),
                    ct.getAnh(),
                    ct.getTrangThai() == 0 ? "Ngừng sử dụng" : "Đang sử dụng"
            };
            dtm.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnImgGiay = new javax.swing.JPanel();
        lbImgGiay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbLoai = new javax.swing.JComboBox<>();
        cbbKieuDang = new javax.swing.JComboBox<>();
        cbbNhanHieu = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        cbbMau = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        taMoTa = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cbbChieuCaoDe = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableGiayCT = new javax.swing.JTable();
        btnChonAnh = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setEnabled(false);
        jPanel1.setFocusable(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(1322, 743));
        jPanel1.setPreferredSize(new java.awt.Dimension(1275, 790));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnImgGiay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnImgGiayMouseClicked(evt);
            }
        });

        lbImgGiay.setText("IMG");
        lbImgGiay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnImgGiayLayout = new javax.swing.GroupLayout(pnImgGiay);
        pnImgGiay.setLayout(pnImgGiayLayout);
        pnImgGiayLayout.setHorizontalGroup(
                pnImgGiayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbImgGiay, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
        );
        pnImgGiayLayout.setVerticalGroup(
                pnImgGiayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbImgGiay, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );

        jPanel1.add(pnImgGiay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jLabel1.setText("Tên giày");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, -1, -1));
        jPanel1.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 329, -1));

        jLabel2.setText("Giá nhập");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, -1, -1));
        jPanel1.add(txtGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 329, -1));
        jPanel1.add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, 329, -1));

        jLabel3.setText("Giá bán");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, -1, -1));
        jPanel1.add(txtSoLuongTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 329, -1));

        jLabel4.setText("Số lượng tồn");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 570, -1, -1));

        jLabel5.setText("Loại");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, -1, -1));

        cbbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel1.add(cbbLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 610, 329, -1));

        cbbKieuDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel1.add(cbbKieuDang, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 490, 329, -1));

        cbbNhanHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel1.add(cbbNhanHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 650, 329, -1));

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel1.add(cbbSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, 329, -1));

        cbbMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel1.add(cbbMau, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 410, 329, -1));

        taMoTa.setColumns(20);
        taMoTa.setRows(5);
        jScrollPane1.setViewportView(taMoTa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 610, 329, 70));

        jLabel6.setText("Nhãn hiệu");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 650, -1, -1));

        jLabel7.setText("Màu");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 410, -1, -1));

        jLabel8.setText("Kiểu dáng");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, -1, -1));

        jLabel9.setText("Size");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, -1, -1));

        jLabel11.setText("Mô tả");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 610, -1, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 690, -1, -1));

        jLabel14.setText("Chiều cao đế");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, -1, -1));

        cbbChieuCaoDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel1.add(cbbChieuCaoDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, 329, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("QUẢN LÝ GIÀY");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 130, 20));

        tableGiayCT.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
                },
                new String[]{
                        "ID", "Mã	", "Tên	", "Giá nhập", "Giá bán	", "Số lượng tồn	", "Mô tả		", "Loại", "Màu sắc", "Size", "Nhãn hiệu", "Kiểu dáng", "Chiều cao đế", "Chất liệu", "Ảnh", "Trạng thái"
                }
        ));
        tableGiayCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGiayCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableGiayCT);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1450, 310));

        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });
        jPanel1.add(btnChonAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 570, 140, -1));

        jLabel15.setText("Chọn ảnh");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 570, -1, -1));
        jPanel1.add(txtMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 329, -1));

        jLabel12.setText("Mã");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 690, -1, -1));

        jLabel16.setText("Trạng thái");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 570, -1, -1));

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel1.add(cbbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(1102, 570, 120, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Danh mục");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Sản phẩm");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(50, 50, 50)
                                .addComponent(jButton1)
                                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(11, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1486, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnImgGiayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnImgGiayMouseClicked

    }//GEN-LAST:event_pnImgGiayMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        GiayCT ct = new GiayCT();

        String ma = txtMa.getText();
        String ten = txtTen.getText();
        String giaNhapStr = txtGiaNhap.getText();
        String giaBanStr = txtGiaBan.getText();
        String slTonStr = txtSoLuongTon.getText();
        String moTa = taMoTa.getText();
        int trangThai = cbbTrangThai.getSelectedIndex();

        String loaiStr = (String) cbbLoai.getSelectedItem();
        String nhanHieuStr = (String) cbbNhanHieu.getSelectedItem();
        String kieuDangStr = (String) cbbKieuDang.getSelectedItem();
        String mauSacStr = (String) cbbMau.getSelectedItem();
        Float chieuCaoDe = (Float) cbbChieuCaoDe.getSelectedItem();
        String sizeStr = cbbSize.getSelectedItem() + "";

        LoaiGiay l = giayService.getOne(loaiStr);
        NhanHieu nh = hieuService.getOne(nhanHieuStr);
        MauSac ms = mauSacService.getOne(mauSacStr);
        KieuDang kd = dangService.getOne(kieuDangStr);
        Size size = service.getOne(Float.valueOf(sizeStr));
        DeGiay dg = deGiayService.getOne(Float.valueOf(chieuCaoDe));

        ct = new GiayCT(ma, ten, new BigDecimal(giaNhapStr), new BigDecimal(giaBanStr), Integer.parseInt(slTonStr), tenAnh, moTa, trangThai, l, ms, size, nh, kd, dg, dg);

        giayCTService.add(ct);
        loadTable(giayCTService.getAll());
    }//GEN-LAST:event_btnThemActionPerformed

    private void tableGiayCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGiayCTMouseClicked
        // TODO add your handling code here:
        int row = tableGiayCT.getSelectedRow();
        GiayCT giay = giayCTService.getAll().get(row);
        txtMa.setText(giay.getMaGiayCT());
        txtTen.setText(giay.getTenGiay());
        txtGiaNhap.setText(giay.getGiaNhap() + "");
        txtGiaBan.setText(giay.getGiaBan() + "");
        txtSoLuongTon.setText(String.valueOf(giay.getSoLuongTon()));
        cbbLoai.setSelectedItem(giay.getLoaiGiay().getTenLoai());
        cbbNhanHieu.setSelectedItem(giay.getNhanHieu().getTenNhanHieu());
        cbbKieuDang.setSelectedItem(giay.getKieuDang().getTenKieuDang());
        cbbMau.setSelectedItem(giay.getMauSac().getTenMau());
        cbbSize.setSelectedItem(giay.getSize().getIdSize());
        cbbTrangThai.setSelectedIndex(giay.getTrangThai());
        //        cbbChieuCaoDe.setSelectedItem(giay.getDeGiay().getChieuCaoDe());
        cbbChieuCaoDe.setSelectedItem(giay.getDeGiay().getChieuCaoDe());
        taMoTa.setText(giay.getMoTa());

        lbImgGiay.setText("");
        URL url = getClass().getResource("/Images/" + giay.getAnh());
        ImageIcon icon = new ImageIcon(url);
        tenAnh = giay.getAnh();
        lbImgGiay.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lbImgGiay.getWidth(), lbImgGiay.getHeight(), 0)));
    }//GEN-LAST:event_tableGiayCTMouseClicked

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lbImgGiay.getWidth(), lbImgGiay.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    String tenAnh;

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser f = new JFileChooser("C:\\Users\\PhiLT\\Documents\\DuAn1\\Team7_PRO1041.01_ver1\\src\\main\\resources\\Images");
            f.setDialogTitle("Mở file");
            f.showOpenDialog(null);
            File fTenAnh = f.getSelectedFile();
            Image img = ImageIO.read(fTenAnh);
            tenAnh = fTenAnh.getName();
            if (tenAnh != null) {
                lbImgGiay.setText("");
                lbImgGiay.setIcon(new ImageIcon(img.getScaledInstance(lbImgGiay.getWidth(), lbImgGiay.getHeight(), 0)));
            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn ảnh");
            }
        } catch (Exception e) {
            System.out.println("Chưa chọn ảnh");
            System.out.println(tenAnh);
        }
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:

        GiayCT ct = new GiayCT();
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        String giaNhapStr = txtGiaNhap.getText();
        String giaBanStr = txtGiaBan.getText();
        String slTonStr = txtSoLuongTon.getText();
        String moTa = taMoTa.getText();
        int trangThai = cbbTrangThai.getSelectedIndex();

        String loaiStr = (String) cbbLoai.getSelectedItem();
        String nhanHieuStr = (String) cbbNhanHieu.getSelectedItem();
        String kieuDangStr = (String) cbbKieuDang.getSelectedItem();
        String mauSacStr = (String) cbbMau.getSelectedItem();
        Float chieuCaoDe = (Float) cbbChieuCaoDe.getSelectedItem();
        String sizeStr = cbbSize.getSelectedItem() + "";

        LoaiGiay l = giayService.getOne(loaiStr);
        NhanHieu nh = hieuService.getOne(nhanHieuStr);
        MauSac ms = mauSacService.getOne(mauSacStr);
        KieuDang kd = dangService.getOne(kieuDangStr);
        Size size = service.getOne(Float.valueOf(sizeStr));
        DeGiay dg = deGiayService.getOne(Float.valueOf(chieuCaoDe));

        ct = new GiayCT(ma, ten, new BigDecimal(giaNhapStr), new BigDecimal(giaBanStr), Integer.parseInt(slTonStr), tenAnh, moTa, trangThai, l, ms, size, nh, kd, dg, dg);

        for (GiayCT g : giayCTService.getAll()) {
            if (g.getMaGiayCT().equals(ma)) {
                ct.setIdGiayCT(g.getIdGiayCT());
            }
        }

        giayCTService.update(ct);
        loadTable(giayCTService.getAll());
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        panelDanhMucSP viewDMSP = new panelDanhMucSP();
        this.removeAll();
        ;
        this.add(viewDMSP);
        this.validate();
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbChieuCaoDe;
    private javax.swing.JComboBox<String> cbbKieuDang;
    private javax.swing.JComboBox<String> cbbLoai;
    private javax.swing.JComboBox<String> cbbMau;
    private javax.swing.JComboBox<String> cbbNhanHieu;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbImgGiay;
    private javax.swing.JPanel pnImgGiay;
    private javax.swing.JTextArea taMoTa;
    private javax.swing.JTable tableGiayCT;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables


}
