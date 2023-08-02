/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domain_model.LoaiGiay;

import java.util.List;

import repository.LoaiGiayRepo;

/**
 * @author tungs
 */
public class LoaiGiayService {

    private LoaiGiayRepo repo;

    public LoaiGiayService() {
        repo = new LoaiGiayRepo();
    }

    public List<LoaiGiay> getLists() {
        return repo.getAll();
    }

    public LoaiGiay getOne(String ma) {
        return repo.getOne(ma);
    }

    public String addOrSave(LoaiGiay x) {
        if (!repo.addOrSave(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    public String delete(LoaiGiay x) {
        if (!repo.delete(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    public List<String> listcbbLoaiGiay() {
        return repo.listcbbcv();
    }
}
