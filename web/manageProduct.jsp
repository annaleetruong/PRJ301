<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="a.product.ProductDTO"%>
<%@page import="a.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Product Page</title>
        <link rel="stylesheet" href="css/manageProduct.css">
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"AD".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <div class="admin-info"><h1>Product Management</h1></div>
        <div class="logout-link">${sessionScope.LOGIN_USER.fullName} <a href="MainController?action=Logout">Log out</a></div>
        <div class="back-link"><a href="MainController?action=AdminPage">Back</a></div>
        <%
            String searchProduct = request.getParameter("searchProduct");
            if (searchProduct == null) {
                searchProduct = "";
            }
        %>
        <div class="input-search">
            <form action="MainController" method="POST">
                <input type="text" name="searchProduct" value="<%=searchProduct%>"/>
                <button type="submit" name="action" value="searchProduct">Search</button>
            </form>
        </div>
        <%
            List<ProductDTO> listProduct = (ArrayList) request.getAttribute("LIST_PRODUCT");
            if (listProduct != null) {
                if (listProduct.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <!--<th>Img</th>-->
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Quantity</th>                       
                    <th>Price</th>                       
                    <th>Is Saled</th>                       
                </tr>
            </thead>
            <tbody>
                <%
                    for (ProductDTO product : listProduct) {
                        float number = product.getPrice(); // Giá trị cần hiển thị
                        NumberFormat numberFormat = NumberFormat.getInstance(); // Lấy đối tượng NumberFormat
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%=product.getProID()%></td>
                    <td><input type="text" name="name" value="<%=product.getName()%>"/></td>
                    <td><input type="number" name="quantity" value="<%=product.getQuantity()%>" min="1"/></td>
                    <td><input type="number" name="price" value="<%=number%>" min="1"/></td>
                    <td><input type="checkbox" name="sale" value="ON" 
                               <%
                                   if (product.isSale()) {
                               %>
                               checked="checked"
                               <%
                                   }
                               %>
                               /></td>
                    <td>
                        <input type="hidden" name="proID" value="<%=product.getProID()%>"/>
                        <input type="hidden" name="description" value="<%=product.getDescription()%>"/>
                        <input type="hidden" name="srcImg" value="<%=product.getSrcImg()%>"/>
                        <input type="hidden" name="category" value="<%= product.getCategory()%>"/>
                        <input type="hidden" name="searchProduct" value="<%=searchProduct%>"/>
                        <input type="submit" name="action" value="UpdateProduct"/>
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
    %>
    ${requestScope.ERROR_SALE}
    ${requestScope.ERROR_NUMBER}
</body>
</html>
