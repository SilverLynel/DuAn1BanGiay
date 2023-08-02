/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 * @author Admin
 */
@Entity
@Table(name = "GiayCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiayCT implements Serializable {
    @Id
    @Column(name = "IdGiayCT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGiayCT;

    @Column(name = "MaGiayCT")
    private String maGiayCT;

    @Column(name = "TenGiay")
    private String tenGiay;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "Anh")
    private String anh;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "TrangThai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "IdLoaiGiay")
    private LoaiGiay loaiGiay;

    @ManyToOne
    @JoinColumn(name = "IdMau")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdSize")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "IdNhanHieu")
    private NhanHieu nhanHieu;

    @ManyToOne
    @JoinColumn(name = "idKieuDang")
    private KieuDang kieuDang;

    @ManyToOne
    @JoinColumn(name = "IdDeGiay")
    private DeGiay deGiay;


    public GiayCT(String maGiayCT, String tenGiay, BigDecimal giaNhap, BigDecimal giaBan, int soLuongTon, String anh, String moTa, int trangThai, LoaiGiay loaiGiay, MauSac mauSac, Size size, NhanHieu nhanHieu, KieuDang kieuDang, DeGiay deGiay, DeGiay dg1) {
        this.maGiayCT = maGiayCT;
        this.tenGiay = tenGiay;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.anh = anh;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.loaiGiay = loaiGiay;
        this.mauSac = mauSac;
        this.size = size;
        this.nhanHieu = nhanHieu;
        this.kieuDang = kieuDang;
        this.deGiay = deGiay;
    }


}
