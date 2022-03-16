<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page 6</title>
        <link href="css/login.css" rel="stylesheet">

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Tabs Titles -->

                <!-- Icon -->

                <div class="fadeIn first">
                    <img src="pictures/ote_cosmote.jpg" id="icon" alt="User Icon" />

                    <c:if test="${param.logout != null}"> <!-- Πήρα την παράμετρο logout. -->
                        <div class="logout">
                            <i>You logged out successfully</i>
                        </div>
                    </c:if>

                    <c:if test="${param.error != null}">
                        <div class="error">
                            <i>Invalid credentials</i>
                        </div>
                    </c:if>    


                    <c:if test="${param.registered != null}">
                        <div class="registered">
                            <i>Successfully Registered. Try to sign in.</i>
                        </div>
                    </c:if>   


                </div>

                <!-- Login Form -->
                <form:form action="/authenticate" method="POST">
                    <input type="text" id="login" class="fadeIn second" name="username" placeholder="login">
                    <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
                    <input type="submit" class="fadeIn fourth" value="Log In Sales">
                </form:form>

                <!-- Remind Passowrd -->
                <div id="formFooter">
                    <a class="underlineHover" href="/register">Register</a>
                </div>

            </div>
        </div>    


    </body>
</html>
