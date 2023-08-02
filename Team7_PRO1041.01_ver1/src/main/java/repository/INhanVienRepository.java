/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domain_model.NhanVien;

import java.util.List;

/**
 * @author Admin
 */
public interface INhanVienRepository {

    List<NhanVien> getAll();

    void update(NhanVien nv);

    void add(NhanVien nv);

    NhanVien login(String username, String password);
}
