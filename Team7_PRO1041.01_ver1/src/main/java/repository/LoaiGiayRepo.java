/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.LoaiGiay;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author tungs
 */
public class LoaiGiayRepo {

    public List<LoaiGiay> getAll() {
        List<LoaiGiay> lst = new ArrayList<LoaiGiay>();
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from LoaiGiay";
            TypedQuery<LoaiGiay> query = s.createQuery(hql, LoaiGiay.class);
            lst = query.getResultList();
        }
        return lst;
    }

    public LoaiGiay getOne(String tenLoai) {
        LoaiGiay loaiGiay = null;
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from LoaiGiay where tenLoai = :tenLoai";
            TypedQuery<LoaiGiay> query = s.createQuery(hql, LoaiGiay.class);
            query.setParameter("tenLoai", tenLoai);
            loaiGiay = query.getSingleResult();
        }
        return loaiGiay;
    }

    public boolean addOrSave(LoaiGiay x) {
        boolean check = false;
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            Transaction tran = s.beginTransaction();
            try {
                s.saveOrUpdate(x);
                tran.commit();
                check = true;
            } catch (Exception e) {
                e.printStackTrace();
                tran.rollback();
            }
        }
        return check;
    }

    public boolean delete(LoaiGiay x) {
        boolean check = false;
        Transaction tran = null;
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            tran = s.beginTransaction();
            s.delete(x);
            tran.commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
            tran.rollback();
        }
        return check;
    }

    public List<String> listcbbcv() {
        ArrayList<String> list = new ArrayList<>();
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String sql = "select LoaiGiay.tenLoai from LoaiGiay LoaiGiay";
            TypedQuery<String> query = s.createQuery(sql, String.class);
            list = (ArrayList<String>) query.getResultList();
        }
        return list;
    }
}
