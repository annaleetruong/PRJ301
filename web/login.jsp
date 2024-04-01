<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <div class="container">
            <div class="login form">
                <header>Login Page</header>
                <form action="MainController" method="POST">
                    <input type="text" placeholder="Enter your email" name="userID">
                    <input type="password" placeholder="Enter your password" name="password">
                    <span style="color: red;">${requestScope.ERROR}</span>
                    <input type="submit" class="button" value="Login" name="action">
                </form>

                <div class="signup">
                    <span class="signup">Don't have an account?
                        <label><a href="registration.jsp">Signup</a></label>
                    </span>
                </div>
            </div>
        </div>
    </body>
</html>

