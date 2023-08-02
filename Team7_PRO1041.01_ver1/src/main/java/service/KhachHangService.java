/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain_model.KhachHang;

import java.util.ArrayList;

/**
 * @author BXT
 */
public interface KhachHangService {

    public ArrayList<KhachHang> getList();

    String addKhachHang(KhachHang p);

    String updateKhachHang(KhachHang p);

}
