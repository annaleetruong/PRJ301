<%@page import="java.text.NumberFormat"%>
<%@page import="a.user.InvoiceDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="a.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ManageInvoice Page</title>
        <link rel="stylesheet" href="css/manageInvoice.css">
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"AD".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <div class="admin-info"><h1>Invoice Management</h1></div>
        <div class="logout-link"><span>Admin: ${sessionScope.LOGIN_USER.fullName}</span><a href="MainController?action=Logout">Log out</a></div>
        <div class="back-link"><a href="MainController?action=AdminPage">Back</a></div>
<%
            String searchInvoice = request.getParameter("searchInvoice");
            if (searchInvoice == null) {
                searchInvoice = "";
            }
        %>
        <div class="input-search">
        <form action="MainController" method="POST">
            <input type="text" name="searchInvoice" value="<%=searchInvoice%>"/>
            <button type="submit" name="action" value="searchInvoice">Search</button>
        </form>
        </div>
            <%
                List<InvoiceDTO> listInvoice = (ArrayList) request.getAttribute("LIST_INVOICE");
                if (listInvoice != null) {
                    if (listInvoice.size() > 0) {
            %>
            <table border="1">
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Pro ID</th>
                        <th>Quantity</th>                       
                        <th>Price</th>                       
                        <th>Phone</th>                       
                        <th>Date</th>                       
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (InvoiceDTO invoice : listInvoice) {
                            float number = invoice.getPrice(); // Giá trị cần hiển thị
                            NumberFormat numberFormat = NumberFormat.getInstance(); // Lấy đối tượng NumberFormat
                    %>
                    <tr>
                        <td><%=invoice.getUserID()%></td>
                        <td><%=invoice.getProID()%></td>
                        <td><%=invoice.getQuantity()%></td>
                        <td><%=numberFormat.format(number)%></td>
                        <td><%=invoice.getPhone()%></td>
                        <td><%=invoice.getDate()%></td>
                    </tr>
                <%
                    }
                %>
                </tbody>
            </table>
                <%
                        }
                    }
                %>
    </body>
</html>
