/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.GiayCT;

import java.util.List;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * @author PhiLT
 */
public class GiayCTBanHangRepository implements IGiayCTBanHangRepository {

    @Override
    public List<GiayCT> getAllGiayCT() {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "from GiayCT where trangThai>0";
        Query q = session.createQuery(hql);
        List<GiayCT> list = q.getResultList();
        return list;
    }

    @Override
    public boolean addNewGiay(GiayCT giay) {

        Transaction tx = null;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            s.saveOrUpdate(giay);
            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addMoreGiay(int id, int soLuong) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            GiayCT giay = s.find(GiayCT.class, id);
            giay.setSoLuongTon(giay.getSoLuongTon() + soLuong);
            s.save(giay);
            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateGiay(GiayCT giay) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            s.merge(giay);
            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteGiay(int id) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            GiayCT giay = s.find(GiayCT.class, id);
            giay.setTrangThai(0);
            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<GiayCT> searchGiayCTByName(String ten) {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "from GiayCT where tenGiay like '%'+:ten+'%'";
        Query q = session.createQuery(hql);
        q.setParameter("ten", ten);
        List<GiayCT> list = q.getResultList();
        return list;
    }

}
