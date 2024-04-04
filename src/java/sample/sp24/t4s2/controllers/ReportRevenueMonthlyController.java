package sample.sp24.t4s2.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.sp24.t4s2.revenue.RevenueDAO;
import sample.sp24.t4s2.revenue.RevenueDTO;

@WebServlet(name = "ReportRevenueMonthlyController", urlPatterns = {"/ReportRevenueMonthlyController"})
public class ReportRevenueMonthlyController extends HttpServlet {

    public static final String ERROR = "revenue.jsp";
    public static final String SUCCESS = "revenue.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            RevenueDAO revenueDAO = new RevenueDAO();
            RevenueDTO revenueDTO = new RevenueDTO();
            List<RevenueDTO> list = new ArrayList<>();
            list = revenueDAO.getRevenueReportMonthly();
            if(list != null && list.size() > 0) {
                request.setAttribute("LIST_REVENUE_MONTHLY", list);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at ReportRevenueByDayController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

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
