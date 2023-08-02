/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.NhanVien;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * @author Admin
 */
public class NhanVienRepository implements INhanVienRepository {
    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> nhanVien = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getFACTORY().openSession();
        try {
            trns = session.beginTransaction();
            nhanVien = session.createQuery("from NhanVien").list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return nhanVien;
    }

    @Override
    public void update(NhanVien nv) {
        Transaction t = null;
        Session s = HibernateUtil.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.update(nv);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }

    @Override
    public void add(NhanVien nv) {
        Transaction t = null;
        Session s = HibernateUtil.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.save(nv);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }

    @Override
    public NhanVien login(String username, String password) {
        Session s = HibernateUtil.getFACTORY().openSession();
        Query q = s.createQuery("from NhanVien where tenTK=:tenTK and pass=:pass");
        q.setParameter("tenTK", username);
        q.setParameter("pass", password);
        return (NhanVien) q.getSingleResult();
    }

}
