/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Admin
 */

@Entity
@Table(name = "HoaDonChiTiet")
@IdClass(HoaDonChiTietId.class)
@Data
public class HoaDonChiTiet implements Serializable {
    @Id
    @Column(name = "IdHoaDon")
    private int idHoaDon;

    @Id
    @Column(name = "IdGiayCT")
    private int idGiayCT;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("IdHoaDon")
    @JoinColumn(name = "IdHoaDon", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), referencedColumnName = "IdHoaDon")
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("IdGiayCT")
    @JoinColumn(name = "IdGiayCT", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), referencedColumnName = "IdGiayCT")
    private GiayCT giayCT;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int idHoaDon, int idGiayCT, int soLuong, BigDecimal giaBan) {
        this.idHoaDon = idHoaDon;
        this.idGiayCT = idGiayCT;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public HoaDonChiTiet(HoaDon hoaDon, GiayCT giayCT, int soLuong, BigDecimal giaBan) {
        this.hoaDon = hoaDon;
        this.giayCT = giayCT;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }


}
