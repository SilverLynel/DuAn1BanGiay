/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain_model.HoaDon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 * @author PhiLT
 */
public class HoaDonRepository implements IHoaDonRepository {

    @Override
    public List<HoaDon> getAll() {
        List<HoaDon> list = new ArrayList<>();
        Session s = HibernateUtil.getFACTORY().openSession();
        String hql = "from HoaDon";
        Query q = s.createQuery(hql);
        list = q.getResultList();
        return list;

    }

    @Override
    public boolean addHoaDon(HoaDon hd) {
        Transaction tx = null;
        int check = 0;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
//            String hql = "insert into HoaDon(MaHoaDon, IdNhanVien, TenKhachHang, NgayTao, TongTien, TrangThai, SDTNguoiNhan) "
//                    + "values (:MaHoaDon, :IdNhanVien, :TenKhachHang, :NgayTao, :TongTien, :TrangThai, :SDTNguoiNhan)";
//            Query q = s.createQuery(hql);
//            q.setParameter("MaHoaDon", hd.getMaHoaDon());
//            q.setParameter("IdNhanVien", hd.getNhanVien().getIdNhanVien());
//            q.setParameter("TenKhachHang", hd.getTenKhachHang());
//            q.setParameter("NgayTao", hd.getNgayTao());
//            q.setParameter("TongTien", hd.getTongTien());
//            q.setParameter("TrangThai", hd.getTrangThai());
//            q.setParameter("SDTNguoiNhan", hd.getSdtNguoiNhan());
            s.saveOrUpdate(hd);

            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        }
        return false;
    }

    @Override
    public boolean thanhToanHD(int id) {
        int check = 0;
        Transaction tx;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            String hql = "update HoaDon set TrangThai= 1, NgayThanhToan=:NgayThanhToan where IdHoaDon=:IdHoaDon";
            Query q = s.createQuery(hql);
            q.setParameter("IdHoaDon", id);
            q.setParameter("NgayThanhToan", new Date());
            check = q.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean huyHoaDon(int idHD) {
        Transaction tx;
        int check = 0;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            String hql = "delete from HoaDon where idHoaDon=:idHoaDon";
            Query q = s.createQuery(hql);
            q.setParameter("idHoaDon", idHD);
            check = q.executeUpdate();
            tx.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean updateTongTienHD(BigDecimal tien, int idHD) {
        int check = 0;
        Transaction tx;
        try (Session s = HibernateUtil.getFACTORY().openSession()) {
            tx = s.beginTransaction();
            String hql = "update HoaDon set TongTien=:TongTien where IdHoaDon=:IdHoaDon";
            Query q = s.createQuery(hql);
            q.setParameter("TongTien", tien);
            q.setParameter("IdHoaDon", idHD);
            check = q.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean updateThongTinHD(HoaDon hd) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.merge(hd);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
