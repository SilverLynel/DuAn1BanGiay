/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domain_model.KieuDang;

import java.util.List;

import repository.KieuDangRepo;

/**
 * @author tungs
 */
public class KieuDangService {

    private KieuDangRepo repo;

    public KieuDangService() {
        repo = new KieuDangRepo();
    }

    public List<KieuDang> getLists() {
        return repo.getAll();
    }

    public KieuDang getOne(String ma) {
        return repo.getOne(ma);
    }

    public String addOrSave(KieuDang x) {
        if (!repo.addOrSave(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    public String delete(KieuDang x) {
        if (!repo.delete(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    public List<String> listcbbKieuDang() {
        return repo.listcbbcv();
    }
}
