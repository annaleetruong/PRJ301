package a.servlet;

import a.user.UserDAO;
import a.user.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUserController extends HttpServlet {

    private static final String ERROR = "SearchUserController";
    private static final String SUCCESS = "SearchUserController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String banned = request.getParameter("isBanned");
            boolean isBanned = false;
            if (banned != null) {
                isBanned = true;
            }
            boolean checkValidation = true;
            if (fullName.length() > 30 || fullName.length() < 1) {
                checkValidation = false;
                request.setAttribute("ERROR_UPDATE_FULLNAME", "Full name cannot be more than 30 characters");
            }
            if (!"AD".equals(roleID)) {
                if (!"US".equals(roleID)) {
                    checkValidation = false;
                    request.setAttribute("ERROR_UPDATE_ROLE", "Role are AD or US");
                }
            }
            if (checkValidation) {
                UserDAO dao = new UserDAO();
                boolean checkUpdate = dao.update(fullName, roleID, userID, isBanned);
                if (checkUpdate) {
                    HttpSession session = request.getSession();
                    UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                    if (loginUser.getUserID().equals(userID)) {
                        loginUser.setFullName(fullName);
                        loginUser.setRoleID(roleID);
                        session.setAttribute("LOGIN_USER", loginUser);
                    }
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
