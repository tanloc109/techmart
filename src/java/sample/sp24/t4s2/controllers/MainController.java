package sample.sp24.t4s2.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String WELCOME = "login.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SEARCH = "Search";
    private static final String SEARCH_CONTROLLER = "SearchController";
    private static final String DELETE = "Delete";
    private static final String DELETE_CONTROLLER = "DeleteController";
    private static final String UPDATE = "Update";
    private static final String UPDATE_CONTROLLER = "UpdateController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String CREATE_USER_PAGE = "CreateUserPage";
    private static final String CREATE_USER_PAGE_VIEW = "createUser.html";
    private static final String CREATE_USER_PAGE_FROM_LOGIN = "Create_User_Page_From_Login";
    private static final String CREATE_USER_PAGE_VIEW_FORM_LOGIN = "createUserFromLogin.html";
    private static final String CREATE = "Create";
    private static final String CREATE_CONTROLLER = "CreateController";
    private static final String CREATE_FROM_LOGIN = "CreateFromLogin";
    private static final String CREATE_FROM_LOGIN_CONTROLLER = "CreateFromLoginController";
    private static final String SHOPPING = "Shopping";
    private static final String SHOPPING_CONTROLLER = "ShoppingController";
    private static final String ADD = "Add";
    private static final String ADD_CONTROLLER = "AddController";
    private static final String VIEW = "View";
    private static final String VIEW_PAGE = "viewCart.jsp";
    private static final String EDIT = "Edit";
    private static final String EDIT_CONTROLLER = "EditController";
    private static final String REMOVE = "Remove";
    private static final String REMOVE_CONTROLLER = "RemoveController";
    private static final String CHECKOUT = "CheckOut";
    private static final String CHECKOUT_CONTROLLER = "CheckOutController";
    private static final String USER_MANAGEMENT = "UserManagement";
    private static final String USER_MANAGEMENT_VIEW = "userCRUD.jsp";
    private static final String PRODUCT_MANAGEMENT = "ProductManagement";
    private static final String PRODUCT_MANAGEMENT_CONTROLLER = "ProductManagementController";
    private static final String SEARCH_PRODUCT = "SearchProduct";
    private static final String SEARCH_PRODUCT_BY_CATEGORY = "SearchProductByCategory";
    private static final String SEARCH_PRODUCT_BY_CATEGORY_CONTROLLER = "SearchProductByCategoryController";
    private static final String SEARCH_PRODUCT_CONTROLLER = "SearchProductController";
    private static final String DELETE_PRODUCT = "DeleteProduct";
    private static final String DELETE_PRODUCT_CONTROLLER = "DeleteProductController";
    private static final String UPDATE_PRODUCT = "UpdateProduct";
    private static final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductController";
    private static final String CREATE_PRODUCT_PAGE = "Create_New_Product";
    private static final String CREATE_PRODUCT_PAGE_VIEW = "createProduct.html";
    private static final String CREATE_PRODUCT = "CreateProduct";
    private static final String CREATE_PRODUCT_CONTROLLER = "CreateProductController";
    private static final String HOME = "Home";
    private static final String HOME_PAGE = "admin.jsp";
    private static final String HOME_USER = "HomeUser";
    private static final String HOME_USER_PAGE = "user.jsp";
    private static final String SEFT_UPDATE = "UpdateProfile";
    private static final String SEFT_UPDATE_VIEW = "updateProfile.jsp";
    private static final String UPDATE_MY_PROFILE = "UpdateMyProfile";
    private static final String UPDATE_MY_PROFILE_CONTROLLER = "SeftUpdateInformationController";
    private static final String BACK_LOGIN = "BackLogin";
    private static final String BACK_LOGIN_VIEW = "login.jsp";
    private static final String REVENUE_MANAGEMENT = "RevenueManagement";
    private static final String REVENUE_MANAGEMENT_PAGE = "revenue.jsp";
    private static final String REPORT_REVENUE_BY_DAY = "ReportRevenueByDay";
    private static final String REPORT_REVENUE_BY_DAY_CONTROLLER = "ReportRevenueByDayController";
    private static final String REPORT_REVENUE_BY_MONTH = "ReportRevenueByMonth";
    private static final String REPORT_REVENUE_BY_MONTH_CONTROLLER = "ReportRevenueByMonthController";
    private static final String REPORT_REVENUE_BY_YEAR = "ReportRevenueByYear";
    private static final String REPORT_REVENUE_BY_YEAR_CONTROLLER = "ReportRevenueByYearController";
    private static final String REPORT_REVENUE_IN_RANGE = "ReportRevenueInRange";
    private static final String REPORT_REVENUE_IN_RANGE_CONTROLLER = "ReportRevenueInRangeController";
    private static final String REPORT_REVENUE_DAILY = "ReportRevenueDaily";
    private static final String REPORT_REVENUE_DAILY_CONTROLLER = "ReportRevenueDailyController";
    private static final String REPORT_REVENUE_MONTHLY = "ReportRevenueMonthly";
    private static final String REPORT_REVENUE_MONTHLY_CONTROLLER = "ReportRevenueMonthlyController";
    private static final String REPORT_REVENUE_YEARLY = "ReportRevenueYearly";
    private static final String REPORT_REVENUE_YEARLY_CONTROLLER = "ReportRevenueYearlyController";
    private static final String BEST_SELLER = "BestSeller";
    private static final String BEST_SELLER_CONTROLLER = "BestSellerController";
    private static final String ALMOST_OVER_PRODUCT = "AlmostOverProducts";
    private static final String ALMOST_OVER_PRODUCT_CONTROLLER = "AlmostOverProductsController";
    private static final String TOP_CUSTOMER = "TopCustomer";
    private static final String TOP_CUSTOMER_CONTROLLER = "TopCustomerController";
    private static final String LIST_PRODUCT_IN_RANGE = "ListProductsInRange";
    private static final String LIST_PRODUCT_IN_RANGE_CONTROLLER = "ListProductInRangeController";
    private static final String CLEAR_CART = "ClearCart";
    private static final String CLEAR_CART_CONTROLLER = "ClearCartController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = WELCOME;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER;
            } else if (DELETE.equals(action)) {
                url = DELETE_CONTROLLER;
            } else if (UPDATE.equals(action)) {
                url = UPDATE_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (CREATE_USER_PAGE.equals(action)) {
                url = CREATE_USER_PAGE_VIEW;
            } else if (CREATE.equals(action)) {
                url = CREATE_CONTROLLER;
            } else if (SHOPPING.equals(action)) {
                url = SHOPPING_CONTROLLER;
            } else if (ADD.equals(action)) {
                url = ADD_CONTROLLER;
            } else if (VIEW.equals(action)) {
                url = VIEW_PAGE;
            } else if (EDIT.equals(action)) {
                url = EDIT_CONTROLLER;
            } else if (REMOVE.equals(action)) {
                url = REMOVE_CONTROLLER;
            } else if (CHECKOUT.equals(action)) {
                url = CHECKOUT_CONTROLLER;
            } else if (USER_MANAGEMENT.equals(action)) {
                url = USER_MANAGEMENT_VIEW;
            } else if (PRODUCT_MANAGEMENT.equals(action)) {
                url = PRODUCT_MANAGEMENT_CONTROLLER;
            } else if (SEARCH_PRODUCT.equals(action)) {
                url = SEARCH_PRODUCT_CONTROLLER;
            } else if (DELETE_PRODUCT.equals(action)) {
                url = DELETE_PRODUCT_CONTROLLER;
            } else if (UPDATE_PRODUCT.equals(action)) {
                url = UPDATE_PRODUCT_CONTROLLER;
            } else if (CREATE_PRODUCT_PAGE.equals(action)) {
                url = CREATE_PRODUCT_PAGE_VIEW;
            } else if (CREATE_PRODUCT.equals(action)) {
                url = CREATE_PRODUCT_CONTROLLER;
            } else if (HOME.equals(action)) {
                url = HOME_PAGE;
            } else if (CREATE_USER_PAGE_FROM_LOGIN.equals(action)) {
                url = CREATE_USER_PAGE_VIEW_FORM_LOGIN;
            } else if (CREATE_FROM_LOGIN.equals(action)) {
                url = CREATE_FROM_LOGIN_CONTROLLER;
            } else if (SEFT_UPDATE.equals(action)) {
                url = SEFT_UPDATE_VIEW;
            } else if (HOME_USER.equals(action)) {
                url = HOME_USER_PAGE;
            } else if (BACK_LOGIN.equals(action)) {
                url = BACK_LOGIN_VIEW;
            } else if (SEARCH_PRODUCT_BY_CATEGORY.equals(action)) {
                url = SEARCH_PRODUCT_BY_CATEGORY_CONTROLLER;
            } else if (REVENUE_MANAGEMENT.equals(action)) {
                url = REVENUE_MANAGEMENT_PAGE;
            } else if (REPORT_REVENUE_BY_DAY.equals(action)) {
                url = REPORT_REVENUE_BY_DAY_CONTROLLER;
            } else if (REPORT_REVENUE_BY_MONTH.equals(action)) {
                url = REPORT_REVENUE_BY_MONTH_CONTROLLER;
            } else if (REPORT_REVENUE_BY_YEAR.equals(action)) {
                url = REPORT_REVENUE_BY_YEAR_CONTROLLER;
            } else if (REPORT_REVENUE_IN_RANGE.equals(action)) {
                url = REPORT_REVENUE_IN_RANGE_CONTROLLER;
            } else if (REPORT_REVENUE_DAILY.equals(action)) {
                url = REPORT_REVENUE_DAILY_CONTROLLER;
            } else if (REPORT_REVENUE_MONTHLY.equals(action)) {
                url = REPORT_REVENUE_MONTHLY_CONTROLLER;
            } else if (REPORT_REVENUE_YEARLY.equals(action)) {
                url = REPORT_REVENUE_YEARLY_CONTROLLER;
            } else if (BEST_SELLER.equals(action)) {
                url = BEST_SELLER_CONTROLLER;
            } else if (ALMOST_OVER_PRODUCT.equals(action)) {
                url = ALMOST_OVER_PRODUCT_CONTROLLER;
            } else if (TOP_CUSTOMER.equals(action)) {
                url = TOP_CUSTOMER_CONTROLLER;
            } else if (LIST_PRODUCT_IN_RANGE.equals(action)) {
                url = LIST_PRODUCT_IN_RANGE_CONTROLLER;
            }else if (CLEAR_CART.equals(action)) {
                url = CLEAR_CART_CONTROLLER;
            } else if(UPDATE_MY_PROFILE.equals(action)) {
                url = UPDATE_MY_PROFILE_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
