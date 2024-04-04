/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.sp24.t4s2.google;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/ForgotPasswordServlet"})
public class ForgotPasswordServlet extends HttpServlet {

    public static final String ERROR = "forgotPassword.jsp";
    public static final String SUCCESS = "forgotPassword.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String username = request.getParameter("username");

        if (!isValidEmail(email)) {
            request.setAttribute("error", "Invalid email address.Example xxxx@gmail.com or xxxx@gmail.vn or xxxx@fpt.edu.vn");
            request.getRequestDispatcher(ERROR).forward(request, response);
            return;
        }
        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("email", email);

        try {
            String otp = OTPGenerator.generateOTP();
            JavaMailUtilsOTP.sendMail(email, otp);
            request.getSession().setAttribute("otp", otp);
            request.setAttribute("message", "OTP sent successfully. Please check your email.");
            request.getRequestDispatcher(SUCCESS).forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Failed to send OTP. Please try again later.");
            request.getRequestDispatcher(ERROR).forward(request, response);
        }
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(gmail\\.com|gmail\\.vn|fpt\\.edu\\.vn)$";
        return email.matches(regex);
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
