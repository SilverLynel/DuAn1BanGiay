/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domain_model.HoaDon;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author PhiLT
 */
public interface IHoaDonRepository {
    List<HoaDon> getAll();

    boolean addHoaDon(HoaDon hd);

    boolean thanhToanHD(int id);

    boolean huyHoaDon(int idHD);

    boolean updateTongTienHD(BigDecimal tien, int idHD);

    boolean updateThongTinHD(HoaDon hd);
}
