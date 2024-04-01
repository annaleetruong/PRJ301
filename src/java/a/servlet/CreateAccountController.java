package a.servlet;

import a.user.UserDAO;
import a.user.UserError;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAccountController extends HttpServlet {

    private static final String ERROR = "registration.jsp";
    private static final String SUCCESS = "LoginController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError UserError = new UserError();
        try {

            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            
            UserDAO dao = new UserDAO();
            boolean checkValidation = false;
            boolean checkExisted = dao.chechExisted(userID);
            if (userID.length() < 6 || userID.length() > 20) {
                UserError.setUsernameLengthError("Username must have 6 - 20 characters");
                checkValidation = true;
            }
            if (password.length() < 8 || password.length() > 30) {
                UserError.setPasswordLengthError("Password must have 8 - 30 characters");
                checkValidation = true;
            } else if (!confirm.equals(password)) {
                UserError.setConfirmPasswordError("Wrong password confirm");
                checkValidation = true;
            }
            if (fullName.length() < 8 || fullName.length() > 50) {
                UserError.setFullnameLengthError("Fullname must have 8 - 50 characters");
                checkValidation = true;
            }
            if (checkExisted) {
                UserError.setUsernameExistError("Username already existed");
                checkValidation = true;
            }
            if (!checkValidation) {
                boolean checkInsert = dao.insert(userID, fullName, password);
                if (checkInsert) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Unknow error!");
                }
            } else {
                request.setAttribute("USER_ERROR", UserError);
            }

        } catch (Exception e) {

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
