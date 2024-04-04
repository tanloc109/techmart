package sample.sp24.t4s2.google;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.sp24.t4s2.user.UserDAO;

@WebServlet(name = "ResetPasswordServlet", urlPatterns = {"/ResetPasswordServlet"})
public class ResetPasswordServlet extends HttpServlet {

    public static final String ERROR = "resetpassword.jsp";
    public static final String SUCCESS = "login.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String newPassword = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String username = (String) request.getSession().getAttribute("username");
        if (newPassword.equals(confirmPassword)) {
            UserDAO dao = new UserDAO();
            try {
                boolean success = dao.resetPassword(username, newPassword);
                if (success) {
                    response.sendRedirect(SUCCESS);
                } else {
                    request.setAttribute("error", "Failed to update password. Please try again.");
                    request.getRequestDispatcher(ERROR).forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("error", "Passwords do not match. Please try again.");
            request.getRequestDispatcher(ERROR).forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
