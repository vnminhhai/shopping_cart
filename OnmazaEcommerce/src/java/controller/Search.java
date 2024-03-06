/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Item;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="Search", urlPatterns={"/search"})
public class Search extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ItemDAO id =  new ItemDAO();
        List<String> category = (List<String>)request.getAttribute("category");
        String from = request.getParameter("priceFrom");
        String to = request.getParameter("priceFrom");
        String key =request.getParameter("keyword");
        int f=Integer.MIN_VALUE,t=Integer.MAX_VALUE;
        if (from!=null) f=Integer.parseInt(from);
        if (to!=null) t=Integer.parseInt(to);
        if (key==null) key = "";
        if (category==null) {
            if (request.getParameter("category")==null||request.getParameter("category").equals("All"))
                request.setAttribute("display_list", id.searchItemList(key,f, t));
            else {
                category = new ArrayList<>();
                category.add(request.getParameter("category"));
                request.setAttribute("display_list", id.searchItemList(key,category, f, t));
            }
        }
        else 
            request.setAttribute("display_list", id.searchItemList(key,category, f, t));
        request.getRequestDispatcher("search.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}