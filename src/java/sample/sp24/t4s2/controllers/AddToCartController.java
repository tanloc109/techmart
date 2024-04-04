package sample.sp24.t4s2.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.sp24.t4s2.shopping.Cart;
import sample.sp24.t4s2.product.ProductDTO;

@WebServlet(name = "AddController", urlPatterns = {"/AddController"})
public class AddToCartController extends HttpServlet {

    private static final String ERROR = "shopping.jsp";
    private static final String SUCCESS = "MainController?action=Shopping";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id_raw = request.getParameter("productID");
            int productID = Integer.parseInt(id_raw);
            String name = request.getParameter("productName");
            String image = request.getParameter("image");
            double price = (Double.parseDouble(request.getParameter("price")));
            int memory = Integer.parseInt(request.getParameter("memory"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            HttpSession session = request.getSession();
            if (session != null) {
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart == null) {
                    cart = new Cart();
                }
                ProductDTO product = new ProductDTO(productID, name, image, price, quantity, memory, 0, 1);
                boolean check = cart.add(product);
                if (check) {
                    session.setAttribute("CART", cart);
                    request.setAttribute("MESSAGE", "You added " + name + " with " + quantity + "items successfully !");
                    url = SUCCESS;
                }
            }
        } catch (Exception e) {
            log("Error at AddController: " + e.toString());
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
