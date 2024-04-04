package sample.sp24.t4s2.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.sp24.t4s2.product.ProductDAO;
import sample.sp24.t4s2.product.ProductDTO;
import sample.sp24.t4s2.product.ProductError;

@WebServlet(name = "CreateProductController", urlPatterns = {"/CreateProductController"})
public class CreateProductController extends HttpServlet {

    public static final String ERROR = "createProduct.jsp";
    public static final String SUCCESS = "SearchProductController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean check = true;
        ProductDAO dao = new ProductDAO();
        ProductError error = new ProductError();
        try {
            String productName = request.getParameter("productName");
            String image = request.getParameter("image");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int categoryID = Integer.parseInt(request.getParameter("category"));
            int memory = Integer.parseInt(request.getParameter("memory"));
            int status = Integer.parseInt(request.getParameter("status"));
            if (check) {
                ProductDTO product = new ProductDTO(productName, image, price, quantity, memory, categoryID, status);
                boolean checkInsert = dao.insert(product);
                if (checkInsert) {
                    request.setAttribute("MESSAGE", "Create Product successfully");
                    url = SUCCESS;
                } else {
                    error.setError("Unknow_error");
                    request.setAttribute("PRODUCT_ERROR", error);
                }
            } else {
                request.setAttribute("PRODUCT_ERROR", error);
            }
        } catch (Exception e) {
            log("Error at CreateController: " + e.toString());
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
