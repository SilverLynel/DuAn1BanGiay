/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Query;

import org.hibernate.Session;
import util.HibernateUtil;

/**
 * @author PhiLT
 */
public class DoanhThuRepoImpl implements DoanhThuRepo {

    @Override
    public BigDecimal getDoanhThuHomNay() {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "select sum(tongTien) from HoaDon where day(ngayThanhToan) = day(getdate())";
        Query q = session.createQuery(hql);
        return (BigDecimal) q.getSingleResult();
    }

    ///////////////////////////////////////////////////
    public static void main(String[] args) {
        DoanhThuRepo d = new DoanhThuRepoImpl();
        List<Object[]> list = d.getDoanhThuNam(2023);
        for (Object[] x : list) {
            System.out.println(x[0] + "-" + x[1] + "-" + x[2]);
        }
    }

    ///////////////////////////////////////////////
    @Override
    public List<Integer> getAllNam() {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "select year(ngayThanhToan) from HoaDon where trangThai=true group by year(ngayThanhToan) order by year(ngayThanhToan) desc";
        Query q = session.createQuery(hql);
        return q.getResultList();
    }

    @Override
    public List<Integer> getAllThang(int nam) {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "select month(ngayThanhToan) from HoaDon where year(ngayThanhToan)=:year and trangThai=true group by month(ngayThanhToan) order by month(ngayThanhToan) asc";
        Query q = session.createQuery(hql);
        q.setParameter("year", nam);
        return q.getResultList();
    }

    @Override
    public List<Integer> getAllNgay(int nam, int thang) {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "select day(ngayThanhToan) from HoaDon where year(ngayThanhToan)=:year and month(ngayThanhToan)=:month and trangThai=true group by day(ngayThanhToan) order by day(ngayThanhToan) ASC";
        Query q = session.createQuery(hql);
        q.setParameter("year", nam);
        q.setParameter("month", thang);
        return q.getResultList();
    }


    @Override
    public List<Object[]> getDoanhThuNam(int nam) {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "select month(hdct.hoaDon.ngayThanhToan), sum(hdct.soLuong*hdct.giaBan), sum(hdct.soLuong*hdct.giaBan)-sum(hdct.soLuong*hdct.giayCT.giaNhap)  from HoaDonChiTiet hdct  where year(hdct.hoaDon.ngayThanhToan)=:year and hdct.hoaDon.trangThai=true  group by month(hdct.hoaDon.ngayThanhToan) order by month(hdct.hoaDon.ngayThanhToan) asc";
        Query q = session.createQuery(hql);
        q.setParameter("year", nam);
        return q.getResultList();
    }


    @Override
    public List<Object[]> getDoanhThuThang(int nam, int thang) {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "select day(hdct.hoaDon.ngayThanhToan), sum(hdct.soLuong*hdct.giaBan), sum(hdct.soLuong*hdct.giaBan)-sum(hdct.soLuong*hdct.giayCT.giaNhap)  from HoaDonChiTiet hdct  where year(hdct.hoaDon.ngayThanhToan)=:year and month(hdct.hoaDon.ngayThanhToan)=:month and hdct.hoaDon.trangThai=true  group by day(hdct.hoaDon.ngayThanhToan) order by day(hdct.hoaDon.ngayThanhToan) asc";
        Query q = session.createQuery(hql);
        q.setParameter("year", nam);
        q.setParameter("month", thang);
        return q.getResultList();
    }

    @Override
    public List<Object[]> getDoanhSoNam(int nam) {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "select hdct.giayCT.tenGiay, sum(hdct.soLuong), sum(hdct.soLuong*hdct.giaBan)-sum(hdct.soLuong*hdct.giayCT.giaNhap)  from HoaDonChiTiet hdct  where year(hdct.hoaDon.ngayThanhToan)=:year and hdct.hoaDon.trangThai=true  group by hdct.giayCT.tenGiay";
        Query q = session.createQuery(hql);
        q.setParameter("year", nam);
        return q.getResultList();
    }

    @Override
    public List<Object[]> getDoanhSoThang(int nam, int thang) {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "select hdct.giayCT.tenGiay, sum(hdct.soLuong), sum(hdct.soLuong*hdct.giaBan)-sum(hdct.soLuong*hdct.giayCT.giaNhap)  from HoaDonChiTiet hdct  where year(hdct.hoaDon.ngayThanhToan)=:year and month(hdct.hoaDon.ngayThanhToan)=:month and hdct.hoaDon.trangThai=true  group by hdct.giayCT.tenGiay";
        Query q = session.createQuery(hql);
        q.setParameter("year", nam);
        q.setParameter("month", thang);
        return q.getResultList();
    }

    @Override
    public List<Object[]> getDoanhSoNgay(int nam, int thang, int ngay) {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "select hdct.giayCT.tenGiay, sum(hdct.soLuong), sum(hdct.soLuong*hdct.giaBan)-sum(hdct.soLuong*hdct.giayCT.giaNhap)  from HoaDonChiTiet hdct  where year(hdct.hoaDon.ngayThanhToan)=:year and month(hdct.hoaDon.ngayThanhToan)=:month and day(hdct.hoaDon.ngayThanhToan)=:day and hdct.hoaDon.trangThai=true  group by hdct.giayCT.tenGiay";
        Query q = session.createQuery(hql);
        q.setParameter("year", nam);
        q.setParameter("month", thang);
        q.setParameter("day", ngay);
        return q.getResultList();
    }
}
