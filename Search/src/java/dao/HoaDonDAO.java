/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.HoaDon;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import until.HibernateUtil;

/**
 *
 * @author Admin
 */
public class HoaDonDAO {

    public static List<HoaDon> layDanhSachHoaDon(String user) {
        List<HoaDon> list = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "from HoaDon";
        if (user.length() > 0) {
            sql += " where HoaDonId like '%" + user + "%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        return list;
    }

    public HoaDonDAO() {

    }

    public List<HoaDon> timID(String id) { // List tim HD tham so la CanHoId ;
        List<HoaDon> list = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = " from HoaDon where CanHoId ='" + id + "' order by NgayLap asc";
        Query query = session.createQuery(sql);
        list = query.list();
    
        return list;
    }

    public static HoaDon layTTHoaDon(String HoaDonId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HoaDon hd = (HoaDon) session.get(HoaDon.class, HoaDonId);
        session.close();
        return hd;
    }

    public static void main(String[] args) {
       
    }
}
