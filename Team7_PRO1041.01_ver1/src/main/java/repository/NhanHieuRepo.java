/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.NhanHieu;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author tungs
 */
public class NhanHieuRepo {

    public List<NhanHieu> getAll() {
        List<NhanHieu> lst = new ArrayList<NhanHieu>();
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from NhanHieu";
            TypedQuery<NhanHieu> query = s.createQuery(hql, NhanHieu.class);
            lst = query.getResultList();
        }
        return lst;
    }

    public NhanHieu getOne(String tenNhanHieu) {
        NhanHieu nhanHieu = null;
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from NhanHieu where tenNhanHieu = :tenNhanHieu";
            TypedQuery<NhanHieu> query = s.createQuery(hql, NhanHieu.class);
            query.setParameter("tenNhanHieu", tenNhanHieu);
            nhanHieu = query.getSingleResult();
        }
        return nhanHieu;
    }

    public boolean addOrSave(NhanHieu x) {
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

    public boolean delete(NhanHieu x) {
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
            String sql = "select NhanHieu.tenNhanHieu from NhanHieu NhanHieu";
            TypedQuery<String> query = s.createQuery(sql, String.class);
            list = (ArrayList<String>) query.getResultList();
        }
        return list;
    }
}
