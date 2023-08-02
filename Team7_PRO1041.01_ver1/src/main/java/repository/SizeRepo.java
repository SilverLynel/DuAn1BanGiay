/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.Size;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author tungs
 */
public class SizeRepo {

    public List<Size> getAll() {
        List<Size> lst = new ArrayList<Size>();
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from Size";
            TypedQuery<Size> query = s.createQuery(hql, Size.class);
            lst = query.getResultList();
        }
        return lst;
    }

    public Size getOne(Float size) {
        Size sizee = null;
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String hql = "from Size where size = :size";
            TypedQuery<Size> query = s.createQuery(hql, Size.class);
            query.setParameter("size", size);
            sizee = query.getSingleResult();
        }
        return sizee;
    }

    public boolean addOrSave(Size x) {
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

    public boolean delete(Size x) {
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

    public List<Float> listcbbcv() {
        ArrayList<Float> list = new ArrayList<>();
        try (Session s = util.HibernateUtil.getFACTORY().openSession()) {
            String sql = "select Size.size from Size Size";
            TypedQuery<Float> query = s.createQuery(sql, Float.class);
            list = (ArrayList<Float>) query.getResultList();
        }
        return list;
    }
}
