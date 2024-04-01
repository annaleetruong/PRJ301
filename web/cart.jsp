<%@page import="java.text.NumberFormat"%>
<%@page import="a.user.UserDTO"%>
<%@page import="a.product.CartDTO"%>
<%@page import="a.product.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link rel="stylesheet" href="css/cart.css">
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
            <ul>
                <li><a href="MainController?action=searchProduct&searchProduct=">Home</a></li>
                <li><a href="MainController?action=searchProduct&searchProduct=">Product</a></li>
                <li><a href="MainController?action=ViewCart">View Cart</a></li>
            </ul>
            <div class="header-left">
                <form action="MainController" method="POST">
                    <input type="text" name="searchProduct" value="<%=searchProduct%>"/>
                    <button type="submit" name="action" value="searchProduct">Search</button>
                </form>
                <span class="separator">|</span>
                <a href="MainController?action=Logout">Log out</a>
            </div>
        </div>

        <h2 class="cart-title">Your cart</h2>    
        <% CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="0">
            <!--            <thead>
                            <tr>
                                <th>No</th>
                                <th>Img</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                            </tr>
                        </thead>-->
            <tbody>
                <%
                    int count = 1;
                    float total = 0, TOTAL = 0;
                    for (ProductDTO product : cart.getCart().values()) {
                        total = product.getQuantity() * product.getPrice();
                        TOTAL += total;
                        float number = total; // Giá trị cần hiển thị
                        NumberFormat numberFormat = NumberFormat.getInstance(); // Lấy đối tượng NumberFormat
%>
            <form action="MainController" method="POST">
                <tr>
                    <!--<td><%=count++%></td>-->
                    <td><img class="img-product" src="image/<%=product.getSrcImg()%>.jpg"></td>
                    <td><%=product.getName()%></td>
                    <td><%=product.getPrice()%></td>
                    <td><input type="number" name="quantity" min="1"  value="<%=product.getQuantity()%>"/></td>
                    <td><%=numberFormat.format(number)%></td>
                    <td>       
                        <input type="hidden" name="productID" value="<%=product.getProID()%>"/>
                        <button type="submit" name="action" value="Remove">Remove</button>
                    </td>
                    <td>
                        <button type="submit" name="action" value="Change">Change</button>
                    </td>
                </tr>
            </form>
            <% } %>
        </tbody>
    </table>
    <%
        float number2 = TOTAL;
        NumberFormat numberFormat = NumberFormat.getInstance(); // Lấy đối tượng NumberFormat
%>
    <span class="total-money">Total: <%=numberFormat.format(number2)%></span>
    <% }%>
    <%
        if (cart != null) {
    %>        
    <form action="MainController" method="POST">
        <button type="submit" value="CheckoutPage" name="action">PAY</button>
    </form>
    <%
    } else {
    %>
    <div class="null-cart-wrap">
        <div class="null-cart">
            <span>Nothing in your cart.</span><br>
            <form action="MainController" method="POST">
                <button type="submit" name="action" value="searchProduct">Buy more</button>
            </form>
        </div>
    </div>
    <%
        }
    %>
    ${requestScope.PAYFALSE}
</body>
</html>
