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
@Table(name = "LoaiGiay")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoaiGiay {
    @Id
    @Column(name = "IdLoaiGiay", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private int idLoaiGiay;

    @Column(name = "MaLoai")
    private String maLoai;

    @Column(name = "TenLoai")
    private String tenLoai;

    @Column(name = "TrangThai")
    private byte TrangThai;

    public LoaiGiay(String maLoai, String tenLoai, byte TrangThai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.TrangThai = TrangThai;
    }


}
