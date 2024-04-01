<%-- 
    Document   : pagesuccess
    Created on : Jul 19, 2023, 6:11:13 PM
    Author     : HP
--%>

<%@page import="a.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PaySuccess Page</title>
        <link rel="stylesheet" href="css/pagesuccess.css">
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"US".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
            String searchProduct = request.getParameter("searchProduct");
            if (searchProduct == null) {
                searchProduct = "";
            }
        %>
        <div class="header">
            <div class="user-name">
                <h1>Welcome: ${sessionScope.LOGIN_USER.fullName}!</h1>
            </div>
            <div class="header-left">
                <form action="MainController" method="POST">
                    <input type="text" name="searchProduct" value="<%=searchProduct%>"/>
                    <button type="submit" name="action" value="searchProduct">Search</button>
                </form>
                <span class="separator">|</span>
                <a href="MainController?action=Logout">Log out</a>
            </div>
        </div>
        <ul>
            <li><a href="MainController?action=searchProduct&searchProduct=">Home</a></li>
            <li><a href="MainController?action=searchProduct&searchProduct=">Product</a></li>
            <li><a href="MainController?action=ViewCart">View Cart</a></li>
        </ul>
        <div class="pay-success">
            <span>${requestScope.PAYSUCCESS}</span><br>
            <form action="MainController" method="POST">
                <button type="submit" name="action" value="searchProduct">Buy more</button>
            </form>
        </div>   
    </body>
</html>
