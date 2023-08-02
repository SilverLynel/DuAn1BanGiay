/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domain_model.GiayCT;
import domain_model.KhuyenMai;
import domain_model.KhuyenMaiGiay;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import repository.GiayCTBanHangRepository;
import repository.IGiayCTBanHangRepository;
import repository.KhuyenMaiRepo;
import repository.KhuyenMaiRepoImpl;

/**
 * @author PhiLT
 */
public class pnKhuyenMai extends javax.swing.JPanel {

    //MessagePane MSG = new MessagePane();
    private KhuyenMaiRepo khuyenMaiRepo = new KhuyenMaiRepoImpl();
    private IGiayCTBanHangRepository giayChiTietRepo = new GiayCTBanHangRepository();
    private List<KhuyenMai> listKM = new ArrayList<>();
    private List<KhuyenMaiGiay> listGiayKM = new ArrayList<>();
    private List<GiayCT> listGiayCT = new ArrayList<>();

    private DefaultTableModel modelTBKM;
    private DefaultTableModel modelTBGiayKM;
    private DefaultTableModel modelTBGiayCT;

    public pnKhuyenMai() {
        initComponents();
        loadTableGiayKM();
        loadTableKM();
        loadCBB();
        loadTableGiayCT();

        checkHanKM();
    }

    //check han khuyen mai
    private void checkHanKM() {
        for (KhuyenMai km : listKM) {
            if (km.getNgayKetThuc().compareTo(new Date()) >= 0) {
//                km.setTrangThai(true);
//                khuyenMaiRepo.updateKM(km);
            } else {
                km.setTrangThai(0);
                khuyenMaiRepo.updateKM(km);
            }
        }
    }

    private void checkTrangThaiGiayKM() {
        for (KhuyenMaiGiay g : listGiayKM) {
            if (g.getKhuyenMai().getTrangThai() == 0) {
                g.setTrangThai(false);
                khuyenMaiRepo.updateGiayKM(g);
            }
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

        popUpMenu = new javax.swing.JPopupMenu();
        delete = new javax.swing.JMenuItem();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenKM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKM = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtSearchKM = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDieuKien = new javax.swing.JTextField();
        txtPhamTramGiam = new javax.swing.JTextField();
        btnThemKM = new javax.swing.JButton();
        dcsNgayKetThuc = new com.toedter.calendar.JDateChooser();
        dcsNgayBatDau = new com.toedter.calendar.JDateChooser();
        updateKM = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbGiayKM = new javax.swing.JTable();
        txtSearSanPhamKM = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        huyGiayKM = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbGiay = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtSearchSanPham = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        themGiayVaoKM = new javax.swing.JButton();

        popUpMenu.setBackground(new java.awt.Color(255, 255, 255));
        popUpMenu.setPreferredSize(new java.awt.Dimension(200, 50));

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        delete.setText("Xóa");
        delete.setToolTipText("");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        popUpMenu.add(delete);

        setBackground(new java.awt.Color(255, 204, 204));
        setEnabled(false);
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(1322, 743));
        setPreferredSize(new java.awt.Dimension(1275, 790));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Quản lý khuyến mại");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 180, 20));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Tên");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, -1, -1));
        jPanel1.add(txtTenKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 329, -1));

        jLabel3.setText("Ngày bắt đầu");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 90, -1, -1));

        jLabel4.setText("Ngày kết thúc");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 130, -1, -1));

        jLabel5.setText("Phần trăm giảm");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 170, -1, -1));

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel1.add(cbbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 250, 329, -1));

        jLabel6.setText("Điều kiện");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, -1, -1));

        jLabel8.setText("Trạng thái");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 250, -1, -1));

        jScrollPane2.setBorder(null);

        tbKM.setAutoCreateRowSorter(true);
        tbKM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbKM.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Mã", "Tên", "Ngày bắt đầu", "Ngày kết thúc", "Phần trăm giảm", "Điều kiện", "Trạng thái"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbKM.setGridColor(new java.awt.Color(255, 255, 255));
        tbKM.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbKM.setRowHeight(43);
        tbKM.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tbKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKMMouseClicked(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbKMMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbKM);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 860, 340));

        jLabel10.setText("Tìm kiếm");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 60, -1));

        txtSearchKM.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchKMCaretUpdate(evt);
            }
        });
        jPanel1.add(txtSearchKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 240, -1));

        jLabel7.setText("Thông tin khuyến mại");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(txtDieuKien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 210, 329, -1));
        jPanel1.add(txtPhamTramGiam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 329, -1));

        btnThemKM.setText("Thêm");
        btnThemKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKMActionPerformed(evt);
            }
        });
        jPanel1.add(btnThemKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 340, -1, -1));
        jPanel1.add(dcsNgayKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 130, 330, -1));
        jPanel1.add(dcsNgayBatDau, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, 330, -1));

        updateKM.setText("Cập nhật");
        updateKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateKMActionPerformed(evt);
            }
        });
        jPanel1.add(updateKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 340, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1480, 400));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(null);

        tbGiayKM.setAutoCreateRowSorter(true);
        tbGiayKM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbGiayKM.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, new Boolean(true)},
                        {null, null, null, null, new Boolean(true)},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Tên giày", "Tên khuyến mại", "Giá bán", "Giá khuyến mại", "Trạng thái"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbGiayKM.setGridColor(new java.awt.Color(255, 255, 255));
        tbGiayKM.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbGiayKM.setRowHeight(43);
        tbGiayKM.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tbGiayKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbGiayKMMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbGiayKM);

        txtSearSanPhamKM.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearSanPhamKMCaretUpdate(evt);
            }
        });

        jLabel16.setText("Tìm kiếm");

        huyGiayKM.setText("Cập nhật");
        huyGiayKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyGiayKMActionPerformed(evt);
            }
        });

        jLabel9.setText("Sản phẩm khuyến mại");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(huyGiayKM)
                                .addGap(28, 28, 28))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 7, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearSanPhamKM, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap(28, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtSearSanPhamKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel16))
                                                .addGap(12, 12, 12)))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(huyGiayKM)
                                .addContainerGap())
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 470, 640, 420));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane4.setBorder(null);

        tbGiay.setAutoCreateRowSorter(true);
        tbGiay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbGiay.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null}
                },
                new String[]{
                        "Mã", "Tên giày", "Giá bán", "Loại giày", "Màu", "Size", "Nhãn hiệu", "Kiểu dáng", "Chiều cao đế", "Chọn"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbGiay.setGridColor(new java.awt.Color(255, 255, 255));
        tbGiay.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbGiay.setRowHeight(43);
        tbGiay.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tbGiay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbGiayMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbGiay);

        jLabel11.setText("Sản phẩm");

        txtSearchSanPham.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchSanPhamCaretUpdate(evt);
            }
        });

        jLabel1.setText("Tìm kiếm");

        themGiayVaoKM.setText("Thêm");
        themGiayVaoKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themGiayVaoKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(themGiayVaoKM)
                                                .addGap(30, 30, 30))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtSearchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSearchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(themGiayVaoKM)
                                .addGap(5, 5, 5))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 830, 420));
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbKM.getModel();
        int row = tbKM.getSelectedRow();
        if (row != -1) {
            // model.removeRow(row);
        }
    }//GEN-LAST:event_deleteActionPerformed

    //load combobox
    private void loadCBB() {
        cbbTrangThai.removeAllItems();
        cbbTrangThai.addItem("Đang sử dụng");
        cbbTrangThai.addItem("Ngừng sử dụng");
    }

    private void loadTableKM() {
        listKM = khuyenMaiRepo.getAllKM();
        checkHanKM();
        modelTBKM = (DefaultTableModel) tbKM.getModel();
        modelTBKM.setRowCount(0);
        for (KhuyenMai k : listKM) {
            modelTBKM.addRow(new Object[]{
                    k.getMa(),
                    k.getTen(),
                    k.getNgayBatDau(),
                    k.getNgayKetThuc(),
                    k.getPhanTramGiam(),
                    k.getDieuKien(),
                    k.getTrangThai() > 0 ? "Đang sử dụng" : "Ngừng sử dụng"
            });
        }
    }

    private void loadTableGiayKM() {
        listGiayKM = khuyenMaiRepo.getAllGiayKM(idKM);
        checkTrangThaiGiayKM();
        modelTBGiayKM = (DefaultTableModel) tbGiayKM.getModel();
        modelTBGiayKM.setRowCount(0);
        for (KhuyenMaiGiay g : listGiayKM) {
            modelTBGiayKM.addRow(new Object[]{
                    g.getGiayCT().getTenGiay(),
                    g.getKhuyenMai().getTen(),
                    g.getGiayCT().getGiaBan(),
                    g.getGiaKM(),
                    g.isTrangThai()
            });
        }
    }

    private void loadTableGiayCT() {
        modelTBGiayCT = (DefaultTableModel) tbGiay.getModel();
        listGiayCT = giayChiTietRepo.getAllGiayCT();

        modelTBGiayCT.setRowCount(0);
        boolean check;
        if (!listGiayKM.isEmpty()) {
            for (GiayCT g : listGiayCT) {
                check = true;
                for (KhuyenMaiGiay gkm : listGiayKM) {
                    if (gkm.getGiayCT().getIdGiayCT() == g.getIdGiayCT()) {
                        check = false;
                        break;
                    }
                }
                if (check == true) {
                    modelTBGiayCT.addRow(new Object[]{
                            g.getMaGiayCT(),
                            g.getTenGiay(), g.getGiaBan(),
                            g.getLoaiGiay().getTenLoai(),
                            g.getMauSac().getTenMau(),
                            g.getSize().getSize(),
                            g.getNhanHieu().getTenNhanHieu(),
                            g.getKieuDang().getTenKieuDang(),
                            g.getDeGiay().getChieuCaoDe()
                    });
                }
            }
        } else {

            for (GiayCT g : listGiayCT) {

                modelTBGiayCT.addRow(new Object[]{
                        g.getMaGiayCT(),
                        g.getTenGiay(), g.getGiaBan(),
                        g.getLoaiGiay().getTenLoai(),
                        g.getMauSac().getTenMau(),
                        g.getSize().getSize(),
                        g.getNhanHieu().getTenNhanHieu(),
                        g.getKieuDang().getTenKieuDang(),
                        g.getDeGiay().getChieuCaoDe()
                });
            }

        }
    }

    private void tbKMMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKMMouseReleased


    }//GEN-LAST:event_tbKMMouseReleased

    private void tbGiayKMMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGiayKMMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbGiayKMMouseReleased

    private void btnThemKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKMActionPerformed
        try {
            // TODO add your handling code here:
            if (khuyenMaiRepo.addKM(createKhuyenMai())) {
                loadTableKM();
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnThemKMActionPerformed

    private int idKM = -1;

    private void tbKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKMMouseClicked
        // TODO add your handling code here:
        int rowSelected = tbKM.getSelectedRow();
        String ma = tbKM.getValueAt(rowSelected, 0).toString();
        for (KhuyenMai k : listKM) {
            if (k.getMa().equals(ma)) {
                idKM = k.getIdKhuyenMai();
                txtTenKM.setText(tbKM.getValueAt(rowSelected, 1).toString());
                dcsNgayBatDau.setDate(k.getNgayBatDau());
                dcsNgayKetThuc.setDate(k.getNgayKetThuc());
                txtPhamTramGiam.setText(k.getPhanTramGiam() + "");
                txtDieuKien.setText(k.getDieuKien());
                cbbTrangThai.setSelectedIndex(k.getTrangThai() == 0 ? 1 : 0);

                loadTableGiayKM();
                loadTableGiayCT();
            }
        }
    }//GEN-LAST:event_tbKMMouseClicked

    private void updateKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateKMActionPerformed
        // TODO add your handling code here:
        KhuyenMai km = new KhuyenMai();
        try {
            km = createKhuyenMai();

            km.setIdKhuyenMai(idKM);
            if (khuyenMaiRepo.updateKM(km)) {
                loadTableKM();
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateKMActionPerformed

    private void huyGiayKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyGiayKMActionPerformed
        // TODO add your handling code here:
        List<String> arrNameHuy = new ArrayList<>();
        List<String> arrNameHD = new ArrayList<>();
        int allRow = tbGiayKM.getRowCount();
        for (int i = 0; i < allRow; i++) {
            if (Boolean.parseBoolean(tbGiayKM.getValueAt(i, 4) + "") == false) {
                arrNameHuy.add(tbGiayKM.getValueAt(i, 0).toString());
            } else {
                arrNameHD.add(tbGiayKM.getValueAt(i, 0).toString());
            }
        }

        for (KhuyenMaiGiay g : listGiayKM) {
            for (String nameHuy : arrNameHuy) {
                if (g.getGiayCT().getTenGiay().equals(nameHuy)) {
                    g.setTrangThai(false);
                    khuyenMaiRepo.updateGiayKM(g);
                }
            }

            for (String nameHD : arrNameHD) {
                if (g.getGiayCT().getTenGiay().equals(nameHD)) {
                    g.setTrangThai(true);
                    khuyenMaiRepo.updateGiayKM(g);
                }
            }
        }
    }//GEN-LAST:event_huyGiayKMActionPerformed

    private void tbGiayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGiayMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbGiayMouseReleased

    private void themGiayVaoKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themGiayVaoKMActionPerformed
        // TODO add your handling code here:
        modelTBGiayCT = (DefaultTableModel) tbGiay.getModel();
        ArrayList<String> arrMa = new ArrayList<>();
        int allRow = modelTBGiayCT.getRowCount();
        for (int i = 0; i < allRow; i++) {
            if (Boolean.parseBoolean(tbGiay.getValueAt(i, 9) + "") == true) {
                arrMa.add(tbGiay.getValueAt(i, 0) + "");
            }
        }

        for (GiayCT g : listGiayCT) {
            for (String ma : arrMa) {
                if (g.getMaGiayCT().equals(ma)) {
                    khuyenMaiRepo.addGiayKM(createGiayKM(g));
                }

            }
        }
        loadTableGiayKM();
    }//GEN-LAST:event_themGiayVaoKMActionPerformed

    private void txtSearchKMCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchKMCaretUpdate
        // TODO add your handling code here:
        String ten = txtSearchKM.getText();
        List<KhuyenMai> list = khuyenMaiRepo.searchKM(ten);
        modelTBKM = (DefaultTableModel) tbKM.getModel();
        modelTBKM.setRowCount(0);
        for (KhuyenMai k : list) {
            modelTBKM.addRow(new Object[]{
                    k.getMa(),
                    k.getTen(),
                    k.getNgayBatDau(),
                    k.getNgayKetThuc(),
                    k.getPhanTramGiam(),
                    k.getDieuKien(),
                    k.getTrangThai() > 0 ? "Đang sử dụng" : "Ngừng sử dụng"
            });
        }
    }//GEN-LAST:event_txtSearchKMCaretUpdate

    private void txtSearSanPhamKMCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearSanPhamKMCaretUpdate
        // TODO add your handling code here:
        String ten = txtSearSanPhamKM.getText();
        List<KhuyenMaiGiay> list = khuyenMaiRepo.searchSPKM(ten);
        modelTBGiayKM = (DefaultTableModel) tbGiayKM.getModel();
        modelTBGiayKM.setRowCount(0);
        for (KhuyenMaiGiay g : list) {
            modelTBGiayKM.addRow(new Object[]{
                    g.getGiayCT().getTenGiay(),
                    g.getKhuyenMai().getTen(),
                    g.getGiayCT().getGiaBan(),
                    g.getGiaKM(),
                    g.isTrangThai()
            });
        }
    }//GEN-LAST:event_txtSearSanPhamKMCaretUpdate

    private void txtSearchSanPhamCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchSanPhamCaretUpdate
        // TODO add your handling code here:
        String ten = txtSearchSanPham.getText();
        List<GiayCT> list = giayChiTietRepo.searchGiayCTByName(ten);

        modelTBGiayCT.setRowCount(0);
        boolean check;
        if (!listGiayKM.isEmpty()) {
            for (GiayCT g : list) {
                check = true;
                for (KhuyenMaiGiay gkm : listGiayKM) {
                    if (gkm.getGiayCT().getIdGiayCT() == g.getIdGiayCT()) {
                        check = false;
                        break;
                    }
                }
                if (check == true) {
                    modelTBGiayCT.addRow(new Object[]{
                            g.getMaGiayCT(),
                            g.getTenGiay(), g.getGiaBan(),
                            g.getLoaiGiay().getTenLoai(),
                            g.getMauSac().getTenMau(),
                            g.getSize().getSize(),
                            g.getNhanHieu().getTenNhanHieu(),
                            g.getKieuDang().getTenKieuDang(),
                            g.getDeGiay().getChieuCaoDe()
                    });
                }
            }
        } else {

            for (GiayCT g : listGiayCT) {

                modelTBGiayCT.addRow(new Object[]{
                        g.getMaGiayCT(),
                        g.getTenGiay(), g.getGiaBan(),
                        g.getLoaiGiay().getTenLoai(),
                        g.getMauSac().getTenMau(),
                        g.getSize().getSize(),
                        g.getNhanHieu().getTenNhanHieu(),
                        g.getKieuDang().getTenKieuDang(),
                        g.getDeGiay().getChieuCaoDe()
                });
            }

        }
    }//GEN-LAST:event_txtSearchSanPhamCaretUpdate

    //create giay khuyen mai
    private KhuyenMaiGiay createGiayKM(GiayCT giay) {
        KhuyenMai khuyenMai = khuyenMaiRepo.getOne(idKM);
        BigDecimal giaKM = giay.getGiaBan().subtract(giay.getGiaBan().multiply(BigDecimal.valueOf(khuyenMai.getPhanTramGiam() / 100)));
        return new KhuyenMaiGiay(giay, khuyenMai, giay.getGiaBan(), giaKM, true);
    }

    //create Hkhuyen mai
    private SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");

    private KhuyenMai createKhuyenMai() throws ParseException {
        String ten = txtTenKM.getText();
        Date ngayBD = dcsNgayBatDau.getDate();
        Date ngayKT = dcsNgayKetThuc.getDate();
        String ngayBDStr = dfm.format(ngayBD);
        String ngayKTStr = dfm.format(ngayKT);
        String phamTramGiam = txtPhamTramGiam.getText();
        String dieuKien = txtDieuKien.getText();
        Integer trangThai = cbbTrangThai.getSelectedIndex() == 0 ? 1 : 0;
        System.out.println("===============" + trangThai);
        return new KhuyenMai(genMaKM(listKM), ten, dfm.parse(ngayBDStr), dfm.parse(ngayKTStr), Float.parseFloat(phamTramGiam), dieuKien, trangThai);
    }

    //gen mã
    private String genMaKM(List<KhuyenMai> list) {
        int max = 0;
        int check = 0;
        for (KhuyenMai k : list) {
            check = Integer.parseInt(k.getMa().substring(2));
            if (check > max) {
                max = check;
            }
        }
        max++;
        return "KM" + max;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemKM;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private com.toedter.calendar.JDateChooser dcsNgayBatDau;
    private com.toedter.calendar.JDateChooser dcsNgayKetThuc;
    private javax.swing.JMenuItem delete;
    private javax.swing.JButton huyGiayKM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu popUpMenu;
    private javax.swing.JTable tbGiay;
    private javax.swing.JTable tbGiayKM;
    private javax.swing.JTable tbKM;
    private javax.swing.JButton themGiayVaoKM;
    private javax.swing.JTextField txtDieuKien;
    private javax.swing.JTextField txtPhamTramGiam;
    private javax.swing.JTextField txtSearSanPhamKM;
    private javax.swing.JTextField txtSearchKM;
    private javax.swing.JTextField txtSearchSanPham;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JButton updateKM;
    // End of variables declaration//GEN-END:variables
}
