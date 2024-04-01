<%@page import="a.user.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="a.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link rel="stylesheet" href="css/viewProduct.css">
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
        <%
            String msg = (String) request.getAttribute("MESSAGE");
            if (msg == null) {
                msg = "";
            }
            ProductDTO viewProduct = (ProductDTO) request.getAttribute("VIEW_PRODUCT");

            float number = viewProduct.getPrice(); // Giá trị cần hiển thị
            NumberFormat numberFormat = NumberFormat.getInstance(); // Lấy đối tượng NumberFormat
%>
        <%=msg%>
        <div class="products-viewed">
            <img src="image/<%=viewProduct.getSrcImg()%>.jpg"/>
            <div class="product-viewed-left">
                <h2 class="product-viewed-name"><%=viewProduct.getName()%></h2>
                <span class="product-viewed-price"><%=numberFormat.format(number)%></span>
                <div class="product-viewed-featrue">
                    <p><%=viewProduct.getDescription()%></p><br>
                </div>
                <%
                    if (viewProduct.isSale()) {
                %>
                <form action="MainController">
                    <!--create a productDTO to add-->
                    <input type="hidden" name="proID" value="<%=viewProduct.getProID()%>"/>
                    <input type="hidden" name="name" value="<%=viewProduct.getName()%>"/>
                    <input type="hidden" name="description" value="<%=viewProduct.getDescription()%>"/>
                    <input type="hidden" name="srcImg" value="<%=viewProduct.getSrcImg()%>"/>
                    <input type="hidden" name="price" value="<%=viewProduct.getPrice()%>"/>
                    <input type="hidden" name="sale" value="<%=viewProduct.isSale()%>"/>
                    <input type="hidden" name="category" value="<%=viewProduct.getCategory() %>"/>
                    <div class="form">
                        <div class="input-number">
                            <input type="number" name="quantity" min="1" max="<%=viewProduct.getQuantity()%>" step="1" value="1"/>
                        </div>
                        <div class="add-button">
                            <button type="submit" name="action" value="AddToCart">Add to cart</button>
                        </div>
                    </div>
                </form>
                <%
                    }
                %>
            </div>    
        </div>
        <h3 class="title-h3">Related products</h3>
        <ul class="products">
            <%
                List<ProductDTO> listProduct = (ArrayList) request.getAttribute("LIST_PRODUCT");
                for (ProductDTO product : listProduct) {
                    float number2 = product.getPrice(); // Giá trị cần hiển thị
                    NumberFormat numberFormat2 = NumberFormat.getInstance(); // Lấy đối tượng NumberFormat
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
                        <div class="product-price"><%=numberFormat2.format(number2)%></div>
                    </div>
                </div>
            </li>
            <%
                }
            %>
        </ul>
    </body>
</html>
