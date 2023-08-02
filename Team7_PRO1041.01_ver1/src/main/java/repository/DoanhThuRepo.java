/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author PhiLT
 */
public interface DoanhThuRepo {

    List<Object[]> getDoanhThuNam(int nam);

    List<Object[]> getDoanhThuThang(int nam, int thang);

    BigDecimal getDoanhThuHomNay();

    List<Integer> getAllNam();

    List<Integer> getAllThang(int nam);

    List<Integer> getAllNgay(int nam, int thang);

    List<Object[]> getDoanhSoNam(int nam);

    List<Object[]> getDoanhSoThang(int nam, int thang);

    List<Object[]> getDoanhSoNgay(int nam, int thang, int ngay);
}
