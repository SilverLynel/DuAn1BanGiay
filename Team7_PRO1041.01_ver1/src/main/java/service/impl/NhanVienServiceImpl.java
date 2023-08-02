/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domain_model.NhanVien;

import java.util.List;

import repository.INhanVienRepository;
import repository.NhanVienRepository;
import service.NhanVienService;


/**
 * @author Admin
 */
public class NhanVienServiceImpl implements NhanVienService {

    private final INhanVienRepository iNhanVienRepository;

    public NhanVienServiceImpl() {
        iNhanVienRepository = new NhanVienRepository();
    }

    @Override
    public List<NhanVien> getAll() {
        return iNhanVienRepository.getAll();
    }

    @Override
    public void update(NhanVien nv) {
        iNhanVienRepository.update(nv);
    }

    @Override
    public void add(NhanVien nv) {
        iNhanVienRepository.add(nv);
    }


}
