/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entity.HoaDonSinhHoat;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import until.HibernateUtil;

/**
 *
 * @author Admin
 */
public class HoaDonSHDAO {
     public static List<HoaDonSinhHoat> layDanhSachHoaDon(String user) {
        List<HoaDonSinhHoat> list = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "from HoaDonSinhHoat";
        if (user.length() > 0) {
            sql += " where HoaDonSinhHoatId like '%" + user + "%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        return list;
    }

    public HoaDonSHDAO() {

    }

    public List<HoaDonSinhHoat> timID(String id) { // List tim HD tham so la CanHoId ;
        List<HoaDonSinhHoat> list = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = " from HoaDonSinhHoat where CanHoId ='" + id + "' order by NgayThang asc";
        Query query = session.createQuery(sql);
        list = query.list();
    
        return list;
    }

    public static HoaDonSinhHoat layTTHoaDon(String HoaDonId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HoaDonSinhHoat hdsh = (HoaDonSinhHoat) session.get(HoaDonSinhHoat.class, HoaDonId);
        session.close();
        return hdsh;
    }

    public static void main(String[] args) {
       
    }
}
