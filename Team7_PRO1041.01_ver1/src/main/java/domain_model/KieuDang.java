/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Admin
 */
@Entity
@Table(name = "KieuDang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KieuDang implements Serializable {
    @Id
    @Column(name = "IdKieuDang", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private int idKieuDang;

    @Column(name = "MaKieuDang")
    private String maKieuDang;

    @Column(name = "TenKieuDang")
    private String tenKieuDang;

    @Column(name = "TrangThai")
    private byte TrangThai;

    public KieuDang(String maKieuDang, String tenKieuDang, byte TrangThai) {
        this.maKieuDang = maKieuDang;
        this.tenKieuDang = tenKieuDang;
        this.TrangThai = TrangThai;
    }


}
