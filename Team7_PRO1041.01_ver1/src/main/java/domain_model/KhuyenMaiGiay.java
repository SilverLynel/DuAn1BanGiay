/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain_model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.crypto.Data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Admin
 */
@Entity
@Table(name = "KhuyenMaiGiay")
@lombok.Data
@NoArgsConstructor
public class KhuyenMaiGiay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IdGiayCT", insertable = false, updatable = false)
    private Integer idGiayCT;

    @Column(name = "IdKhuyenMai", insertable = false, updatable = false)
    private Integer idKhuyenMai;

    @ManyToOne
    @JoinColumn(name = "IdGiayCT", referencedColumnName = "IdGiayCT")
    private GiayCT giayCT;

    @ManyToOne
    @JoinColumn(name = "IdKhuyenMai", referencedColumnName = "IdKhuyenMai")
    private KhuyenMai khuyenMai;

    @Column(name = "GiaBan")
    private BigDecimal giaban;

    @Column(name = "GiaKhuyenMai")
    private BigDecimal giaKM;

    @Column(name = "TrangThai")
    private boolean trangThai;

    public KhuyenMaiGiay(Integer id, GiayCT giayCT, KhuyenMai khuyenMai, BigDecimal giaban, BigDecimal giaKM, boolean trangThai) {
        this.id = id;
        this.giayCT = giayCT;
        this.khuyenMai = khuyenMai;
        this.giaban = giaban;
        this.giaKM = giaKM;
        this.trangThai = trangThai;
    }

    public KhuyenMaiGiay(GiayCT giayCT, KhuyenMai khuyenMai, BigDecimal giaban, BigDecimal giaKM, boolean trangThai) {
        this.giayCT = giayCT;
        this.khuyenMai = khuyenMai;
        this.giaban = giaban;
        this.giaKM = giaKM;
        this.trangThai = trangThai;
    }


}
