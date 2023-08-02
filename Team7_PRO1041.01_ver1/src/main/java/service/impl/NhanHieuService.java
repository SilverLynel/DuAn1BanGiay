/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domain_model.NhanHieu;

import java.util.List;

import repository.NhanHieuRepo;

/**
 * @author tungs
 */
public class NhanHieuService {

    private NhanHieuRepo repo;

    public NhanHieuService() {
        repo = new NhanHieuRepo();
    }

    public List<NhanHieu> getLists() {
        return repo.getAll();
    }

    public NhanHieu getOne(String ma) {
        return repo.getOne(ma);
    }

    public String addOrSave(NhanHieu x) {
        if (!repo.addOrSave(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    public String delete(NhanHieu x) {
        if (!repo.delete(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    public List<String> listcbbNhanHieu() {
        return repo.listcbbcv();
    }
}
