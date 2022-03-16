<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
    <a name="a0"></a>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="css/b4megamenu.css">
    <link rel="stylesheet" href="css/CustomStyles.css">

    <title>salesList.jsp</title>

</head>

<body>
    <div class="container">

        <div class="well">                
            <jsp:include page="horizontal_menu_main.jsp" />  
        </div>

        <div class="well">
            <h1 class="text-danger text-center">This is my List of sales</h1>
        </div>




        <!--div class="well">

            <form action="/admin">

                <input type="text" name="keyword" class="form-control form-control-sm" placeholder="Filter"/>  
                <br/>
                <button type="submit" value="Search" class="btn btn-primary btn-sm"/>
                Search &nbsp
                <span class="glyphicon glyphicon-search"></span>
                </button>
                &nbsp&nbsp
                <input type="button" value="Show All" onclick="clearFilter()" class="btn btn-primary btn-sm"/>

            </form>
        </div-->



        <div class="well">

            <h4 class="text-info text-center">${message}</h1>

                <a href="${pageContext.request.contextPath}/admin/create" class="btn btn-success btn-sm" role="button">Add sale</a>
                <br/><br/>


                <h4 class="text-info text-center">Βρέθηκαν συνολικά: ${numberOfRecords} εγγραφές.</h1>    



                    <div class="table-responsive">
                        <div class="col-xs-12">
                            <table class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>id</th> <th>name</th> <th>Stathero</th> <th>Kinito</th>
                                        <th>Perioxi</th> <th>Eidos Polisis</th> <th>notes</th>
                                        <th>mylead</th> <th>mydate</th>
                                        <th colspan="2">Actions</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${listOfAuthors}" var = "sale">

                                    <c:if test = "${sale.mylead == 'ΕΝΑΡΞΗ ΠΩΛΗΣΗΣ'}">
                                        <c:set var="Income" value="#00eaff"/>  
                                    </c:if>
                                    
                                    
                                    <c:if test = "${sale.mylead == 'ΚΑΤΑΧΩΡΗΣΗ'}">
                                        <c:set var="Income" value="blue"/>  
                                    </c:if>

                                    <c:if test = "${sale.mylead == 'ΚΑΤΑΧΩΡΗΣΗ - BUSINESS'}">
                                        <c:set var="Income" value="blue"/>  
                                    </c:if>



                                    <c:if test = "${sale.mylead == 'ΜΗ ΠΩΛΗΣΗ - ΑΔΥΝΑΜΙΑ ΕΠΙΚΟΙΝΩΝΙΑΣ'}">
                                        <c:set var="Income" value="#ff66ff"/>  
                                    </c:if>

                                    <c:if test = "${sale.mylead == 'ΜΗ ΠΩΛΗΣΗ - ΕΛΙΠΠΗΣ ΕΠΙΚΟΙΝΩΝΙΑΣ'}">
                                        <c:set var="Income" value="#ff66ff"/>  
                                    </c:if>

                                    <c:if test = "${sale.mylead == 'ΜΗ ΠΩΛΗΣΗ - ΚΑΤΑΣΤΗΜΑ'}">
                                        <c:set var="Income" value="red"/>  
                                    </c:if>
                                    
                                    
                                    <c:if test = "${sale.mylead == 'ΜΗ ΠΩΛΗΣΗ - ΔΕΝ ΕΝΔΙΑΦΕΡΕΤΑΙ'}">
                                        <c:set var="Income" value="red"/>  
                                    </c:if>

                                    <c:if test = "${sale.mylead == 'ΜΗ ΠΩΛΗΣΗ - ΚΟΚΚΙΝΟ ΦΑΝΑΡΙ'}">
                                        <c:set var="Income" value="red"/>  
                                    </c:if>

                                    <c:if test = "${sale.mylead == 'ΜΗ ΠΩΛΗΣΗ - ΠΟΛΛΑΠΛΑ SR'}">
                                        <c:set var="Income" value="red"/>  
                                    </c:if>
                                    
                                    <c:if test = "${sale.mylead == 'ΜΗ ΠΩΛΗΣΗ - ΔΕΝ ΕΠΙΘΥΜΕΙ ΕΝΗΜΕΡΩΣΗ'}">
                                        <c:set var="Income" value="red"/>  
                                    </c:if>

                                    <c:if test = "${sale.mylead == 'ΜΗ ΠΩΛΗΣΗ - 13888'}">
                                        <c:set var="Income" value="red"/>  
                                    </c:if>

                                    <c:if test = "${sale.mylead == 'ΜΗ ΠΩΛΗΣΗ - BUSINESS'}">
                                        <c:set var="Income" value="red"/>  
                                    </c:if>


                                    <c:if test = "${sale.mylead == 'ΜΗ ΠΩΛΗΣΗ - ΚΑΤΑΣΤΗΜΑ'}">
                                        <c:set var="Income" value="blue"/>  
                                    </c:if>


                                    <c:if test = "${sale.mylead == 'ΠΩΛΗΣΗ'}">
                                        <c:set var="Income" value="green"/>  
                                    </c:if>  


                                    <tr style="color:<c:out value="${Income}"/> ">
                                        <td>${sale.id}</td>
                                        <td>${sale.name}</td>
                                        <td>${sale.stathero}</td>
                                        <td>${sale.kinito}</td>
                                        <td>${sale.perioxi}</td>
                                        <td>${sale.eidospolisis}</td>
                                        <td>${sale.notes}</td>
                                        <td>${sale.mylead}</td>
                                        <td>${sale.mydate}</td>

                                        <td>      
                                            <a href="${pageContext.request.contextPath}/admin/update/${sale.id}" 
                                               class="btn btn-info btn-xs" role="button" data-toggle="tooltip" title="${sale.notes}">Update</a>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/admin/delete?id=${sale.id}" 
                                               class="btn btn-danger btn-xs" role="button">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>     
                        </div>
                    </div>

                    </div>


                    <div class="well">                
                        <jsp:include page="footer.jsp" />  
                    </div>

                    </div><!--container -->




                    <script type="text/javascript">
                        function clearFilter() {
                            window.location = '/admin';
                        }
                    </script>

                    </body>
                    </html>