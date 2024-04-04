package sample.sp24.t4s2.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.sp24.t4s2.product.ProductDAO;
import sample.sp24.t4s2.product.ProductDTO;

@WebServlet(name = "AlmostOverProductsController", urlPatterns = {"/AlmostOverProductsController"})
public class AlmostOverProductsController extends HttpServlet {

    private static final String ERROR = "productCRUD.jsp";
    private static final String SUCCESS = "productCRUD.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            List<ProductDTO> list = new ArrayList<>();
            ProductDAO dao = new ProductDAO();
            list = dao.getAlmostOverProducts();
            List<String> listCategory = dao.getCategory();
            if (listCategory != null) {
                if (listCategory.size() > 0) {
                    request.setAttribute("LIST_CATEGORY", listCategory);
                }
            }
            if (list != null && list.size() > 0) {
                request.setAttribute("LIST_ALMOST_OVER_PRODUCTS", list);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at BestSellerController: " + e.toString());
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
