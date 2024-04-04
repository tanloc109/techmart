package sample.sp24.t4s2.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.sp24.t4s2.product.ProductDAO;
import sample.sp24.t4s2.shopping.Cart;
import sample.sp24.t4s2.product.ProductDTO;
import sample.sp24.t4s2.user.UserDTO;
import sample.sp24.t4s2.google.JavaMailUtils;

@WebServlet(name = "PayController", urlPatterns = {"/PayController"})
public class PayController extends HttpServlet {

    private static final String ERROR = "viewCart.jsp";
    private static final String SUCCESS = "payMoney.jsp";
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9]*@" + "[A-Za-z0-9]*+(\\.[A-Za-z0-9]{2,})*$";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean check = true;
        try {
            HttpSession session = request.getSession();
            ProductDAO dao = new ProductDAO();
            if (session != null) {
                Cart cart = (Cart) session.getAttribute("CART");
                UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
                double total = 0;
                if (cart != null) {
                    for (ProductDTO product : cart.getCart().values()) {
                        total += product.getQuantity() * product.getPrice();
                    }
                    if (!dao.createOrder(total, user.getUserID())) {
                        check = false;
                    }
                    int newOrderID = dao.getNewOrderID();
                    for (ProductDTO product : cart.getCart().values()) {
                        if (!dao.createOrderDetail(product.getPrice(), product.getQuantity(), newOrderID, product.getProductID())) {
                            check = false;
                        }
                        if (!dao.updateQuantity(product)) {
                            check = false;
                        }
                    }
                    if (check) {
                        JavaMailUtils.sendMail(user.getEmail());
                        session.removeAttribute("CART");
                        url = SUCCESS;
                    }
                }
            }
        } catch (SQLException e) {
            log("Error at PayController: " + e.toString());
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PayController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PayController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
