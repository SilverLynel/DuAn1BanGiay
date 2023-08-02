/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domain_model.KhachHang;

import java.util.ArrayList;

import repository.KhachHangRepository;
import service.KhachHangService;

/**
 * @author BXT
 */
public class KhachHangServiceImpl implements KhachHangService {
    private final KhachHangRepository ms = new KhachHangRepository();

    @Override
    public ArrayList<KhachHang> getList() {
        return (ArrayList<KhachHang>) ms.selectAll();
    }


    @Override
    public String updateKhachHang(KhachHang p) {
        if (ms.updateKhachHang(p)) {
            return "sua thanh cong";
        } else {
            return "sua that bai";
        }
    }

    @Override
    public String addKhachHang(KhachHang p) {
        if (ms.addKhachHang(p)) {
            return "them thanh cong";
        } else {
            return "them that bai";
        }
    }


}
