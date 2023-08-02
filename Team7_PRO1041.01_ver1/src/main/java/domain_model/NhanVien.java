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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Admin
 */
@Entity
@Table(name = "NhanVien")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien implements Serializable {
    @Id
    @Column(name = "IdNhanVien")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNhanVien;

    @Column(name = "MaNhanVien")
    private String maNhanVien;

    @Column(name = "HoVaTenNhanVien")
    private String hoTenNhanVien;

    @Column(name = "GioiTinh")
    private boolean gioiTinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SDT")
    private String sDT;

    @Column(name = "Email")
    private String email;

    @Column(name = "cccd")
    private String cccd;

    @Column(name = "TenTaiKhoan")
    private String tenTK;

    @Column(name = "MatKhau")
    private String pass;

    @Column(name = "ChucVu")
    private Integer ChucVu;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai")
    private Boolean trangThai;
}
