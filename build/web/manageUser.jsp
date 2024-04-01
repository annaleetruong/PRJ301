<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="a.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage User Page</title>
        <link rel="stylesheet" href="css/manageUser.css">
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"AD".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <div class="admin-info"><h1>User Management</h1></div>
        <div class="logout-link">${sessionScope.LOGIN_USER.fullName} <a href="MainController?action=Logout">Log out</a></div>
        <div class="back-link"><a href="MainController?action=AdminPage">Back</a></div>
        <%
            String searchUser = request.getParameter("searchUser");
            if (searchUser == null) {
                searchUser = "";
            }
        %>
        <form action="MainController" method="POST">
            <input type="text" name="searchUser" value="<%=searchUser%>"/>
            <button class="button-search" type="submit" name="action" value="searchUser">Search</button>
        </form>
        <%
            List<UserDTO> listUser = (ArrayList) request.getAttribute("LIST_USER");
            if (listUser != null) {
                if (listUser.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Full name</th>
                    <th>Role ID</th>
                    <th>Password</th>                       
                    <th>Is Banned</th>                       
                </tr>
            </thead>
            <tbody>
                <%
                    for (UserDTO user : listUser) {
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%=user.getUserID()%></td>
                    <td><input type="text" name="fullName" value="<%=user.getFullName()%>"/></td>
                    <td><input type="text" name="roleID" value="<%=user.getRoleID()%>"/></td>
                    <td><%=user.getPassword()%></td>
                    <td><input type="checkbox" name="isBanned" value="ON"
                               <%
                                   if (user.isIsBanned()) {
                               %>
                               checked="checked"
                               <%
                                   }
                               %>
                               /></td>
                    <td><a href="MainController?action=DeleteUser&userID=<%=user.getUserID()%>&searchUser=<%=searchUser%>">Delete</a></td>
                    <td>
                        <input type="hidden" name="userID" value="<%=user.getUserID()%>"/>
                        <input type="hidden" name="searchUser" value="<%=searchUser%>"/>
                        <input type="submit" name="action" value="UpdateUser"/>
                    </td>
                </tr>
            </form> 
            <%
                }
            %>
        </tbody>
    </table>
    <%
            }
        }

        String fullNameError = (String) request.getAttribute("ERROR_UPDATE_FULLNAME");
        if (fullNameError == null) {
            fullNameError = "";
        }
        String roleIDError = (String) request.getAttribute("ERROR_UPDATE_ROLE");
        if (roleIDError == null) {
            roleIDError = "";
        }
        String deleteError = (String) request.getAttribute("ERROR_DELETE");
        if (deleteError == null) {
            deleteError = "";
        }
    %>
    <span class="msg-error"><%=fullNameError%></span>
    <span class="msg-error"><%=roleIDError%></span>
    <span class="msg-error"><%=deleteError%></span>
</body>
</html>
