<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<form action="/admin">

    <div class="col-sm-3">
        <input type="text" name="keyword" class="form-control form-control-sm" placeholder="Filter"/>  
    </div>
    &nbsp&nbsp
    <button type="submit" value="Search" class="btn btn-info btn-sm"/>
        Search &nbsp
        <span class="glyphicon glyphicon-search"></span>
    </button>


<a href="/admin" role="button" class="btn btn-info btn-sm">Home</a>

<a href="/fiber" role="button" class="btn btn-info btn-sm">Fibers</a>




<!--a class="btn btn-outline-success" href="z0000.All_Tables.php">All Tables together</a-->

</form>
<br/>
<form:form action="/logout" method="POST">
    <input type="submit" value="Logout" class="btn btn-info btn-sm">
</form:form>  

<!-- It is the ListBox that we see the results of Autocomplete search -->
<div class="col-md-5" style="position: relative;margin-top: -0px;margin-left: -15px;">
    <div class="list-group" id="show-list">
        <!-- Here autocomplete list will be display -->
    </div>
</div>