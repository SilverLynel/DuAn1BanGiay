/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domain_model.GiayCT;
import domain_model.KhuyenMai;
import domain_model.KhuyenMaiGiay;

import java.util.List;

/**
 * @author PhiLT
 */
public interface KhuyenMaiRepo {
    List<KhuyenMaiGiay> getAllGiayKM(int idKM);

    List<KhuyenMai> getAllKM();

    KhuyenMai getOne(int id);

    boolean addKM(KhuyenMai km);

    boolean updateKM(KhuyenMai km);

    List<KhuyenMai> searchKM(String ten);
    //boolean huyKM(int idKM);

    boolean updateGiayKM(KhuyenMaiGiay khuyenMaiGiay);

    boolean addGiayKM(KhuyenMaiGiay khuyenMaiGiay);

    List<KhuyenMaiGiay> searchSPKM(String ten);

    List<KhuyenMaiGiay> getOneGiayKMCaoNhat(int idGiay);
}
