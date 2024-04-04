package sample.sp24.t4s2.controllers;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.sp24.t4s2.user.UserDAO;
import sample.sp24.t4s2.user.UserDTO;
import sample.sp24.t4s2.user.UserError;

@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateUserController extends HttpServlet {

    public static final String ERROR = "createUser.jsp";
    public static final String SUCCESS = "SearchController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean check = true;
        UserDAO dao = new UserDAO();
        UserError userError = new UserError();
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String dob_raw = request.getParameter("dob");
            Date dob = Date.valueOf(dob_raw);
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String status_raw = request.getParameter("status");
            int status = Integer.parseInt(status_raw);
            String confirm = request.getParameter("confirm");
            if (userID.length() < 2 || userID.length() > 10) {
                userError.setUserIDError("UserID must be in [2,10]");
                check = false;
            }
            boolean checkDuplicate = dao.checkDuplicate(userID);
            if(checkDuplicate){
                userError.setUserIDError("User da ton tai");
                check = false;
            }
            if (fullName.length() < 5 || fullName.length() > 20) {
                userError.setFullNameError("Fullname must be in [5,20]");
                check = false;
            }
            if (!password.equals(confirm)) {
                userError.setConfirmError("Hai password khong giong nhau");
                check = false;
            }
            if (check) {
                UserDTO user = new UserDTO(userID, fullName, password, roleID, address, dob, phone, email, status);
                boolean checkInsert = dao.insert(user);
                if (checkInsert) {
                    request.setAttribute("MESSAGE", "Create user successfully !");
                    url = SUCCESS;
                } else {
                    userError.setError("Unknow_error");
                    request.setAttribute("USER_ERROR", userError);
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
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
