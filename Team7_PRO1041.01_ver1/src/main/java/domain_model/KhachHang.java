/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import java.io.Serializable;
import java.sql.Date;
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
import lombok.NoArgsConstructor;

/**
 * @author Admin
 */
@Entity
@Table(name = "KhachHang")
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang implements Serializable {
    @Id
    @Column(name = "IdKhachHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKhachHang;

    @Column(name = "MaKhachHang")
    private String maKH;

    @Column(name = "Hoten")
    private String hoTen;

    @Column(name = "GioiTinh")
    private boolean gioiTinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "Emai")
    private String email;

    @Column(name = "TrangThai")
    private boolean trangThai;

    @Column(name = "GhiChu")
    private String ghiChu;
}
