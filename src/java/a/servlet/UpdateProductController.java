package a.servlet;

import a.product.ProductDAO;
import a.product.ProductDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProductController extends HttpServlet {

    private static final String ERROR = "SearchProductController";
    private static final String SUCCESS = "SearchProductController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
        System.out.println("haha");
            String proID = request.getParameter("proID");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String srcImg = request.getParameter("srcImg");
            String categoryID = request.getParameter("category");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            float price = Float.parseFloat(request.getParameter("price"));
            String sale = request.getParameter("sale");
            boolean checkValidation = true;
            boolean isSale = false;
            if (quantity < 0 || price < 0) {
                checkValidation = false;
                request.setAttribute("ERROR_NUMBER", "Number must be > 0");
            }
            if (sale != null) {
                isSale = true;
            }
            if (checkValidation) {
                System.out.println("haah");
                ProductDAO dao = new ProductDAO();
                ProductDTO productUpdate = new ProductDTO(proID, name, description, price, quantity, srcImg, isSale, categoryID);
                boolean checkUpdate = dao.update(productUpdate);
                if (checkUpdate) {
                    url = SUCCESS;
                }
            }
        } catch (Exception e) {
            log("Error at UpdateUserController: " + e.toString());
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
