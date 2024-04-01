<%@page import="a.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
        <link rel="stylesheet" href="css/admin.css"/>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"AD".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <div class="header">
            <h1>Admin: ${sessionScope.LOGIN_USER.fullName}</h1>
            <ul class="navigate">
                <li><a href="MainController?action=Manage User"> Manage User</a></li>
                <li><a href="MainController?action=Manage Product">Manage Product</a></li>
                <li><a href="MainController?action=Manage Invoice">Manage Invoice</a></li>   
            </ul>
            <div class="logout-link">
                <a href="MainController?action=Logout">Logout</a>
                <i class="fa-solid fa-right-from-bracket"></i>
            </div>
        </div>
    </body>
</html>


