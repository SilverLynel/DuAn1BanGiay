/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.KieuDang;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author tungs
 */
public class KieuDangRepo {

    public List<KieuDang> getAll() {
        List<KieuDang> lst = new ArrayList<KieuDang>();
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from KieuDang";
            TypedQuery<KieuDang> query = s.createQuery(hql, KieuDang.class);
            lst = query.getResultList();
        }
        return lst;
    }

    public KieuDang getOne(String tenKieuDang) {
        KieuDang kieuDang = null;
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from KieuDang where tenKieuDang = :tenKieuDang";
            TypedQuery<KieuDang> query = s.createQuery(hql, KieuDang.class);
            query.setParameter("tenKieuDang", tenKieuDang);
            kieuDang = query.getSingleResult();
        }
        return kieuDang;
    }

    public boolean addOrSave(KieuDang x) {
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

    public boolean delete(KieuDang x) {
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
            String sql = "select KieuDang.tenKieuDang from KieuDang KieuDang";
            TypedQuery<String> query = s.createQuery(sql, String.class);
            list = (ArrayList<String>) query.getResultList();
        }
        return list;
    }
}
