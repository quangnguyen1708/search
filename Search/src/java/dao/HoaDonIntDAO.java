/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.HoaDonInternet;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import until.HibernateUtil;

/**
 *
 * @author Admin
 */
public class HoaDonIntDAO {
    public static List<HoaDonInternet> layDanhSachHoaDon(String user) {
        List<HoaDonInternet> list = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "from HoaDonInternet";
        if (user.length() > 0) {
            sql += " where HoaDonInternet like '%" + user + "%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        return list;
    }

    public HoaDonIntDAO() {

    }

    public List<HoaDonInternet> timID(String id) { // List tim HD tham so la CanHoId ;
        List<HoaDonInternet> list = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = " from HoaDonInternet where CanHoId ='" + id + "' order by NgayThang asc";
        Query query = session.createQuery(sql);
        list = query.list();
    
        return list;
    }

    public static HoaDonInternet layTTHoaDon(String HoaDonId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HoaDonInternet hdint = (HoaDonInternet) session.get(HoaDonInternet.class, HoaDonId);
        session.close();
        return hdint;
    }

    public static void main(String[] args) {
       
    }
}
