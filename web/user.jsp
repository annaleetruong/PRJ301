<%@page import="java.text.NumberFormat"%>
<%@page import="a.product.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="a.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grocery Store</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
        <link rel="stylesheet" href="css/user.css">
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
                <li><a href="MainController?action=searchByCategory&categoryID=C1">Vegetable</a></li>
                <li><a href="MainController?action=searchByCategory&categoryID=C2">Fruit</a></li>
                <li><a href="MainController?action=ViewCart">View Cart</a></li>
            </ul>
            <div class="header-left">
                <form action="MainController" method="POST">
                    <input type="text" name="searchProduct" value="<%=searchProduct%>"/>
                    <button type="submit" name="action" value="searchProduct">Search</button>
                </form>
                <span class="separator">|</span>
                <a href="MainController?action=Logout">Log out</a>
                <i class="fa-solid fa-right-from-bracket"></i>
            </div>
        </div>
        <div>
            <img class="banner" src="image/banner.jpg"/>
        </div>
        <div class="dropdown-wrap">
            <h2>Products</h2>
            <div>
                <div class="dropdown">
                    <ul id="my-dropdown2">
                        <li><a href="MainController?action=searchByPrice&priceMin=0&priceMax=5000">Less than 5000</a></li>
                        <li><a href="MainController?action=searchByPrice&priceMin=5000&priceMax=10000">5000 - 10000</a></li>
                        <li><a href="MainController?action=searchByPrice&price=10000">Greater than 10000</a></li>
                    </ul>
                    <a href="#my-dropdown2"
                       aria-controls="my-dropdown2"
                       role="button"
                       data-toggle="dropdown"
                       id="my-dropdown2-btn">
                        Choose one
                    </a>
                    <a href="#my-dropdown2-btn"
                       aria-controls="my-dropdown2"
                       role="button"
                       data-toggle="dropdown"
                       class="close">
                    </a>
                </div>
            </div>
        </div>
        <%
            List<ProductDTO> listProduct = (ArrayList) request.getAttribute("LIST_PRODUCT");

            if (!listProduct.isEmpty()) {
        %>
        <ul class="products">
            <%
                for (ProductDTO product : listProduct) {
                    float number = product.getPrice(); // Giá trị cần hiển thị
                    NumberFormat numberFormat = NumberFormat.getInstance(); // Lấy đối tượng NumberFormat
            %>
            <li class="product-list">
                <div class="product-item">
                    <div class="product-top">
                        <a href="MainController?action=ViewProduct&proID=<%=product.getProID()%>" class="product-thumb">
                            <img src="image/<%=product.getSrcImg()%>.jpg">
                        </a>
                    </div>
                    <div class="product-info">
                        <a href="MainController?action=ViewProduct&proID=<%=product.getProID()%>" class="product-name"><%=product.getName()%></a>
                        <div class="product-price"><%=numberFormat.format(number)%></div>
                    </div>
                </div>
            </li>
            <%
                }
            %>
        </ul>
        <%
        } else {
        %>
        <div id="no-product">
            <span>There is no product</span>
        </div>
        <%
            }
        %>
    </body>
</html>
