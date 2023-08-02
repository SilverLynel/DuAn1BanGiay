/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.HoaDonChiTiet;

import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 * @author PhiLT
 */
public class HoaDonCTRepository implements IHoaDonCTRepository {

    @Override
    public List<HoaDonChiTiet> getAll(int idHD) {
        Session s = HibernateUtil.getFACTORY().openSession();
        String hql = "from HoaDonChiTiet where IdHoaDon =:IdHoaDon";
        TypedQuery<HoaDonChiTiet> q = s.createQuery(hql, HoaDonChiTiet.class);
        q.setParameter("IdHoaDon", idHD);
        List<HoaDonChiTiet> list = q.getResultList();
        return list;
    }

    @Override
    public boolean deleteHDCT(int idHD, int idGiay) {
        int check = 0;
        Transaction tran = null;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tran = s.beginTransaction();
            String hql = "delete from HoaDonChiTiet where IdHoaDon=:IdHoaDon and IdGiayCT=:IdGiayCT";
            Query q = s.createQuery(hql);
            q.setParameter("IdHoaDon", idHD);
            q.setParameter("IdGiayCT", idGiay);
            check = q.executeUpdate();
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean saveOrUpdate(HoaDonChiTiet hdct) {
        Transaction tran = null;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tran = s.beginTransaction();
            s.saveOrUpdate(hdct);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
