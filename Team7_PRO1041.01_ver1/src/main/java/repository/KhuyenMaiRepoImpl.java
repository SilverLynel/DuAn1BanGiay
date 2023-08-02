/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.GiayCT;
import domain_model.KhuyenMai;
import domain_model.KhuyenMaiGiay;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * @author PhiLT
 */
public class KhuyenMaiRepoImpl implements KhuyenMaiRepo {

    @Override
    public List<KhuyenMaiGiay> getAllGiayKM(int idKM) {
        List<KhuyenMaiGiay> list = new ArrayList<>();
        Session session = HibernateUtil.getFACTORY().openSession();
        Query q = session.createQuery("from KhuyenMaiGiay where IdKhuyenMai=:IdKhuyenMai");
        q.setParameter("IdKhuyenMai", idKM);
        list = q.getResultList();
        return list;
    }

    @Override
    public List<KhuyenMai> getAllKM() {
        List<KhuyenMai> list = new ArrayList<>();
        Session session = HibernateUtil.getFACTORY().openSession();
        Query q = session.createQuery("from KhuyenMai");
        list = q.getResultList();
        return list;
    }

    @Override
    public boolean addKM(KhuyenMai km) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateKM(KhuyenMai km) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(km);
            System.out.println("----------" + km.getTrangThai());
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateGiayKM(KhuyenMaiGiay khuyenMaiGiay) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(khuyenMaiGiay);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addGiayKM(KhuyenMaiGiay khuyenMaiGiay) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(khuyenMaiGiay);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public KhuyenMai getOne(int id) {
        KhuyenMai khuyenMai = new KhuyenMai();
        Session session = HibernateUtil.getFACTORY().openSession();

        khuyenMai = session.find(KhuyenMai.class, id);
        return khuyenMai;

    }

    @Override
    public List<KhuyenMai> searchKM(String ten) {
        List<KhuyenMai> list = new ArrayList<>();
        Session s = HibernateUtil.getFACTORY().openSession();
        Query q = s.createQuery("from KhuyenMai where ten like '%'+:ten+'%'");
        q.setParameter("ten", ten);
        list = q.getResultList();
        return list;
    }

    @Override
    public List<KhuyenMaiGiay> searchSPKM(String ten) {
        List<KhuyenMaiGiay> list = new ArrayList<>();
        Session s = HibernateUtil.getFACTORY().openSession();
        Query q = s.createQuery("from KhuyenMaiGiay kmg where kmg.giayCT.tenGiay like '%'+:ten+'%'");
        q.setParameter("ten", ten);
        list = q.getResultList();
        return list;
    }

    @Override
    public List<KhuyenMaiGiay> getOneGiayKMCaoNhat(int idGiay) {
        List<KhuyenMaiGiay> list = new ArrayList<>();
        Session s = HibernateUtil.getFACTORY().openSession();
        Query q = s.createQuery("from KhuyenMaiGiay kmg where kmg.giayCT.idGiayCT=:id and trangThai=1 and kmg.khuyenMai.trangThai=1 order by giaKM asc");
        q.setParameter("id", idGiay);
        list = q.getResultList();
        return list;
    }

    public static void main(String[] args) {
        KhuyenMaiRepo khuyenMaiRepo = new KhuyenMaiRepoImpl();

    }
}
