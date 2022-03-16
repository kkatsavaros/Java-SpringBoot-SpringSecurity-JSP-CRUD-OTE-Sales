<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/b4megamenu.css">
        <link rel="stylesheet" href="css/CustomStyles.css">

        <title>SalesForm.jsp</title>
    </head>

    <body>
        <div class="container">


            <div class="well">                
                <jsp:include page="horizontal_menu_main.jsp" />  
            </div>

            <div class="well">
                <h1 class="text-danger text-center">Kavalas Fiber Network</h1>
            </div>


            <img src="pictures/Filippou_Fiber.png" class="img-thumbnail" alt="OTE"> 

            <br/><br/>

            <img src="pictures/Pergamou_Fiber.png" class="img-thumbnail" alt="OTE"> 

            <br/><br/>

            <div class="well">                
                <jsp:include page="footer.jsp" />  
            </div>



        </div><!-- end of container-->
    </body>
</html>
