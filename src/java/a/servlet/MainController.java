package a.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    private static final String LOGIN_PAGE = "login.jsp";

    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";

    //navigate to controller
    private static final String CREATE = "Signup";
    private static final String CREATE_CONTROLLER = "CreateAccountController";

    //action of admin
    private static final String ADMIN = "AdminPage";
    private static final String ADMIN_PAGE = "admin.jsp";
    private static final String MANAGE_USER = "Manage User";
    private static final String MANAGE_USER_PAGE = "manageUser.jsp";
    private static final String MANAGE_PRODUCT = "Manage Product";
    private static final String MANAGE_PRODUCT_PAGE = "manageProduct.jsp";
    private static final String MANAGE_INVOICE = "Manage Invoice";
    private static final String MANAGE_INVOICE_PAGE = "manageInvoice.jsp";
    private static final String SEARCH_USER = "searchUser";
    private static final String SEARCH_USER_CONTROLLER = "SearchUserController";
    private static final String DELETE_USER = "DeleteUser";
    private static final String DELETE_USER_CONTROLLER = "DeleteUserController";
    private static final String UPDATE_USER = "UpdateUser";
    private static final String UPDATE_USER_CONTROLLER = "UpdateUserController";
    private static final String UPDATE_PRODUCT = "UpdateProduct";
    private static final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductController";
    private static final String SEARCH_PRODUCT = "searchProduct";
    private static final String SEARCH_PRODUCT_CONTROLLER = "SearchProductController";
    private static final String SEARCH_INVOICE = "searchInvoice";
    private static final String SEARCH_INVOICE_CONTROLLER = "SearchInvoiceController";

    private static final String VIEW_PRODUCT = "ViewProduct";
    private static final String VIEW_PRODUCT_CONTROLLER = "ViewProductController";

    private static final String VIEW_CART = "ViewCart";
    private static final String CART_PAGE = "cart.jsp";

    private static final String ADD_TO_CART = "AddToCart";
    private static final String ADD_TO_CART_CONTROLLER = "AddToCartController";

    private static final String REMOVE_CART = "Remove";
    private static final String REMOVE_CONTROLLER = "RemoveController";
    private static final String UPDATE_CART = "Change";
    private static final String UPDATE_CART_CONTROLLER = "UpdateCartController";
    private static final String CHECKOUT_PAGE_ACTION = "CheckoutPage";
    private static final String CHECKOUT_PAGE = "checkout.jsp";
    private static final String CHECKOUT = "Checkout";
    private static final String CHECKOUT_CONTROLLER = "CheckoutController";
    private static final String SEARCH_BY_CATEGORY = "searchByCategory";
    private static final String SEARCH_BY_CATEGORY_CONTROLLER = "SearchByCategoryController";
    private static final String SEARCH_BY_PRICE = "searchByPrice";
    private static final String SEARCH_BY_PRICE_CONTROLLER = "SearchByPriceController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = LOGIN_PAGE;
            } else if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (CREATE.equals(action)) {
                url = CREATE_CONTROLLER;
            } else if (MANAGE_USER.equals(action)) {
                url = MANAGE_USER_PAGE;
            } else if (MANAGE_PRODUCT.equals(action)) {
                url = MANAGE_PRODUCT_PAGE;
            } else if (SEARCH_USER.equals(action)) {
                url = SEARCH_USER_CONTROLLER;
            } else if (UPDATE_USER.equals(action)) {
                url = UPDATE_USER_CONTROLLER;
            } else if (DELETE_USER.equals(action)) {
                url = DELETE_USER_CONTROLLER;
            } else if (SEARCH_PRODUCT.equals(action)) {
                url = SEARCH_PRODUCT_CONTROLLER;
            } else if (VIEW_PRODUCT.equals(action)) {
                url = VIEW_PRODUCT_CONTROLLER;
            } else if (ADD_TO_CART.equals(action)) {
                url = ADD_TO_CART_CONTROLLER;
            } else if (VIEW_CART.equals(action)) {
                url = CART_PAGE;
            } else if (REMOVE_CART.equals(action)) {
                url = REMOVE_CONTROLLER;
            } else if (UPDATE_CART.equals(action)) {
                url = UPDATE_CART_CONTROLLER;
            } else if (CHECKOUT_PAGE_ACTION.equals(action)) {
                url = CHECKOUT_PAGE;
            } else if (CHECKOUT.equals(action)) {
                url = CHECKOUT_CONTROLLER;
            } else if (UPDATE_PRODUCT.equals(action)) {
                url = UPDATE_PRODUCT_CONTROLLER;
            } else if (ADMIN.equals(action)) {
                url = ADMIN_PAGE;
            } else if (MANAGE_INVOICE.equals(action)) {
                url = MANAGE_INVOICE_PAGE;
            } else if (SEARCH_INVOICE.equals(action)) {
                url = SEARCH_INVOICE_CONTROLLER;
            } else if (SEARCH_BY_CATEGORY.equals(action)) {
                url = SEARCH_BY_CATEGORY_CONTROLLER;
            } else if (SEARCH_BY_PRICE.equals(action)) {
                url = SEARCH_BY_PRICE_CONTROLLER;
            }

        } catch (Exception e) {
            e.printStackTrace();
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
