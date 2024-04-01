<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <c:set var="error" value="${requestScope.USER_ERROR}" />
        <div class="container">
            <div class="registration form">
                <header>Signup</header>
                <form action="MainController" method="POST">
                    <input type="text" placeholder="Enter your username(6 - 20 characters)" name="userID"/>
                    <c:if test="${not empty error.usernameLengthError}">
                        <span>${error.usernameLengthError}</span>
                    </c:if>
                    <input type="password" placeholder="Create a password(8 - 30 characters)" name="password"/>
                    <c:if test="${not empty error.passwordLengthError}">
                        <span>${error.passwordLengthError}</span>
                    </c:if>
                    <input type="password" placeholder="Confirm your password" name="confirm"/>
                    <c:if test="${not empty error.confirmPasswordError}">
                        <span>${error.confirmPasswordError}</span>
                    </c:if>
                    <input type="text" placeholder="Enter your fullname(8 - 50 characters)" name="fullName"/>
                    <c:if test="${not empty error.fullnameLengthError}">
                        <span>${error.fullnameLengthError}</span>
                    </c:if>
                    <c:if test="${not empty error.usernameExistError}">
                        <span>${error.usernameExistError}</span>
                    </c:if>
                    <input type="submit" class="button" value="Signup" name="action">
                </form>
                <div class="signup">
                    <span class="signup">Already have an account?
                        <label><a href="login.jsp">Login</a></label>
                    </span>
                </div>
            </div>
    </body>
</html>
