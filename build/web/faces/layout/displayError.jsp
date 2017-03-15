<%-- 
    Document   : displayError
    Created on : 3 févr. 2016, 22:34:35
    Author     : 15256
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty error}">
    <div class="alert alert-dismissible alert-danger">
        <button type="button" class="close" data-dismiss="alert">x</button>
        <strong>Error!</strong>  ${error}
    </div>
</c:if>
