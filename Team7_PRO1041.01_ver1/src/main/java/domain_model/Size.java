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
@Table(name = "Size")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Size implements Serializable {
    @Id
    @Column(name = "IdSize", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private int idSize;

    @Column(name = "MaSize")
    private String maSize;

    @Column(name = "Size")
    private float size;

    @Column(name = "TrangThai")
    private byte TrangThai;

    public Size(String maSize, float size, byte TrangThai) {
        this.maSize = maSize;
        this.size = size;
        this.TrangThai = TrangThai;
    }


}
