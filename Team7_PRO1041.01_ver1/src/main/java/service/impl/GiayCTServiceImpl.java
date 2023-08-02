/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domain_model.GiayCT;

import java.util.List;

import repository.GiayCTRepository;
import repository.IGiayCTRepository;
import service.GiayCTService;

/**
 * @author Admin
 */
public class GiayCTServiceImpl implements GiayCTService {

    private final IGiayCTRepository iGiayCTRepository;

    public GiayCTServiceImpl() {
        iGiayCTRepository = new GiayCTRepository();
    }

    @Override
    public List<GiayCT> getAll() {
        return iGiayCTRepository.getAll();
    }

    @Override
    public void update(GiayCT giay) {
        iGiayCTRepository.update(giay);
    }

    @Override
    public void add(GiayCT giay) {
        iGiayCTRepository.add(giay);
    }

    @Override
    public String finByIdMau(String tenMau) {
        return iGiayCTRepository.finByIdMau(tenMau);
    }

    @Override
    public String finByILoai(String tenLoai) {
        return iGiayCTRepository.finByILoai(tenLoai);
    }

    @Override
    public String finByINhanHieu(String tenNhanHieu) {
        return iGiayCTRepository.finByINhanHieu(tenNhanHieu);
    }

    @Override
    public String finByIdKieuDang(String tenKieuDang) {
        return iGiayCTRepository.finByIdKieuDang(tenKieuDang);
    }

    @Override
    public String finByIdSize(String size) {
        return iGiayCTRepository.finByIdSize(size);
    }

    @Override
    public String finByIdChatLieu(String chatLieu) {
        return iGiayCTRepository.finByIdChatLieu(chatLieu);
    }

}
