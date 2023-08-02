/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domain_model.Size;

import java.util.List;

import repository.SizeRepo;

/**
 * @author tungs
 */
public class SizeService {

    private SizeRepo repo;

    public SizeService() {
        repo = new SizeRepo();
    }

    public List<Size> getLists() {
        return repo.getAll();
    }

    public Size getOne(Float size) {
        return repo.getOne(size);
    }

    public String addOrSave(Size x) {
        if (!repo.addOrSave(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    public String delete(Size x) {
        if (!repo.delete(x)) {
            return "thất bại";
        }
        return "thành công";
    }

    public List<Float> listcbbSize() {
        return repo.listcbbcv();
    }
}
