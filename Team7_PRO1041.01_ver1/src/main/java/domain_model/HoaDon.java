/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Admin
 */
@Entity
@Table(name = "HoaDon")
@ToString
public class HoaDon implements Serializable {

    @Id
    @Column(name = "IdHoaDon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHoaDon;

    @Column(name = "MaHoaDon")
    private String maHoaDon;

    @ManyToOne
    @JoinColumn(name = "IdNhanVien")
    private NhanVien nhanVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachHang;

    @Column(name = "TenKhachHang")
    private String tenKhachHang;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "TongTien")
    private BigDecimal tongTien;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "TrangThai")
    private boolean trangThai;

    @Column(name = "SDTNguoiNhan")
    private String sdtNguoiNhan;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, NhanVien nhanVien, KhachHang khachHang, String tenKhachHang, Date ngayTao, BigDecimal tongTien, Date ngayThanhToan, boolean trangThai, String sdtNguoiNhan) {
        this.maHoaDon = maHoaDon;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
        this.sdtNguoiNhan = sdtNguoiNhan;
    }

    public HoaDon(String maHoaDon, NhanVien nhanVien, String tenKhachHang, Date ngayTao, BigDecimal tongTien, boolean trangThai, String sdtNguoiNhan) {
        this.maHoaDon = maHoaDon;
        this.nhanVien = nhanVien;
        this.tenKhachHang = tenKhachHang;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.sdtNguoiNhan = sdtNguoiNhan;
    }

    public HoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }


    public String getSdtNguoiNhan() {
        return sdtNguoiNhan;
    }

    public void setSdtNguoiNhan(String sdtNguoiNhan) {
        this.sdtNguoiNhan = sdtNguoiNhan;
    }


}
