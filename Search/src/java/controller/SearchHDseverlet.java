/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.HoaDonDAO;
import entity.HoaDon;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import until.HibernateUtil;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SearchHDseverlet", urlPatterns = {"/SearchHDseverlet"})
public class SearchHDseverlet extends HttpServlet {

    public List<HoaDon> list;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action"); // gan gia tri cho action tu form cua search.jsp de truyen du lieu
        String search = request.getParameter("txtsearch"); // ten input trong form action, tham so muon tim ( can ho m muon tim)
        String url = null; // dien truyen den trang web, mac ding la null
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (action.equals("Search")) { // neu nhan vao input co value la Search, se thuc hien code duoi
                HoaDonDAO dao = new HoaDonDAO(); // goi hamm DAO de lay list timID
                list = dao.timID(search);// tao 1 lisst va gat gia tri cho list timID, co tham so searxh dong 43
                
                request.setAttribute("listForeach", list);// set ten cho list de show du lieu
                request.setAttribute("tenID", search);
                
                url = "/search.jsp"; // den trang web
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            }
        }
    }

    ;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
