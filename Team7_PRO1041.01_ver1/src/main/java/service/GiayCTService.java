/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain_model.GiayCT;

import java.util.List;

/**
 * @author Admin
 */
public interface GiayCTService {
    List<GiayCT> getAll();

    void update(GiayCT giay);

    void add(GiayCT giay);

    public String finByIdMau(String tenMau);

    public String finByILoai(String tenLoai);

    public String finByINhanHieu(String tenNhanHieu);

    public String finByIdKieuDang(String tenKieuDang);

    public String finByIdSize(String size);

    public String finByIdChatLieu(String chatLieu);
}
