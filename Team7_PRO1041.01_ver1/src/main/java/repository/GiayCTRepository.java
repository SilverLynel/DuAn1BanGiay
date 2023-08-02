/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.GiayCT;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 * @author Admin
 */
public class GiayCTRepository implements IGiayCTRepository {

    @Override
    public List<GiayCT> getAll() {
        List<GiayCT> giayCT = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getFACTORY().openSession();
        try {
            trns = session.beginTransaction();
            giayCT = session.createQuery("from GiayCT").list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return giayCT;
    }

    @Override
    public void update(GiayCT giay) {
        Transaction t = null;

        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            t = s.beginTransaction();
            s.merge(giay);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(GiayCT giay) {
        Transaction t = null;

        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            t = s.beginTransaction();
            s.persist(giay);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String finByIdMau(String tenMau) {
        String id;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String statement = "select sp.idMau from MauSac sp where sp.tenMau = :tenMau";
            Query<String> query = session.createQuery(statement);
            query.setParameter("tenMau", tenMau);
            id = query.getSingleResult();
        }
        return id;
    }

    @Override
    public String finByILoai(String tenLoai) {
        String id;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String statement = "select sp.idLoaiGiay from LoaiGiay sp where sp.tenLoai = :tenLoai";
            Query<String> query = session.createQuery(statement);
            query.setParameter("tenLoai", tenLoai);
            id = query.getSingleResult();
        }
        return id;
    }

    @Override
    public String finByINhanHieu(String tenNhanHieu) {
        String id;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String statement = "select sp.idNhanHieu from NhanHieu sp where sp.tenNhanHieu = :tenNhanHieu";
            Query<String> query = session.createQuery(statement);
            query.setParameter("tenNhanHieu", tenNhanHieu);
            id = query.getSingleResult();
        }
        return id;
    }

    @Override
    public String finByIdKieuDang(String tenKieuDang) {
        String id;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String statement = "select sp.tenKieuDang from KieuDang sp where sp.tenKieuDang = :tenKieuDang";
            Query<String> query = session.createQuery(statement);
            query.setParameter("tenKieuDang", tenKieuDang);
            id = query.getSingleResult();
        }
        return id;
    }

    @Override
    public String finByIdSize(String size) {
        String id;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String statement = "select sp.idSize from Size sp where sp.size = :size";
            Query<String> query = session.createQuery(statement);
            query.setParameter("size", size);
            id = query.getSingleResult();
        }
        return id;
    }

    @Override
    public String finByIdChatLieu(String chatLieu) {
        String id;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String statement = "select sp.idChatLieu from ChatLieu sp where sp.chatLieu = :chatLieu";
            Query<String> query = session.createQuery(statement);
            query.setParameter("chatLieu", chatLieu);
            id = query.getSingleResult();
        }
        return id;
    }

}
