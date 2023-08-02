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
@Table(name = "DeGiay")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeGiay implements Serializable {
    @Id
    @Column(name = "IdDeGiay", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private int id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "ChatLieu")
    private String chatLieu;

    @Column(name = "ChieuCaoDe")
    private float ChieuCaoDe;

    @Column(name = "TrangThai")
    private byte TrangThai;

    public DeGiay(String ma, String chatLieu, float ChieuCaoDe, byte TrangThai) {
        this.ma = ma;
        this.chatLieu = chatLieu;
        this.ChieuCaoDe = ChieuCaoDe;
        this.TrangThai = TrangThai;
    }


}
