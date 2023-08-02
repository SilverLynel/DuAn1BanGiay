/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domain_model.GiayCT;

import java.util.List;

/**
 * @author PhiLT
 */
public interface IGiayCTBanHangRepository {
    List<GiayCT> getAllGiayCT();

    List<GiayCT> searchGiayCTByName(String ten);

    boolean addNewGiay(GiayCT giay);

    boolean addMoreGiay(int id, int soLuong);

    boolean updateGiay(GiayCT giay);

    boolean deleteGiay(int id);
}
