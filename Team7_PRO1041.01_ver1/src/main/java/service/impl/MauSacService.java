/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domain_model.MauSac;

import java.util.List;

import repository.MauSacRepo;

/**
 * @author tungs
 */
public class MauSacService {

    private MauSacRepo repo;

    public MauSacService() {
        repo = new MauSacRepo();
    }

    public List<MauSac> getLists() {
        return repo.getAll();
    }

    public MauSac getOne(String ma) {
        return repo.getOne(ma);
    }

    public String addOrSave(MauSac x) {
        if (!repo.addOrSave(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    public String delete(MauSac x) {
        if (!repo.delete(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    public List<String> listcbbMau() {
        return repo.listcbbcv();
    }
}
