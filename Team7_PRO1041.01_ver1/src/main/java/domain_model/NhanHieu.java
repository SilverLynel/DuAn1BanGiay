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
@Table(name = "NhanHieu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanHieu implements Serializable {
    @Id
    @Column(name = "IdNhanHieu", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private int idNhanHieu;

    @Column(name = "MaNhanHieu")
    private String maNhanHieu;

    @Column(name = "TenNhanHieu")
    private String tenNhanHieu;

    @Column(name = "TrangThai")
    private byte TrangThai;

    public NhanHieu(String maNhanHieu, String tenNhanHieu, byte TrangThai) {
        this.maNhanHieu = maNhanHieu;
        this.tenNhanHieu = tenNhanHieu;
        this.TrangThai = TrangThai;
    }


}
