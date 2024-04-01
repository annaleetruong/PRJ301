<%@page import="a.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Page</title>
        <link rel="stylesheet" href="css/checkout.css">
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
            <div class="logo">
                <img src="image/Logo.jpg" alt="">     
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
        <div class="form-phone">
            <form action="MainController" method="POST">
                <h2>Consignee phone number</h2>
                <input type="text" name="phone" required="" placeholder="Phone number"/>
                <button type="submit" name="action" value="Checkout">Check out</button>
            </form>
        </div>    
    </body>
</html>
