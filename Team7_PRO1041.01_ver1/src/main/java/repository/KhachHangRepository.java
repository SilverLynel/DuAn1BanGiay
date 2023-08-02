/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.KhachHang;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * @author BXT
 */
public class KhachHangRepository {

    public List<KhachHang> selectAll() {
        List<KhachHang> listsp = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from KhachHang");
            listsp = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listsp;
    }

    public boolean addKhachHang(KhachHang p) {
        Transaction transaction = null;
        boolean check = false;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {

            transaction = session.beginTransaction();
            session.save(p);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();

        }

        return check;

    }


    public Boolean updateKhachHang(KhachHang m) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(m);
            transaction.commit();
            check = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }

}
