/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domain_model.DeGiay;

import java.util.List;

import repository.DeGiayRepo;

/**
 * @author tungs
 */
public class DeGiayService {

    private DeGiayRepo repo;

    public DeGiayService() {
        repo = new DeGiayRepo();
    }

    public List<DeGiay> getLists() {
        return repo.getAll();
    }

    public DeGiay getOne(Float chieuCaoDe) {
        return repo.getOne(chieuCaoDe);
    }

    public String addOrSave(DeGiay x) {
        if (!repo.addOrSave(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    public String delete(DeGiay x) {
        if (!repo.delete(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    //    public List<String> listcbbChieuCaoDe() {
//        return repo.listcbbChieuCaoDe();
//    }
    public List<Float> listcbbChatLieu() {
        return repo.listcbbChieuCaoDe();
    }
}
