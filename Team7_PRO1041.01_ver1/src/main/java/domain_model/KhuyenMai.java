/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.crypto.Data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Admin
 */
@Entity
@Table(name = "KhuyenMai")
@Getter
@Setter
@NoArgsConstructor
public class KhuyenMai implements Serializable {
    @Id
    @Column(name = "IdKhuyenMai")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKhuyenMai;

    @Column(name = "MaKhuyenMai")
    private String ma;

    @Column(name = "TenKhuyenMai")
    private String ten;

    @Column(name = "NgayBatDau")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;

    @Column(name = "PhanTramGiam")
    private float phanTramGiam;

    @Column(name = "DieuKien")
    private String dieuKien;

    @Column(name = "TrangThai")
    private Integer trangThai;

    public KhuyenMai(int idKhuyenMai, String ma, String ten, Date ngayBatDau, Date ngayKetThuc, float phanTramGiam, String dieuKien, Integer trangThai) {
        this.idKhuyenMai = idKhuyenMai;
        this.ma = ma;
        this.ten = ten;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.phanTramGiam = phanTramGiam;
        this.dieuKien = dieuKien;
        this.trangThai = trangThai;
    }

    public KhuyenMai(String ma, String ten, Date ngayBatDau, Date ngayKetThuc, float phanTramGiam, String dieuKien, Integer trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.phanTramGiam = phanTramGiam;
        this.dieuKien = dieuKien;
        this.trangThai = trangThai;
    }


}
