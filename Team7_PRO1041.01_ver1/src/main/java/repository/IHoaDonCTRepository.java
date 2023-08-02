/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domain_model.HoaDonChiTiet;

import java.util.List;

/**
 * @author PhiLT
 */
public interface IHoaDonCTRepository {
    List<HoaDonChiTiet> getAll(int idHD);

    boolean deleteHDCT(int idHD, int idGiay);

    boolean saveOrUpdate(HoaDonChiTiet hdct);
}
