<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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

        <title>SalesForm.jsp</title>
    </head>
    <body>
        <div class="container">
            
            <div class="well">                
                <jsp:include page="horizontal_menu_main.jsp" />  
            </div>

            <div class="well">
                <h1 class="text-danger text-center">Create or Update your Sale</h1>
            </div>



            <div class="well">
                <c:if test="${poliths!=null}">
                    <c:url value="/admin/create" var="link"/>
                </c:if>

                <c:if test="${poliths==null}">
                    <c:url  value="/admin/update" var="link"/>
                </c:if>


                <form:form action="${link}" method="post" modelAttribute="poliths">

                    <form:hidden path="id"/>            
                    <br/>

                    <div class="form-group row">
                        <label for="cname" class="col-sm-1 col-form-label text-info">name:</label>
                        <div class="col-sm-4">
                            <form:input id="cname" path="name" class="form-control" maxlength="45"/>       
                            <form:errors path="name" class="text-danger"/>
                        </div>
                    </div>


                    <div class="form-group row">
                        <label for="stathero" class="col-sm-1 col-form-label text-info">stathero:</label>
                        <div class="col-sm-3">
                            <form:input id="stathero" path="stathero" class="form-control" maxlength="10"/>
                            <form:errors path="stathero" class="text-danger"/>
                        </div>
                    </div>



                    <div class="form-group row">
                        <label for="kinito" class="col-sm-1 col-form-label text-info">kinito:</label>
                        <div class="col-sm-3">
                            <form:input id="kinito" path="kinito" class="form-control" maxlength="10"/>
                            <form:errors path="kinito" class="text-danger"/>
                        </div>
                    </div>




                    <div class="form-group row">
                        <label for="perioxi" class="col-sm-1 col-form-label text-info">perioxi:</label>

                        <div class="col-sm-3">
                            <form:select id="perioxi" path="perioxi" class="form-control">
                                <c:forEach items="${listOfCities}" var="city">
                                    <form:option value="${city}">${city}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>



                    <div class="form-group row">        
                        <label for="eidospolisis" class="col-sm-1 col-form-label text-info">eidospolisis:</label>

                        <div class="col-sm-3">
                            <form:select id="eidospolisis" path="eidospolisis" class="form-control">
                                <c:forEach items="${listOfEidosPolisis}" var="city">
                                    <form:option value="${city}">${city}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>


                    <div class="form-group row">
                        <label for="notes" class="col-sm-1 col-form-label text-info">notes:</label>
                        <div class="col-sm-10">
                            <form:input id="notes" path="notes" class="form-control" maxlength="1000"/> 
                            <form:errors path="notes" class="text-danger"/>
                        </div>
                    </div>    


                    <div class="form-group row">   
                        <label for="mylead" class="col-sm-1 col-form-label text-info">mylead:</label>

                        <div class="col-sm-3">
                            <form:select id="mylead" path="mylead" class="form-control">
                                <c:forEach items="${listOfMyLead}" var="city">
                                    <form:option value="${city}">${city}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>


                    <div class="form-group row"> 
                        <label for="mydate" class="col-sm-1 col-form-label text-info">mydate:</label>

                        <div class="col-sm-3">
                            <form:input id="mydate" type="date" path="mydate" class="form-control"/>    
                            <form:errors path="mydate" class="text-danger"/>
                        </div>
                    </div>


                    <br/>
                    <input type="submit" value="Submit" class="btn btn-success btn-sm"/>
                </form:form>
                    
            </div><!-- end of well-->
            
            <div class="well">                
                <jsp:include page="footer.jsp" />  
            </div>
            
        </div><!-- end of container-->
    </body>
</html>
