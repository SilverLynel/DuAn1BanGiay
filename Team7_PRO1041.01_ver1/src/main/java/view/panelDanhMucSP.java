/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domain_model.DeGiay;
import domain_model.KieuDang;
import domain_model.LoaiGiay;
import domain_model.MauSac;
import domain_model.NhanHieu;
import domain_model.Size;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import service.impl.DeGiayService;
import service.impl.KieuDangService;
import service.impl.LoaiGiayService;
import service.impl.MauSacService;
import service.impl.NhanHieuService;
import service.impl.SizeService;

/**
 * @author Admin
 */
public class panelDanhMucSP extends javax.swing.JPanel {

    private DefaultTableModel modelDeGiay, modelKieuDang, modelLoaiGiay, modelMauSac, modelNhanHieu, modelSize;

    private List<DeGiay> lstDeGiay;
    private List<KieuDang> lstKieuDang;
    private List<LoaiGiay> lstLoaiGiay;
    private List<MauSac> lstMauSac;
    private List<NhanHieu> lstNhanHieu;
    private List<Size> lstSize;

    private DeGiayService deGiaySv = new DeGiayService();
    private KieuDangService kieuDangSv = new KieuDangService();
    private LoaiGiayService loaiGiaySv = new LoaiGiayService();
    private MauSacService mauSacSv = new MauSacService();
    private NhanHieuService nhanHieuSv = new NhanHieuService();
    private SizeService sizeSv = new SizeService();

    /**
     * Creates new form panelDanhMucSP
     */
    public panelDanhMucSP() {
        initComponents();
        loadTableDeGiay();
        loadTableKieuDang();
        loadTableLoaiGiay();
        loadTableMauSac();
        loadTableNhanHieu();
        loadTableSize();
    }

    private void loadTableDeGiay() {
        lstDeGiay = deGiaySv.getLists();
        modelDeGiay = (DefaultTableModel) tbDeGiay.getModel();
        int stt = 1;
//        loadCbbDeGiay();
        modelDeGiay.setRowCount(0);
        for (DeGiay x : lstDeGiay) {
            modelDeGiay.addRow(new Object[]{
                    stt++, x.getMa(), x.getChatLieu(), x.getChieuCaoDe(),
                    x.getTrangThai()
            });
        }
    }

    //    private void loadCbbDeGiay() {
//        for (TrangThaiDanhMuc x : TrangThaiDanhMuc.values()) {
//            cbbTtDeGiay.addItem(x.toString());
//        }
//    }
    private void fillTableDeGiay(int index) {
        DeGiay deGiay = lstDeGiay.get(index);
        lbIdDeGiay.setText(String.valueOf(deGiay.getId()));
        txtMaDeGiay.setText(deGiay.getMa());
        txtChatLieuDeGiay.setText(deGiay.getChatLieu());
        txtChieuCaoDeGiay.setText(String.valueOf(deGiay.getChieuCaoDe()));
        cbbTtDeGiay.setSelectedIndex(deGiay.getTrangThai());
    }

    private DeGiay getDeGiay() {
        String ma = txtMaDeGiay.getText();
        String chatLieu = txtChatLieuDeGiay.getText();
        float chieuCao = Float.parseFloat(txtChieuCaoDeGiay.getText());
        byte trangThai;
        if (cbbTtDeGiay.getSelectedItem().equals("Ngừng dùng")) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }

        DeGiay deGiay = new DeGiay(ma, chatLieu, chieuCao, trangThai);
        return deGiay;
    }

    private void loadTableKieuDang() {
        lstKieuDang = kieuDangSv.getLists();
        modelKieuDang = (DefaultTableModel) tbKieuDang.getModel();
        int stt = 1;
//        loadCbbKieuDang();
        modelKieuDang.setRowCount(0);
        for (KieuDang x : lstKieuDang) {
            modelKieuDang.addRow(new Object[]{
                    stt++, x.getMaKieuDang(), x.getTenKieuDang(), x.getTrangThai()
            });
        }
    }

    //    private void loadCbbKieuDang() {
//        for (TrangThaiDanhMuc x : TrangThaiDanhMuc.values()) {
//            cbbTtKieuDang.addItem(x.toString());
//        }
//    }
    private void fillTableKieuDang(int index) {
        KieuDang kieuDang = lstKieuDang.get(index);
        lbIdKieuDang.setText(String.valueOf(kieuDang.getIdKieuDang()));
        txtMaKieuDang.setText(kieuDang.getMaKieuDang());
        txtTenKieuDang.setText(kieuDang.getTenKieuDang());
        cbbTtKieuDang.setSelectedItem(kieuDang.getTrangThai());
    }

    private KieuDang getKieuDang() {
        String ma = txtMaKieuDang.getText();
        String ten = txtTenKieuDang.getText();
        byte trangThai;
        if (cbbTtKieuDang.getSelectedItem().equals("Ngừng dùng")) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }

        KieuDang kieuDang = new KieuDang(ma, ten, trangThai);
        return kieuDang;
    }

    private void loadTableLoaiGiay() {
        lstLoaiGiay = loaiGiaySv.getLists();
        modelLoaiGiay = (DefaultTableModel) tbLoaiGiay.getModel();
        int stt = 1;
//        loadCbbLoaiGiay();
        modelLoaiGiay.setRowCount(0);
        for (LoaiGiay x : lstLoaiGiay) {
            modelLoaiGiay.addRow(new Object[]{
                    stt++, x.getMaLoai(), x.getTenLoai(), x.getTrangThai()
            });
        }
    }

    //    private void loadCbbLoaiGiay() {
//        for (TrangThaiDanhMuc x : TrangThaiDanhMuc.values()) {
//            cbbTtLoaiGiay.addItem(x.toString());
//        }
//    }
    private void fillTableLoaiGiay(int index) {
        LoaiGiay loaiGiay = lstLoaiGiay.get(index);
        lbIdLoaiGiay.setText(String.valueOf(loaiGiay.getIdLoaiGiay()));
        txtMaLoaiGiay.setText(loaiGiay.getMaLoai());
        txtTenLoaiGiay.setText(loaiGiay.getTenLoai());
        cbbTtLoaiGiay.setSelectedItem(loaiGiay.getTrangThai());
    }

    private LoaiGiay getLoaiGiay() {
        String ma = txtMaLoaiGiay.getText();
        String ten = txtTenLoaiGiay.getText();
        byte trangThai;
        if (cbbTtLoaiGiay.getSelectedItem().equals("Ngừng dùng")) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }

        LoaiGiay loaiGiay = new LoaiGiay(ma, ten, trangThai);
        return loaiGiay;
    }

    private void loadTableMauSac() {
        lstMauSac = mauSacSv.getLists();
        modelMauSac = (DefaultTableModel) tbMauSac.getModel();
        int stt = 1;
//        loadCbbMauSac();
        modelMauSac.setRowCount(0);
        for (MauSac x : lstMauSac) {
            modelMauSac.addRow(new Object[]{
                    stt++, x.getMaMau(), x.getTenMau(), x.getTrangThai()
            });
        }
    }

    //    private void loadCbbMauSac() {
//        for (TrangThaiDanhMuc x : TrangThaiDanhMuc.values()) {
//            cbbTtMauSac.addItem(x.toString());
//        }
//    }
    private void fillTableMauSac(int index) {
        MauSac mauSac = lstMauSac.get(index);
        lbIdMauSac.setText(String.valueOf(mauSac.getIdMau()));
        txtMaMauSac.setText(mauSac.getMaMau());
        txtTenMauSac.setText(mauSac.getTenMau());
        cbbTtMauSac.setSelectedItem(mauSac.getTrangThai());
    }

    private MauSac getMauSac() {
        String ma = txtMaMauSac.getText();
        String ten = txtTenMauSac.getText();
        byte trangThai;
        if (cbbTtMauSac.getSelectedItem().equals("Ngừng dùng")) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }

        MauSac mauSac = new MauSac(ma, ten, trangThai);
        return mauSac;
    }

    private void loadTableNhanHieu() {
        lstNhanHieu = nhanHieuSv.getLists();
        modelNhanHieu = (DefaultTableModel) tbNhanHieu.getModel();
        int stt = 1;
//        loadCbbNhanHieu();
        modelNhanHieu.setRowCount(0);
        for (NhanHieu x : lstNhanHieu) {
            modelNhanHieu.addRow(new Object[]{
                    stt++, x.getMaNhanHieu(), x.getTenNhanHieu(), x.getTrangThai()
            });
        }
    }

    //    private void loadCbbNhanHieu() {
//        for (TrangThaiDanhMuc x : TrangThaiDanhMuc.values()) {
//            cbbTtNhanHieu.addItem(x.toString());
//        }
//    }
    private void fillTableNhanHieu(int index) {
        NhanHieu nhanHieu = lstNhanHieu.get(index);
        lbIdNhanHieu.setText(String.valueOf(nhanHieu.getIdNhanHieu()));
        txtMaNhanHieu.setText(nhanHieu.getMaNhanHieu());
        txtTenNhanHieu.setText(nhanHieu.getTenNhanHieu());
        cbbTtNhanHieu.setSelectedItem(nhanHieu.getTrangThai());
    }

    private NhanHieu getNhanHieu() {
        String ma = txtMaNhanHieu.getText();
        String ten = txtTenNhanHieu.getText();
        byte trangThai;
        if (cbbTtNhanHieu.getSelectedItem().equals("Ngừng dùng")) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }

        NhanHieu nhanHieu = new NhanHieu(ma, ten, trangThai);
        return nhanHieu;
    }

    private void loadTableSize() {
        lstSize = sizeSv.getLists();
        modelSize = (DefaultTableModel) tbSize.getModel();
        int stt = 1;
//        loadCbbSize();
        modelSize.setRowCount(0);
        for (Size x : lstSize) {
            modelSize.addRow(new Object[]{
                    stt++, x.getMaSize(), x.getSize(), x.getTrangThai()
            });
        }
    }

    //    private void loadCbbSize() {
//        for (TrangThaiDanhMuc x : TrangThaiDanhMuc.values()) {
//            cbbTtSize.addItem(x.toString());
//        }
//    }
    private void fillTableSize(int index) {
        Size size = lstSize.get(index);
        lbIdSize.setText(String.valueOf(size.getIdSize()));
        txtMaSize.setText(size.getMaSize());
        txtTenSize.setText(String.valueOf(size.getSize()));
        cbbTtSize.setSelectedItem(size.getTrangThai());
    }

    private Size getSize1() {
        String ma = txtMaSize.getText();
        float ten = Float.parseFloat(txtTenSize.getText());
        byte trangThai;
        if (cbbTtSize.getSelectedItem().equals("Ngừng dùng")) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }

        Size size = new Size(ma, ten, trangThai);
        return size;
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKieuDang = new javax.swing.JTable();
        txtTkKieuDang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMaKieuDang = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbbTtKieuDang = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnThemKieuDang = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTenKieuDang = new javax.swing.JTextField();
        btnSuaKieuDang = new javax.swing.JButton();
        btnXoaKieuDang = new javax.swing.JButton();
        lbIdKieuDang = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDeGiay = new javax.swing.JTable();
        txtTkDeGiay = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaDeGiay = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbbTtDeGiay = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        btnThemDeGiay = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtChatLieuDeGiay = new javax.swing.JTextField();
        btnSuaDeGiay = new javax.swing.JButton();
        btnXoaDeGiay = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        txtChieuCaoDeGiay = new javax.swing.JTextField();
        lbIdDeGiay = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbLoaiGiay = new javax.swing.JTable();
        txtTkLoaiGiay = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaLoaiGiay = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cbbTtLoaiGiay = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        btnThemLoaiGiay = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtTenLoaiGiay = new javax.swing.JTextField();
        btnSuaLoaiGiay = new javax.swing.JButton();
        btnXoaLoaiGiay = new javax.swing.JButton();
        lbIdLoaiGiay = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbNhanHieu = new javax.swing.JTable();
        txtTkNhanHieu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaNhanHieu = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cbbTtNhanHieu = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        btnThemNhanHieu = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTenNhanHieu = new javax.swing.JTextField();
        btnSuaNhanHieu = new javax.swing.JButton();
        btnXoaNhanHieu = new javax.swing.JButton();
        lbIdNhanHieu = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbSize = new javax.swing.JTable();
        txtTkSize = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaSize = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cbbTtSize = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        btnThemSize = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTenSize = new javax.swing.JTextField();
        btnSuaSize = new javax.swing.JButton();
        btnXoaSize = new javax.swing.JButton();
        lbIdSize = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbMauSac = new javax.swing.JTable();
        txtTkMauSac = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaMauSac = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cbbTtMauSac = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        btnThemMauSac = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenMauSac = new javax.swing.JTextField();
        btnSuaMauSac = new javax.swing.JButton();
        btnXoaMauSac = new javax.swing.JButton();
        lbIdMauSac = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setEnabled(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(1322, 743));
        jPanel1.setPreferredSize(new java.awt.Dimension(1275, 790));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jScrollPane2.setBorder(null);

        tbKieuDang.setAutoCreateRowSorter(true);
        tbKieuDang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbKieuDang.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Số thứ tự", "Mã", "Tên", "Trạng thái"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbKieuDang.setGridColor(new java.awt.Color(255, 255, 255));
        tbKieuDang.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbKieuDang.setRowHeight(43);
        tbKieuDang.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tbKieuDang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKieuDangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbKieuDang);

        txtTkKieuDang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTkKieuDangKeyReleased(evt);
            }
        });

        jLabel1.setText("Mã kiểu");

        jLabel13.setText("Trạng thái");

        cbbTtKieuDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ngừng dùng", "Đang dùng"}));

        jLabel14.setText("Tìm kiếm");

        btnThemKieuDang.setText("Thêm");
        btnThemKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKieuDangActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("KIỂU DÁNG");

        jLabel11.setText("Tên kiểu");

        btnSuaKieuDang.setText("Sửa");
        btnSuaKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKieuDangActionPerformed(evt);
            }
        });

        btnXoaKieuDang.setText("Xóa");
        btnXoaKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKieuDangActionPerformed(evt);
            }
        });

        lbIdKieuDang.setText("ID");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGap(174, 174, 174)
                                                        .addComponent(jLabel15))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGap(19, 19, 19)
                                                        .addComponent(jLabel14)
                                                        .addGap(11, 11, 11)
                                                        .addComponent(txtTkKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                                        .addComponent(jLabel13)
                                                                        .addGap(16, 16, 16)
                                                                        .addComponent(cbbTtKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(btnXoaKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jLabel11))
                                                                        .addGap(25, 25, 25)
                                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(txtTenKieuDang)
                                                                                .addComponent(txtMaKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(btnThemKieuDang)
                                                                                .addComponent(btnSuaKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lbIdKieuDang)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtMaKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnThemKieuDang)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(txtTenKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSuaKieuDang))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(cbbTtKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnXoaKieuDang)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(txtTkKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbIdKieuDang)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setBorder(null);

        tbDeGiay.setAutoCreateRowSorter(true);
        tbDeGiay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbDeGiay.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Số thứ tự", "Mã", "Chất liệu", "Chiều cao", "Trạng thái"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbDeGiay.setGridColor(new java.awt.Color(255, 255, 255));
        tbDeGiay.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbDeGiay.setRowHeight(43);
        tbDeGiay.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tbDeGiay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDeGiayMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbDeGiay);

        txtTkDeGiay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTkDeGiayKeyReleased(evt);
            }
        });

        jLabel2.setText("Mã đế");

        jLabel16.setText("Trạng thái");

        cbbTtDeGiay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ngừng dùng", "Đang dùng"}));

        jLabel17.setText("Tìm kiếm");

        btnThemDeGiay.setText("Thêm");
        btnThemDeGiay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDeGiayActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("ĐẾ GIÀY");

        jLabel12.setText("Chất liệu");

        btnSuaDeGiay.setText("Sửa");
        btnSuaDeGiay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDeGiayActionPerformed(evt);
            }
        });

        btnXoaDeGiay.setText("Xóa");
        btnXoaDeGiay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDeGiayActionPerformed(evt);
            }
        });

        jLabel31.setText("Chiều cao");

        lbIdDeGiay.setText("ID");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jLabel18)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel31)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtChieuCaoDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel16)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                                                .addComponent(cbbTtDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel12)
                                                                        .addComponent(jLabel2))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtChatLieuDeGiay)
                                                                        .addComponent(txtMaDeGiay))))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(btnThemDeGiay)
                                                                .addComponent(btnSuaDeGiay, javax.swing.GroupLayout.Alignment.TRAILING))
                                                        .addComponent(btnXoaDeGiay, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(18, 18, 18))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(lbIdDeGiay)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTkDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(btnThemDeGiay)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSuaDeGiay))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtMaDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtChatLieuDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel12))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel31)
                                                        .addComponent(txtChieuCaoDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnXoaDeGiay)
                                                        .addComponent(jLabel16)
                                                        .addComponent(cbbTtDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtTkDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbIdDeGiay)
                                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(1275, 790));

        jScrollPane4.setBorder(null);

        tbLoaiGiay.setAutoCreateRowSorter(true);
        tbLoaiGiay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbLoaiGiay.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Số thứ tự", "Mã", "Tên", "Trạng thái"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbLoaiGiay.setGridColor(new java.awt.Color(255, 255, 255));
        tbLoaiGiay.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbLoaiGiay.setRowHeight(43);
        tbLoaiGiay.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tbLoaiGiay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLoaiGiayMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbLoaiGiay);

        txtTkLoaiGiay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTkLoaiGiayKeyReleased(evt);
            }
        });

        jLabel3.setText("Mã loại");

        jLabel19.setText("Trạng thái");

        cbbTtLoaiGiay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ngừng dùng", "Đang dùng"}));

        jLabel20.setText("Tìm kiếm");

        btnThemLoaiGiay.setText("Thêm");
        btnThemLoaiGiay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiGiayActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("LOẠI GIÀY");

        jLabel32.setText("Tên loại");

        btnSuaLoaiGiay.setText("Sửa");
        btnSuaLoaiGiay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLoaiGiayActionPerformed(evt);
            }
        });

        btnXoaLoaiGiay.setText("Xóa");
        btnXoaLoaiGiay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLoaiGiayActionPerformed(evt);
            }
        });

        lbIdLoaiGiay.setText("ID");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addGap(176, 176, 176)
                                                        .addComponent(jLabel21))
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                                                        .addGap(2, 2, 2)
                                                                                        .addComponent(txtTenLoaiGiay))
                                                                                .addComponent(txtMaLoaiGiay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                                        .addComponent(jLabel19)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(cbbTtLoaiGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(btnThemLoaiGiay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnSuaLoaiGiay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnXoaLoaiGiay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtTkLoaiGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lbIdLoaiGiay)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtMaLoaiGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThemLoaiGiay)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTenLoaiGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel32)
                                        .addComponent(btnSuaLoaiGiay))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbbTtLoaiGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19)
                                        .addComponent(btnXoaLoaiGiay))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTkLoaiGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbIdLoaiGiay)
                                .addGap(9, 9, 9))
        );

        jScrollPane5.setBorder(null);

        tbNhanHieu.setAutoCreateRowSorter(true);
        tbNhanHieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbNhanHieu.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Số thứ tự", "Mã", "Tên", "Trạng thái"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbNhanHieu.setGridColor(new java.awt.Color(255, 255, 255));
        tbNhanHieu.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbNhanHieu.setRowHeight(43);
        tbNhanHieu.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tbNhanHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanHieuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbNhanHieu);

        txtTkNhanHieu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTkNhanHieuKeyReleased(evt);
            }
        });

        jLabel4.setText("Mã hiệu");

        jLabel22.setText("Trạng thái");

        cbbTtNhanHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ngừng dùng", "Đang dùng"}));

        jLabel23.setText("Tìm kiếm");

        btnThemNhanHieu.setText("Thêm");
        btnThemNhanHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanHieuActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("NHÃN HIỆU");

        jLabel10.setText("Tên hiệu");

        btnSuaNhanHieu.setText("Sửa");
        btnSuaNhanHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNhanHieuActionPerformed(evt);
            }
        });

        btnXoaNhanHieu.setText("Xóa");
        btnXoaNhanHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhanHieuActionPerformed(evt);
            }
        });

        lbIdNhanHieu.setText("ID");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGap(174, 174, 174)
                                                                .addComponent(jLabel24))
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel10)
                                                                        .addComponent(jLabel4))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(txtMaNhanHieu)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnThemNhanHieu))
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(txtTenNhanHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnSuaNhanHieu, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))))
                                                .addGap(1, 1, 1))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(jLabel22)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(cbbTtNhanHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnXoaNhanHieu))))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jLabel23)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtTkNhanHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbIdNhanHieu)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel24)
                                .addGap(16, 16, 16)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtMaNhanHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnThemNhanHieu))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtTenNhanHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnSuaNhanHieu)
                                                        .addComponent(jLabel10))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cbbTtNhanHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel22)
                                                        .addComponent(btnXoaNhanHieu)))
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel23)
                                        .addComponent(txtTkNhanHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbIdNhanHieu)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane6.setBorder(null);

        tbSize.setAutoCreateRowSorter(true);
        tbSize.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbSize.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Số thứ tự", "Mã", "Tên", "Trạng thái"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbSize.setGridColor(new java.awt.Color(255, 255, 255));
        tbSize.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbSize.setRowHeight(43);
        tbSize.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tbSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSizeMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbSize);

        txtTkSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTkSizeKeyReleased(evt);
            }
        });

        jLabel5.setText("Mã size");

        jLabel25.setText("Trạng thái");

        cbbTtSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ngừng dùng", "Đang dùng"}));

        jLabel26.setText("Tìm kiếm");

        btnThemSize.setText("Thêm");
        btnThemSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSizeActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("SIZE");

        jLabel9.setText("Tên size");

        btnSuaSize.setText("Sửa");
        btnSuaSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSizeActionPerformed(evt);
            }
        });

        btnXoaSize.setText("Xóa");
        btnXoaSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSizeActionPerformed(evt);
            }
        });

        lbIdSize.setText("ID");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addGap(0, 87, Short.MAX_VALUE)
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                                .addComponent(jLabel25)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(cbbTtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnXoaSize, javax.swing.GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE))
                                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel5)
                                                                                        .addComponent(jLabel9))
                                                                                .addGap(22, 22, 22)
                                                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(txtMaSize, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                                                                        .addComponent(txtTenSize))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(btnSuaSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(btnThemSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addComponent(jLabel26)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtTkSize, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbIdSize)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(jLabel27)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnThemSize)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtTenSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnSuaSize)))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel25)
                                        .addComponent(cbbTtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnXoaSize))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTkSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbIdSize)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane7.setBorder(null);

        tbMauSac.setAutoCreateRowSorter(true);
        tbMauSac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbMauSac.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Số thứ tự", "Mã", "Tên", "Trạng thái"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbMauSac.setGridColor(new java.awt.Color(255, 255, 255));
        tbMauSac.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbMauSac.setRowHeight(43);
        tbMauSac.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tbMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMauSacMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbMauSac);

        txtTkMauSac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTkMauSacKeyReleased(evt);
            }
        });

        jLabel6.setText("Mã màu");

        jLabel28.setText("Trạng thái");

        cbbTtMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ngừng dùng", "Đang dùng"}));

        jLabel29.setText("Tìm kiếm");

        btnThemMauSac.setText("Thêm");
        btnThemMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMauSacActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("MÀU SẮC");

        jLabel8.setText("Tên màu");

        btnSuaMauSac.setText("Sửa");
        btnSuaMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMauSacActionPerformed(evt);
            }
        });

        btnXoaMauSac.setText("Xóa");
        btnXoaMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMauSacActionPerformed(evt);
            }
        });

        lbIdMauSac.setText("ID");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addGap(174, 174, 174)
                                                                .addComponent(jLabel30))
                                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                                                .addComponent(jLabel6)
                                                                                .addGap(25, 25, 25)
                                                                                .addComponent(txtMaMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnThemMauSac))
                                                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel28)
                                                                                        .addComponent(jLabel8))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(txtTenMauSac)
                                                                                        .addComponent(cbbTtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(btnSuaMauSac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(btnXoaMauSac)))))
                                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addComponent(jLabel29)
                                                                .addGap(22, 22, 22)
                                                                .addComponent(txtTkMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbIdMauSac)))
                                                .addGap(0, 79, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnThemMauSac)
                                                .addComponent(txtMaMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtTenMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnSuaMauSac)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbbTtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28)
                                        .addComponent(btnXoaMauSac))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel29)
                                        .addComponent(txtTkMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbIdMauSac)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("DANH MỤC GIÀY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(663, 663, 663))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addGap(415, 415, 415))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 790));

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
                                .addContainerGap(1225, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(52, 52, 52)
                                .addComponent(jButton1)
                                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 870, 1480, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tbKieuDangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKieuDangMouseClicked
        int index = tbKieuDang.getSelectedRow();
        fillTableKieuDang(index);
    }//GEN-LAST:event_tbKieuDangMouseClicked

    private void txtTkKieuDangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTkKieuDangKeyReleased
        modelKieuDang = (DefaultTableModel) tbKieuDang.getModel();
        String search = txtTkKieuDang.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelKieuDang);
        tbKieuDang.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));
    }//GEN-LAST:event_txtTkKieuDangKeyReleased

    private void btnThemKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKieuDangActionPerformed
        KieuDang kieuDang = getKieuDang();
        String mess = "Thêm " + kieuDangSv.addOrSave(kieuDang);
        JOptionPane.showMessageDialog(this, mess);
        loadTableKieuDang();
    }//GEN-LAST:event_btnThemKieuDangActionPerformed

    private void btnSuaKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKieuDangActionPerformed
        KieuDang kieuDang = getKieuDang();
        String id = lbIdKieuDang.getText();
        kieuDang.setIdKieuDang(Integer.parseInt(id));
        String mess = "Sửa " + kieuDangSv.addOrSave(kieuDang);
        JOptionPane.showMessageDialog(this, mess);
        loadTableKieuDang();
    }//GEN-LAST:event_btnSuaKieuDangActionPerformed

    private void btnXoaKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKieuDangActionPerformed
        KieuDang kieuDang = getKieuDang();
        String id = lbIdKieuDang.getText();
        kieuDang.setIdKieuDang(Integer.parseInt(id));
        String mess = "Xóa " + kieuDangSv.delete(kieuDang);
        JOptionPane.showMessageDialog(this, mess);
        loadTableKieuDang();
    }//GEN-LAST:event_btnXoaKieuDangActionPerformed

    private void tbDeGiayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDeGiayMouseClicked
        int index = tbDeGiay.getSelectedRow();
        fillTableDeGiay(index);
    }//GEN-LAST:event_tbDeGiayMouseClicked

    private void txtTkDeGiayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTkDeGiayKeyReleased
        modelDeGiay = (DefaultTableModel) tbDeGiay.getModel();
        String search = txtTkDeGiay.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelDeGiay);
        tbDeGiay.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));
    }//GEN-LAST:event_txtTkDeGiayKeyReleased

    private void btnThemDeGiayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDeGiayActionPerformed
        DeGiay deGiay = getDeGiay();
        String mess = "Thêm " + deGiaySv.addOrSave(deGiay);
        JOptionPane.showMessageDialog(this, mess);
        loadTableDeGiay();
    }//GEN-LAST:event_btnThemDeGiayActionPerformed

    private void btnSuaDeGiayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDeGiayActionPerformed
        DeGiay deGiay = getDeGiay();
        String id = lbIdDeGiay.getText();
        deGiay.setId(Integer.parseInt(id));
        String mess = "Sửa " + deGiaySv.addOrSave(deGiay);
        JOptionPane.showMessageDialog(this, mess);
        loadTableDeGiay();
    }//GEN-LAST:event_btnSuaDeGiayActionPerformed

    private void btnXoaDeGiayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDeGiayActionPerformed
        DeGiay deGiay = getDeGiay();
        String id = lbIdDeGiay.getText();
        deGiay.setId(Integer.parseInt(id));
        String mess = "Xóa " + deGiaySv.delete(deGiay);
        JOptionPane.showMessageDialog(this, mess);
        loadTableDeGiay();
    }//GEN-LAST:event_btnXoaDeGiayActionPerformed

    private void tbLoaiGiayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLoaiGiayMouseClicked
        int index = tbLoaiGiay.getSelectedRow();
        fillTableLoaiGiay(index);
    }//GEN-LAST:event_tbLoaiGiayMouseClicked

    private void txtTkLoaiGiayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTkLoaiGiayKeyReleased
        modelLoaiGiay = (DefaultTableModel) tbLoaiGiay.getModel();
        String search = txtTkLoaiGiay.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelLoaiGiay);
        tbLoaiGiay.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));
    }//GEN-LAST:event_txtTkLoaiGiayKeyReleased

    private void btnThemLoaiGiayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiGiayActionPerformed
        LoaiGiay loaiGiay = getLoaiGiay();
        String mess = "Thêm " + loaiGiaySv.addOrSave(loaiGiay);
        JOptionPane.showMessageDialog(this, mess);
        loadTableLoaiGiay();
    }//GEN-LAST:event_btnThemLoaiGiayActionPerformed

    private void btnSuaLoaiGiayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLoaiGiayActionPerformed
        LoaiGiay loaiGiay = getLoaiGiay();
        String id = lbIdLoaiGiay.getText();
        loaiGiay.setIdLoaiGiay(Integer.parseInt(id));
        String mess = "Sửa " + loaiGiaySv.addOrSave(loaiGiay);
        JOptionPane.showMessageDialog(this, mess);
        loadTableLoaiGiay();
    }//GEN-LAST:event_btnSuaLoaiGiayActionPerformed

    private void btnXoaLoaiGiayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLoaiGiayActionPerformed
        LoaiGiay loaiGiay = getLoaiGiay();
        String id = lbIdLoaiGiay.getText();
        loaiGiay.setIdLoaiGiay(Integer.parseInt(id));
        String mess = "Xóa " + loaiGiaySv.delete(loaiGiay);
        JOptionPane.showMessageDialog(this, mess);
        loadTableLoaiGiay();
    }//GEN-LAST:event_btnXoaLoaiGiayActionPerformed

    private void tbNhanHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanHieuMouseClicked
        int index = tbNhanHieu.getSelectedRow();
        fillTableNhanHieu(index);
    }//GEN-LAST:event_tbNhanHieuMouseClicked

    private void txtTkNhanHieuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTkNhanHieuKeyReleased
        modelNhanHieu = (DefaultTableModel) tbNhanHieu.getModel();
        String search = txtTkNhanHieu.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelNhanHieu);
        tbNhanHieu.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));
    }//GEN-LAST:event_txtTkNhanHieuKeyReleased

    private void btnThemNhanHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanHieuActionPerformed
        NhanHieu nhanHieu = getNhanHieu();
        String mess = "Thêm " + nhanHieuSv.addOrSave(nhanHieu);
        JOptionPane.showMessageDialog(this, mess);
        loadTableNhanHieu();
    }//GEN-LAST:event_btnThemNhanHieuActionPerformed

    private void btnSuaNhanHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNhanHieuActionPerformed
        NhanHieu nhanHieu = getNhanHieu();
        String id = lbIdNhanHieu.getText();
        nhanHieu.setIdNhanHieu(Integer.parseInt(id));
        String mess = "Sửa " + nhanHieuSv.addOrSave(nhanHieu);
        JOptionPane.showMessageDialog(this, mess);
        loadTableNhanHieu();
    }//GEN-LAST:event_btnSuaNhanHieuActionPerformed

    private void btnXoaNhanHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhanHieuActionPerformed
        NhanHieu nhanHieu = getNhanHieu();
        String id = lbIdNhanHieu.getText();
        nhanHieu.setIdNhanHieu(Integer.parseInt(id));
        String mess = "Xóa " + nhanHieuSv.delete(nhanHieu);
        JOptionPane.showMessageDialog(this, mess);
        loadTableNhanHieu();
    }//GEN-LAST:event_btnXoaNhanHieuActionPerformed

    private void tbSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSizeMouseClicked
        int index = tbSize.getSelectedRow();
        fillTableSize(index);
    }//GEN-LAST:event_tbSizeMouseClicked

    private void txtTkSizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTkSizeKeyReleased
        modelSize = (DefaultTableModel) tbSize.getModel();
        String search = txtTkSize.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelSize);
        tbSize.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));
    }//GEN-LAST:event_txtTkSizeKeyReleased

    private void btnThemSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSizeActionPerformed
        Size size = getSize1();
        String mess = "Thêm " + sizeSv.addOrSave(size);
        JOptionPane.showMessageDialog(this, mess);
        loadTableSize();
    }//GEN-LAST:event_btnThemSizeActionPerformed

    private void btnSuaSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSizeActionPerformed
        Size size = getSize1();
        String id = lbIdSize.getText();
        size.setIdSize(Integer.parseInt(id));
        String mess = "Sửa " + sizeSv.addOrSave(size);
        JOptionPane.showMessageDialog(this, mess);
        loadTableSize();
    }//GEN-LAST:event_btnSuaSizeActionPerformed

    private void btnXoaSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSizeActionPerformed
        Size size = getSize1();
        String id = lbIdSize.getText();
        size.setIdSize(Integer.parseInt(id));
        String mess = "Xóa " + sizeSv.delete(size);
        JOptionPane.showMessageDialog(this, mess);
        loadTableSize();
    }//GEN-LAST:event_btnXoaSizeActionPerformed

    private void tbMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMauSacMouseClicked
        int index = tbMauSac.getSelectedRow();
        fillTableMauSac(index);
    }//GEN-LAST:event_tbMauSacMouseClicked

    private void txtTkMauSacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTkMauSacKeyReleased
        modelMauSac = (DefaultTableModel) tbMauSac.getModel();
        String search = txtTkMauSac.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelMauSac);
        tbMauSac.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));
    }//GEN-LAST:event_txtTkMauSacKeyReleased

    private void btnThemMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMauSacActionPerformed
        MauSac mauSac = getMauSac();
        String mess = "Thêm " + mauSacSv.addOrSave(mauSac);
        JOptionPane.showMessageDialog(this, mess);
        loadTableMauSac();
    }//GEN-LAST:event_btnThemMauSacActionPerformed

    private void btnSuaMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMauSacActionPerformed
        MauSac mauSac = getMauSac();
        String id = lbIdMauSac.getText();
        mauSac.setIdMau(Integer.parseInt(id));
        String mess = "Sửa " + mauSacSv.addOrSave(mauSac);
        JOptionPane.showMessageDialog(this, mess);
        loadTableMauSac();
    }//GEN-LAST:event_btnSuaMauSacActionPerformed

    private void btnXoaMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMauSacActionPerformed
        MauSac mauSac = getMauSac();
        String id = lbIdMauSac.getText();
        mauSac.setIdMau(Integer.parseInt(id));
        String mess = "Xóa " + mauSacSv.delete(mauSac);
        JOptionPane.showMessageDialog(this, mess);
        loadTableMauSac();
    }//GEN-LAST:event_btnXoaMauSacActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        panelQuanLyGiay viewSP = new panelQuanLyGiay();
        this.removeAll();
        this.add(viewSP);
        this.validate();
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaDeGiay;
    private javax.swing.JButton btnSuaKieuDang;
    private javax.swing.JButton btnSuaLoaiGiay;
    private javax.swing.JButton btnSuaMauSac;
    private javax.swing.JButton btnSuaNhanHieu;
    private javax.swing.JButton btnSuaSize;
    private javax.swing.JButton btnThemDeGiay;
    private javax.swing.JButton btnThemKieuDang;
    private javax.swing.JButton btnThemLoaiGiay;
    private javax.swing.JButton btnThemMauSac;
    private javax.swing.JButton btnThemNhanHieu;
    private javax.swing.JButton btnThemSize;
    private javax.swing.JButton btnXoaDeGiay;
    private javax.swing.JButton btnXoaKieuDang;
    private javax.swing.JButton btnXoaLoaiGiay;
    private javax.swing.JButton btnXoaMauSac;
    private javax.swing.JButton btnXoaNhanHieu;
    private javax.swing.JButton btnXoaSize;
    private javax.swing.JComboBox<String> cbbTtDeGiay;
    private javax.swing.JComboBox<String> cbbTtKieuDang;
    private javax.swing.JComboBox<String> cbbTtLoaiGiay;
    private javax.swing.JComboBox<String> cbbTtMauSac;
    private javax.swing.JComboBox<String> cbbTtNhanHieu;
    private javax.swing.JComboBox<String> cbbTtSize;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lbIdDeGiay;
    private javax.swing.JLabel lbIdKieuDang;
    private javax.swing.JLabel lbIdLoaiGiay;
    private javax.swing.JLabel lbIdMauSac;
    private javax.swing.JLabel lbIdNhanHieu;
    private javax.swing.JLabel lbIdSize;
    private javax.swing.JTable tbDeGiay;
    private javax.swing.JTable tbKieuDang;
    private javax.swing.JTable tbLoaiGiay;
    private javax.swing.JTable tbMauSac;
    private javax.swing.JTable tbNhanHieu;
    private javax.swing.JTable tbSize;
    private javax.swing.JTextField txtChatLieuDeGiay;
    private javax.swing.JTextField txtChieuCaoDeGiay;
    private javax.swing.JTextField txtMaDeGiay;
    private javax.swing.JTextField txtMaKieuDang;
    private javax.swing.JTextField txtMaLoaiGiay;
    private javax.swing.JTextField txtMaMauSac;
    private javax.swing.JTextField txtMaNhanHieu;
    private javax.swing.JTextField txtMaSize;
    private javax.swing.JTextField txtTenKieuDang;
    private javax.swing.JTextField txtTenLoaiGiay;
    private javax.swing.JTextField txtTenMauSac;
    private javax.swing.JTextField txtTenNhanHieu;
    private javax.swing.JTextField txtTenSize;
    private javax.swing.JTextField txtTkDeGiay;
    private javax.swing.JTextField txtTkKieuDang;
    private javax.swing.JTextField txtTkLoaiGiay;
    private javax.swing.JTextField txtTkMauSac;
    private javax.swing.JTextField txtTkNhanHieu;
    private javax.swing.JTextField txtTkSize;
    // End of variables declaration//GEN-END:variables
}
