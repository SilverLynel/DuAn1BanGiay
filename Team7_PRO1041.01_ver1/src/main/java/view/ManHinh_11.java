package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import domain_model.NhanVien;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 * @author PhiLT
 */
public class ManHinh_11 extends javax.swing.JFrame {

    /**
     * Creates new form ManHinh
     */
    private NhanVien nVDangNhap = new NhanVien();

    public ManHinh_11(NhanVien nhanVien) {
        initComponents();

        nVDangNhap = nhanVien;

        this.getContentPane().setBackground(new Color(255, 204, 204));

        //openMenu();
        openPanelBanHang();
        lbUser.setText(nVDangNhap.getMaNhanVien() + "-" + nVDangNhap.getHoTenNhanVien());
    }

    //Đóng mở menu
    int width = 210;
    int height = 781;

    private void openMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (pnBackground.getHeight() > 700) {
                    for (int i = 0; i < width; i++) {
                        pnMenuGradient.setSize(i, 1920);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    for (int i = 0; i < width; i++) {
                        pnMenuGradient.setSize(i, height);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    private void closeMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (pnBackground.getHeight() > 700) {
                    for (int i = width; i > 0; i--) {
                        pnMenuGradient.setSize(i, 1920);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    for (int i = width; i > 0; i--) {
                        pnMenuGradient.setSize(i, height);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbOpenMenu = new javax.swing.JLabel();
        pnBackground = new javax.swing.JPanel();
        pnMenuGradient = new keeptoo.KGradientPanel();
        lbLogo = new javax.swing.JLabel();
        pnMenuBanHang = new javax.swing.JPanel();
        lbMenuBanHang = new javax.swing.JLabel();
        lbCloseMenu = new javax.swing.JLabel();
        lbMenuKhuyenMai = new javax.swing.JLabel();
        pnMenuKhuyenMai = new javax.swing.JPanel();
        lbMenuThongKe = new javax.swing.JLabel();
        pnMenuThongKe = new javax.swing.JPanel();
        lbMenuSanPham = new javax.swing.JLabel();
        pnMenuSanPham = new javax.swing.JPanel();
        lbMenuNhanVien = new javax.swing.JLabel();
        pnMenuNhanVien = new javax.swing.JPanel();
        lbMenuKhachHang = new javax.swing.JLabel();
        pnMenuKhachHang = new javax.swing.JPanel();
        lbUser = new javax.swing.JLabel();
        lbDangXuat1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 204, 204));
        setFocusCycleRoot(false);
        setResizable(false);

        lbOpenMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu.png"))); // NOI18N
        lbOpenMenu.setOpaque(true);
        lbOpenMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbOpenMenuMouseClicked(evt);
            }
        });

        pnBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnBackground.setAlignmentX(0.0F);
        pnBackground.setAlignmentY(0.0F);
        pnBackground.setMaximumSize(new java.awt.Dimension(1322, 743));
        pnBackground.setPreferredSize(new java.awt.Dimension(1275, 790));
        pnBackground.setLayout(new java.awt.BorderLayout());

        pnMenuGradient.setBackground(new java.awt.Color(0, 204, 204));
        pnMenuGradient.setkEndColor(new java.awt.Color(255, 0, 102));
        pnMenuGradient.setkStartColor(new java.awt.Color(255, 153, 153));
        pnMenuGradient.setOpaque(false);
        pnMenuGradient.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLogo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Logo.png"))); // NOI18N
        pnMenuGradient.add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        pnMenuBanHang.setBackground(new java.awt.Color(0, 0, 0));
        pnMenuBanHang.setAlignmentX(0.0F);
        pnMenuBanHang.setAlignmentY(0.0F);
        pnMenuBanHang.setOpaque(false);

        javax.swing.GroupLayout pnMenuBanHangLayout = new javax.swing.GroupLayout(pnMenuBanHang);
        pnMenuBanHang.setLayout(pnMenuBanHangLayout);
        pnMenuBanHangLayout.setHorizontalGroup(
                pnMenuBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        pnMenuBanHangLayout.setVerticalGroup(
                pnMenuBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        pnMenuGradient.add(pnMenuBanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 10, 73));

        lbMenuBanHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMenuBanHang.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sales.png"))); // NOI18N
        lbMenuBanHang.setText("Bán hàng");
        lbMenuBanHang.setAlignmentY(0.0F);
        lbMenuBanHang.setAutoscrolls(true);
        lbMenuBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenuBanHangMouseClicked(evt);
            }
        });
        pnMenuGradient.add(lbMenuBanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, 240, 73));

        lbCloseMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit.png"))); // NOI18N
        lbCloseMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMenuMouseClicked(evt);
            }
        });
        pnMenuGradient.add(lbCloseMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 6, 20, 19));

        lbMenuKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMenuKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/voucher.png"))); // NOI18N
        lbMenuKhuyenMai.setText("Khuyến mại");
        lbMenuKhuyenMai.setAlignmentY(0.0F);
        lbMenuKhuyenMai.setAutoscrolls(true);
        lbMenuKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenuKhuyenMaiMouseClicked(evt);
            }
        });
        pnMenuGradient.add(lbMenuKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 309, 240, 73));

        pnMenuKhuyenMai.setBackground(new java.awt.Color(0, 0, 0));
        pnMenuKhuyenMai.setAlignmentX(0.0F);
        pnMenuKhuyenMai.setAlignmentY(0.0F);
        pnMenuKhuyenMai.setOpaque(false);

        javax.swing.GroupLayout pnMenuKhuyenMaiLayout = new javax.swing.GroupLayout(pnMenuKhuyenMai);
        pnMenuKhuyenMai.setLayout(pnMenuKhuyenMaiLayout);
        pnMenuKhuyenMaiLayout.setHorizontalGroup(
                pnMenuKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        pnMenuKhuyenMaiLayout.setVerticalGroup(
                pnMenuKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 73, Short.MAX_VALUE)
        );

        pnMenuGradient.add(pnMenuKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 309, 10, -1));

        lbMenuThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMenuThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/chart.png"))); // NOI18N
        lbMenuThongKe.setText("Thống kê");
        lbMenuThongKe.setAlignmentY(0.0F);
        lbMenuThongKe.setAutoscrolls(true);
        lbMenuThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenuThongKeMouseClicked(evt);
            }
        });
        pnMenuGradient.add(lbMenuThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 240, 73));

        pnMenuThongKe.setBackground(new java.awt.Color(0, 0, 0));
        pnMenuThongKe.setAlignmentX(0.0F);
        pnMenuThongKe.setAlignmentY(0.0F);
        pnMenuThongKe.setOpaque(false);

        javax.swing.GroupLayout pnMenuThongKeLayout = new javax.swing.GroupLayout(pnMenuThongKe);
        pnMenuThongKe.setLayout(pnMenuThongKeLayout);
        pnMenuThongKeLayout.setHorizontalGroup(
                pnMenuThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        pnMenuThongKeLayout.setVerticalGroup(
                pnMenuThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 70, Short.MAX_VALUE)
        );

        pnMenuGradient.add(pnMenuThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 10, 70));

        lbMenuSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMenuSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sneaker.png"))); // NOI18N
        lbMenuSanPham.setText("Sản phẩm");
        lbMenuSanPham.setAlignmentY(0.0F);
        lbMenuSanPham.setAutoscrolls(true);
        lbMenuSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenuSanPhamMouseClicked(evt);
            }
        });
        pnMenuGradient.add(lbMenuSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 240, 73));

        pnMenuSanPham.setBackground(new java.awt.Color(0, 0, 0));
        pnMenuSanPham.setAlignmentX(0.0F);
        pnMenuSanPham.setAlignmentY(0.0F);
        pnMenuSanPham.setOpaque(false);

        javax.swing.GroupLayout pnMenuSanPhamLayout = new javax.swing.GroupLayout(pnMenuSanPham);
        pnMenuSanPham.setLayout(pnMenuSanPhamLayout);
        pnMenuSanPhamLayout.setHorizontalGroup(
                pnMenuSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 10, Short.MAX_VALUE)
        );
        pnMenuSanPhamLayout.setVerticalGroup(
                pnMenuSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 70, Short.MAX_VALUE)
        );

        pnMenuGradient.add(pnMenuSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 454, 10, 70));

        lbMenuNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMenuNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/staff.png"))); // NOI18N
        lbMenuNhanVien.setText("Nhân viên");
        lbMenuNhanVien.setAlignmentY(0.0F);
        lbMenuNhanVien.setAutoscrolls(true);
        lbMenuNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenuNhanVienMouseClicked(evt);
            }
        });
        pnMenuGradient.add(lbMenuNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 240, 73));

        pnMenuNhanVien.setBackground(new java.awt.Color(0, 0, 0));
        pnMenuNhanVien.setAlignmentX(0.0F);
        pnMenuNhanVien.setAlignmentY(0.0F);
        pnMenuNhanVien.setOpaque(false);

        javax.swing.GroupLayout pnMenuNhanVienLayout = new javax.swing.GroupLayout(pnMenuNhanVien);
        pnMenuNhanVien.setLayout(pnMenuNhanVienLayout);
        pnMenuNhanVienLayout.setHorizontalGroup(
                pnMenuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 10, Short.MAX_VALUE)
        );
        pnMenuNhanVienLayout.setVerticalGroup(
                pnMenuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 70, Short.MAX_VALUE)
        );

        pnMenuGradient.add(pnMenuNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 10, 70));

        lbMenuKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMenuKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/customer.png"))); // NOI18N
        lbMenuKhachHang.setText("Khách hàng");
        lbMenuKhachHang.setAlignmentY(0.0F);
        lbMenuKhachHang.setAutoscrolls(true);
        lbMenuKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenuKhachHangMouseClicked(evt);
            }
        });
        pnMenuGradient.add(lbMenuKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 240, 73));

        pnMenuKhachHang.setBackground(new java.awt.Color(0, 0, 0));
        pnMenuKhachHang.setAlignmentX(0.0F);
        pnMenuKhachHang.setAlignmentY(0.0F);
        pnMenuKhachHang.setOpaque(false);

        javax.swing.GroupLayout pnMenuKhachHangLayout = new javax.swing.GroupLayout(pnMenuKhachHang);
        pnMenuKhachHang.setLayout(pnMenuKhachHangLayout);
        pnMenuKhachHangLayout.setHorizontalGroup(
                pnMenuKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 10, Short.MAX_VALUE)
        );
        pnMenuKhachHangLayout.setVerticalGroup(
                pnMenuKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 70, Short.MAX_VALUE)
        );

        pnMenuGradient.add(pnMenuKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 10, 70));

        lbUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbUser.setForeground(new java.awt.Color(255, 255, 255));
        lbUser.setText("Nhân viên");
        lbUser.setAlignmentY(0.0F);
        lbUser.setAutoscrolls(true);
        lbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUserMouseClicked(evt);
            }
        });
        pnMenuGradient.add(lbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 830, 210, 73));

        lbDangXuat1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDangXuat1.setForeground(new java.awt.Color(255, 255, 255));
        lbDangXuat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logOut.png"))); // NOI18N
        lbDangXuat1.setText("Đăng xuất");
        lbDangXuat1.setAlignmentY(0.0F);
        lbDangXuat1.setAutoscrolls(true);
        lbDangXuat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDangXuat1MouseClicked(evt);
            }
        });
        pnMenuGradient.add(lbDangXuat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 210, 73));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnMenuGradient, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbOpenMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 1507, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbOpenMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(pnMenuGradient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbOpenMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOpenMenuMouseClicked
        // TODO add your handling code here:
        openMenu();
    }//GEN-LAST:event_lbOpenMenuMouseClicked

    private void lbMenuBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuBanHangMouseClicked
        // TODO add your handling code here:
        changeColorClicked(pnMenuBanHang);
        changeColorUnClicked(pnMenuKhuyenMai);
        changeColorUnClicked(pnMenuThongKe);
        changeColorUnClicked(pnMenuSanPham);
        changeColorUnClicked(pnMenuNhanVien);
        changeColorUnClicked(pnMenuKhachHang);

        openPanelBanHang();


    }//GEN-LAST:event_lbMenuBanHangMouseClicked

    private void lbCloseMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMenuMouseClicked
        // TODO add your handling code here:
        closeMenu();
    }//GEN-LAST:event_lbCloseMenuMouseClicked

    private void lbMenuKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuKhuyenMaiMouseClicked
        // TODO add your handling code here:
        if (nVDangNhap.getChucVu() == 1) {
            changeColorClicked(pnMenuKhuyenMai);
            changeColorUnClicked(pnMenuBanHang);
            changeColorUnClicked(pnMenuThongKe);
            changeColorUnClicked(pnMenuSanPham);
            changeColorUnClicked(pnMenuNhanVien);
            changeColorUnClicked(pnMenuKhachHang);

            openPanelKM();
        } else {
            JOptionPane.showMessageDialog(this, "Không thể mở");
        }
    }//GEN-LAST:event_lbMenuKhuyenMaiMouseClicked

    private void lbMenuThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuThongKeMouseClicked
        // TODO add your handling code here:
        if (nVDangNhap.getChucVu() == 1) {
            changeColorClicked(pnMenuThongKe);
            changeColorUnClicked(pnMenuKhuyenMai);
            changeColorUnClicked(pnMenuBanHang);
            changeColorUnClicked(pnMenuSanPham);
            changeColorUnClicked(pnMenuNhanVien);
            changeColorUnClicked(pnMenuKhachHang);

            openPanelThongKe();

        } else {
            JOptionPane.showMessageDialog(this, "Không thể mở");
        }
    }//GEN-LAST:event_lbMenuThongKeMouseClicked

    private void lbMenuSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuSanPhamMouseClicked
        // TODO add your handling code here:
        if (nVDangNhap.getChucVu() == 1) {
            changeColorClicked(pnMenuSanPham);
            changeColorUnClicked(pnMenuKhuyenMai);
            changeColorUnClicked(pnMenuThongKe);
            changeColorUnClicked(pnMenuBanHang);
            changeColorUnClicked(pnMenuNhanVien);
            changeColorUnClicked(pnMenuKhachHang);

            openPanelCTSanPham();
        } else {
            JOptionPane.showMessageDialog(this, "Không thể mở");
        }
    }//GEN-LAST:event_lbMenuSanPhamMouseClicked

    private void lbMenuNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuNhanVienMouseClicked
        // TODO add your handling code here:
        if (nVDangNhap.getChucVu() == 1) {
            changeColorClicked(pnMenuNhanVien);
            changeColorUnClicked(pnMenuKhuyenMai);
            changeColorUnClicked(pnMenuThongKe);
            changeColorUnClicked(pnMenuSanPham);
            changeColorUnClicked(pnMenuBanHang);
            changeColorUnClicked(pnMenuKhachHang);

            openPanelNhanVien();
        } else {
            JOptionPane.showMessageDialog(this, "Không thể mở");
        }
    }//GEN-LAST:event_lbMenuNhanVienMouseClicked

    private void lbMenuKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuKhachHangMouseClicked
        // TODO add your handling code here:
        changeColorClicked(pnMenuKhachHang);
        changeColorUnClicked(pnMenuKhuyenMai);
        changeColorUnClicked(pnMenuThongKe);
        changeColorUnClicked(pnMenuSanPham);
        changeColorUnClicked(pnMenuNhanVien);
        changeColorUnClicked(pnMenuBanHang);

        openPanelKhachHang();

    }//GEN-LAST:event_lbMenuKhachHangMouseClicked

    private void lbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lbUserMouseClicked

    private void lbDangXuat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangXuat1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_lbDangXuat1MouseClicked

    private void changeColorClicked(JPanel panel) {
        panel.setBackground(new Color(90, 90, 90));
        panel.setOpaque(true);
    }

    private void changeColorUnClicked(JPanel panel) {
        panel.setBackground(new Color(70, 90, 90));
        panel.setOpaque(false);
    }

    //Mở panel
    private pnBanHang viewBanHang;
    private pnKhuyenMai viewKM;
    private pnThongKe viewThongKe;
    private panelQuanLyGiay viewGiayCT;
    private panelQuanLyNhanVien viewNhanVien;
    private pnKhachHang viewKhachHang;

    private void openPanelBanHang() {
        viewBanHang = new pnBanHang(this);
        pnBackground.removeAll();
        //closeMenu();
        pnBackground.add(viewBanHang);
        pnBackground.validate();
    }

    private void openPanelKM() {
        viewKM = new pnKhuyenMai();
        pnBackground.removeAll();
        closeMenu();
        pnBackground.add(viewKM);
        pnBackground.validate();
    }

    private void openPanelThongKe() {
        viewThongKe = new pnThongKe();
        pnBackground.removeAll();
        closeMenu();
        pnBackground.add(viewThongKe);
        pnBackground.validate();
    }

    public void openPanelCTSanPham() {
        viewGiayCT = new panelQuanLyGiay();
        pnBackground.removeAll();
        closeMenu();
        pnBackground.add(viewGiayCT);
        pnBackground.validate();
    }

    private void openPanelNhanVien() {
        viewNhanVien = new panelQuanLyNhanVien();
        pnBackground.removeAll();
        closeMenu();
        pnBackground.add(viewNhanVien);
        pnBackground.validate();
    }

    private void openPanelKhachHang() {
        viewKhachHang = new pnKhachHang();
        pnBackground.removeAll();
        closeMenu();
        pnBackground.add(viewKhachHang);
        pnBackground.validate();
    }

    private panelDanhMucSP viewDMSP = new panelDanhMucSP();

    public void openPanelDMSP() {
        pnBackground.removeAll();
        closeMenu();
        pnBackground.add(viewDMSP);
        pnBackground.validate();
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (InstantiationException ex) {
//            ex.printStackTrace();
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            ex.printStackTrace();
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManHinh_11().setVisible(true);
//            }
//        });
//    }
    //Đăng nhập
    public NhanVien login() {
        NhanVien nv = new NhanVien();
        nv.setIdNhanVien(1);
        return nv;
    }
//Đăng xuất

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbCloseMenu;
    private javax.swing.JLabel lbDangXuat1;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbMenuBanHang;
    private javax.swing.JLabel lbMenuKhachHang;
    private javax.swing.JLabel lbMenuKhuyenMai;
    private javax.swing.JLabel lbMenuNhanVien;
    private javax.swing.JLabel lbMenuSanPham;
    private javax.swing.JLabel lbMenuThongKe;
    private javax.swing.JLabel lbOpenMenu;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPanel pnBackground;
    private javax.swing.JPanel pnMenuBanHang;
    private keeptoo.KGradientPanel pnMenuGradient;
    private javax.swing.JPanel pnMenuKhachHang;
    private javax.swing.JPanel pnMenuKhuyenMai;
    private javax.swing.JPanel pnMenuNhanVien;
    private javax.swing.JPanel pnMenuSanPham;
    private javax.swing.JPanel pnMenuThongKe;
    // End of variables declaration//GEN-END:variables
}
