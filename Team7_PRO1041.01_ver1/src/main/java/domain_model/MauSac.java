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
@Table(name = "MauSac")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MauSac implements Serializable {
    @Id
    @Column(name = "IdMau", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private int idMau;

    @Column(name = "MaMau")
    private String maMau;

    @Column(name = "TenMau")
    private String tenMau;

    @Column(name = "TrangThai")
    private byte TrangThai;

    public MauSac(String maMau, String tenMau, byte TrangThai) {
        this.maMau = maMau;
        this.tenMau = tenMau;
        this.TrangThai = TrangThai;
    }


}
