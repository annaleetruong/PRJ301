package a.servlet;

import a.product.ProductDAO;
import a.product.ProductDTO;
import a.user.UserDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchProductController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String AD = "AD";
    private static final String ADMIN_PAGE = "manageProduct.jsp";
    private static final String US = "US";
    private static final String USER_PAGE = "user.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String searchProduct = request.getParameter("searchProduct");
            if (searchProduct == null) {
                searchProduct = "";
            }
            ProductDAO dao = new ProductDAO();
            HttpSession session = request.getSession();
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (AD.equals(loginUser.getRoleID())) {
                url = ADMIN_PAGE;
                List<ProductDTO> listProduct = dao.getListProductByAdmin(searchProduct);
                request.setAttribute("LIST_PRODUCT", listProduct);
            } else if (US.equals(loginUser.getRoleID())) {
                url = USER_PAGE;
                List<ProductDTO> listProduct = dao.getListProductByUser(searchProduct);
                request.setAttribute("LIST_PRODUCT", listProduct);
            }
        } catch (Exception e) {
            log("Error at SearchUserController: " + e.toString());
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
