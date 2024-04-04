package sample.sp24.t4s2.controllers;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.sp24.t4s2.user.UserDAO;
import sample.sp24.t4s2.user.UserDTO;

@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateUserController extends HttpServlet {

    private static final String ERROR = "SearchController";
    private static final String SUCCESS = "SearchController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String address = request.getParameter("address");
            String password = request.getParameter("password");
            Date dob = Date.valueOf(request.getParameter("dob"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            int status = Integer.parseInt(request.getParameter("status"));
            UserDTO user = new UserDTO(userID, fullName, password, roleID, address, dob, phone, email, status);
            UserDAO dao = new UserDAO();
            HttpSession session = request.getSession();
            UserDTO loginUser = (UserDTO)session.getAttribute("LOGIN_USER");
            boolean checkUpdate = dao.update(user);
            if(checkUpdate) {
                if(loginUser.getUserID().equals(userID)) {
                    loginUser.setFullName(fullName);
                    loginUser.setRoleID(roleID);
                    session.setAttribute("LOGIN_USER", loginUser);
                }
                request.setAttribute("MESSAGE", "Update user successfully.");
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
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
