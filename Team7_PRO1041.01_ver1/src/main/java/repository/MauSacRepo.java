/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.MauSac;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author tungs
 */
public class MauSacRepo {

    public List<MauSac> getAll() {
        List<MauSac> lst = new ArrayList<MauSac>();
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from MauSac";
            TypedQuery<MauSac> query = s.createQuery(hql, MauSac.class);
            lst = query.getResultList();
        }
        return lst;
    }

    public MauSac getOne(String tenMau) {
        MauSac mauSac = null;
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from MauSac where tenMau = :tenMau";
            TypedQuery<MauSac> query = s.createQuery(hql, MauSac.class);
            query.setParameter("tenMau", tenMau);
            mauSac = query.getSingleResult();
        }
        return mauSac;
    }

    public boolean addOrSave(MauSac x) {
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

    public boolean delete(MauSac x) {
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
            String sql = "select MauSac.tenMau from MauSac MauSac";
            TypedQuery<String> query = s.createQuery(sql, String.class);
            list = (ArrayList<String>) query.getResultList();
        }
        return list;
    }
}
