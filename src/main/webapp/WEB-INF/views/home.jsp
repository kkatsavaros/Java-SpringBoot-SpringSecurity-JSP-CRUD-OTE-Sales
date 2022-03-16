<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/b4megamenu.css">
        <link rel="stylesheet" href="css/CustomStyles.css">

        <title>Home Page</title>
    </head>
    <body>
        <div class="container">

           
            <div class="well">
            <h1 class="text-danger text-center">Welcome to Spring Security</h1>
            </div>

            <div class="well">
            <!-- Ποιος χρήστης είναι Login.-->
            <p class="text-success text-center">
                User: <sec:authentication property="principal.username"/>
                <br/><br/>
                Role(s):<sec:authentication property="principal.authorities"/>
            </p>

            <hr/>
            <!-- Εγινε log in κανονικά και  -->

            <!-- Πατώντας το link, Θα μας πάει στην σελίδα του administrator -->        
            <!-- Αυτό το div να μου το εμφανίζει μόνο όταν κάποιος έχει ρόλο admin-->
            <sec:authorize access="hasRole('ADMIN')">            
                <div class="text-center"><a href="/admin" class="btn btn-primary">Administrator Home Page</a></div>
            </sec:authorize>


            <br/>
            <!-- Πατώντας το link, Θα μας πάει στην σελίδα του Teacher -->
            <!-- Αυτό το div να μου το εμφανίζει μόνο όταν κάποιος έχει ρόλο admin-->
            <sec:authorize access="hasRole('TEACHER')">
                <div><a href="/teacher">Teacher Home Page</a></div>
            </sec:authorize>

            <br/>

            <!-- Για να κάνει logout --> 
            <form:form action="/logout" method="POST" class="text-center">
                <input type="submit" value="Logout" class="btn btn-info btn-sm ">                
            </form:form>
            </div>
        </div>

    </body>
</html>
