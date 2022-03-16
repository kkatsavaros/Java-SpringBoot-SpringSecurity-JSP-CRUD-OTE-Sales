<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %><!-- JSTL -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link href="css/register.css" rel="stylesheet">

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>    

    </head>
    <body>

        <div class="container">
            <div class="row main">
                <div class="main-login main-center">
                    <h5>Sign up</h5>
                    
                    <!-- /register: RegisterController -->
                    <!-- modelAttribute="myuser" : Συλλέγουμε τα στοιχεία της φόρμας σε ένα Object.
                         έρχεται από το: RegisterController
                    -->
                    <form:form action="/register" method="POST" modelAttribute="myuser"> <!-- -->

                        <div class="form-group">
                            <label for="fname" class="cols-sm-2 control-label">First Name</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <!-- path από το Entity MyUser-->
                                    <form:input class="form-control" path="fname"  id="fname"  placeholder="Enter your Name"/> <!-- -->
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="lname" class="cols-sm-2 control-label">Last Name</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <!-- path από το Entity MyUser-->
                                    <form:input class="form-control" path="lname"  id="lname"  placeholder="Enter your Name"/>
                                </div>
                            </div>
                        </div>        

                        <div class="form-group">
                            <label for="email" class="cols-sm-2 control-label">Your Email</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                        <form:input type="email" class="form-control" path="email" id="email"  placeholder="Enter your Email"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Username</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                        <form:input class="form-control" path="username" id="username"  placeholder="Enter your Username"/>
                                    
                                        <form:errors class="form-control" path="username" id="username"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label">Password</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                        <form:input class="form-control" path="password" id="password"  placeholder="Enter your Password"/>
                                </div>
                            </div>
                        </div>


                        <div class="form-group ">
                            <input type="submit" value="Register" class="btn btn-primary btn-lg btn-block login-button" id="button">
                            <!--a href="https://deepak646.blogspot.com/" target="_blank" type="button" id="button" class="btn btn-primary btn-lg btn-block login-button">Register</a -->
                        </div>

                    </form:form>

                </div>
            </div>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
