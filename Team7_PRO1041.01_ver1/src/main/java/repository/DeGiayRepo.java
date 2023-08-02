/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.DeGiay;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author tungs
 */
public class DeGiayRepo {

    public List<DeGiay> getAll() {
        List<DeGiay> lst = new ArrayList<DeGiay>();
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from DeGiay";
            TypedQuery<DeGiay> query = s.createQuery(hql, DeGiay.class);
            lst = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public DeGiay getOne(Float chieuCaoDe) {
        DeGiay deGiay = null;
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from DeGiay where ChieuCaoDe = :ChieuCaoDe";
            TypedQuery<DeGiay> query = s.createQuery(hql, DeGiay.class);
            query.setParameter("ChieuCaoDe", chieuCaoDe);
            deGiay = query.getSingleResult();
        }
        return deGiay;
    }

    public boolean addOrSave(DeGiay x) {
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

    public boolean delete(DeGiay x) {
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

    //    public List<String> listcbbChieuCaoDe() {
//        ArrayList<String> list = new ArrayList<>();
//        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
//            String sql = "select DeGiay.ChieuCaoDe from DeGiay DeGiay";
//            TypedQuery<String> query = s.createQuery(sql, String.class);
//            list = (ArrayList<String>) query.getResultList();
//        }
//        return list;
//    }
    public List<Float> listcbbChieuCaoDe() {
        ArrayList<Float> list = new ArrayList<>();
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String sql = "select DeGiay.ChieuCaoDe from DeGiay DeGiay";
            TypedQuery<Float> query = s.createQuery(sql, Float.class);
            list = (ArrayList<Float>) query.getResultList();
        }
        return list;
    }

}
